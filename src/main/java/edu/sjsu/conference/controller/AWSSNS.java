package edu.sjsu.conference.controller;

import java.util.*;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.Topic;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;

import edu.sjsu.conference.config.SNSConfig;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 */
public class AWSSNS implements Job {
    //private HashMap<String, Subscriber> subscriberList;
    private List<String> subscriberList;
    private static AmazonSNS snsService;
    private static String topicName;

    public AWSSNS()
    {
        //subscriberList = new HashMap<String, Subscriber>();
        subscriberList = new ArrayList<String>();
    }

    public void addSubscribers(String[] emailIdList, int cId, String aTopic)
    {
        // prepare the credentials
        String accessKey = SNSConfig.ACCESS_KEY;
        String secretKey = SNSConfig.SECRET_KEY;

        // create the SNS service
        snsService = new AmazonSNSClient(new BasicAWSCredentials(accessKey, secretKey));

        // SET TO THE PREFERRED REGION
        // set the endpoint for us-west-1 region
        snsService.setEndpoint("https://sns.us-west-1.amazonaws.com");
        
        this.run(emailIdList, cId, aTopic);
    }

    public void run(String[] aEndPointList, int cId, String aTopic) 
    {
        //Create Topic
    	this.topicName = aTopic +"_"+ Integer.toString(cId);// for execute method - dont change
        String topicName = aTopic.replaceAll("\\s+","")+"_"+Integer.toString(cId);
        CreateTopicResult ret = snsService.createTopic(topicName);
        String topicArn = ret.getTopicArn();
       
        ListSubscriptionsByTopicResult result = snsService.listSubscriptionsByTopic(topicArn);
        List<Subscription> subscriptionList = result.getSubscriptions();

        //-- List topics --//
        System.out.println(subscriptionList.size());
        
        //-- Subscribe to topic via email --//
        for(int i=0; i < aEndPointList.length; i++)
        {
            String emailAddress = aEndPointList[i];
            System.out.println(emailAddress);

            // Check if the email address is already in the subsciption list
            if (isAlreadySubscribed(subscriptionList, emailAddress))
            {
                continue;
            }
            
            snsService.subscribe(new SubscribeRequest(topicArn, "email", emailAddress));
        }
    }

    private Boolean isAlreadySubscribed(List<Subscription> aSubscriptionList, String aEmailAddress) 
    {
        for(int j = 0; j < aSubscriptionList.size(); j++)
        {
            Subscription subscription = aSubscriptionList.get(j);
            if( subscription != null && 
                subscription.getEndpoint().compareToIgnoreCase(aEmailAddress) == 0 )
            {
                return true;
            }
        }

        return false;
    }

    private List<Topic> listTopics(AmazonSNS snsService) 
    {   
        // call the web service
        ListTopicsResult result = snsService.listTopics(new ListTopicsRequest());

        System.out.println("Topics: " + result.getTopics());
        
        // get that list of topics
        return result.getTopics();
    }

	//Scheduler for every 60 secs
    public void execute(JobExecutionContext context) throws JobExecutionException 
    {
        // 1. For each topic, get the subscribers' list
        try {

        ListTopicsResult result = snsService.listTopics();
        List<Topic> topicList   = result.getTopics();

        if(topicList.isEmpty())
        {
            System.out.println("No Topics.");
            return;
        }

        for(Topic topic : topicList)
        {
            String topicARN = topic.getTopicArn();
           
            List<Subscription> subscriptionList = snsService.listSubscriptionsByTopic(topicARN)
                                                  .getSubscriptions();
            
            if(subscriptionList.isEmpty())
            {
                System.out.println("No subscribers. Deleting the topic : "+topicARN);
                snsService.deleteTopic(topicARN);
                continue;
            }

            for(int j = 0; j < subscriptionList.size(); j++)
            {
                Subscription subscription = subscriptionList.get(j);
                if( subscription != null )
                {
                    String subArn = subscription.getSubscriptionArn();
                    if(subArn.toLowerCase().contains("pending"))
                    {
                        System.out.println("Subscription is pending - "+subscription.getEndpoint());
                        continue;
                    }
                    int id=0;
                    String topic_name="";
                    
                    if(this.topicName != null){
	                    topic_name = this.topicName.split("_")[0];
	                    if(this.topicName.split("_")[1] != null)
	                    	id = Integer.parseInt(this.topicName.split("_")[1]);
                    }
                    System.out.println("Publishing msg to "+subscription.getEndpoint());
                    
                    String message = "Hello Friend, \n \t We would like to invite you to attend an conference on '"
                    + topic_name + "'. If you are interested please click the below link: \n" +
                    		"http://localhost:8080/organize-your-conference/RSVPForm/" + id
                    		+"\n\n\n Thanks,\n Organize your conference team";
                    snsService.publish(topicARN,message, "Register for the Conference");
                    snsService.unsubscribe(subArn);
                }
            }
        }

        } catch(Exception e) {
            System.out.println("Caught Exception : " + e.toString());
        }
    }
}