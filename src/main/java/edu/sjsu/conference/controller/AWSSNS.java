package edu.sjsu.conference.controller;

import edu.sjsu.conference.domain.Subscriber;

import java.util.*;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.Topic;
import edu.sjsu.conference.config.SNSConfig;

/**
 *
 */
public class AWSSNS {
       //private HashMap<String, Subscriber> subscriberList;
    private List<String> subscriberList;

    public AWSSNS()
    {
        //subscriberList = new HashMap<String, Subscriber>();
        subscriberList = new ArrayList<String>();
    }

    public void addSubscribers(String[] emailIdList)
    {
        // prepare the credentials
        String accessKey = SNSConfig.ACCESS_KEY;
        String secretKey = SNSConfig.SECRET_KEY;

        // create the SNS service
        AmazonSNS snsService = new AmazonSNSClient(
                                    new BasicAWSCredentials(accessKey, secretKey));

        // SET TO THE PREFERRED REGION
        // set the endpoint for us-west-1 region
        snsService.setEndpoint("https://sns.us-west-1.amazonaws.com");
        
        this.run(snsService, emailIdList);
    }

    public void run(AmazonSNS snsService, String[] aEndPointList) {
        
        //-- List topics --//
        List<Topic> topics = listTopics(snsService);
        System.out.println(subscriberList.size());
        
        //-- Subscribe to topic via email --//
        // subscribe to all the topics listed
        for(int i=0; i < aEndPointList.length; i++)
        {
            String emailAddress = aEndPointList[i];
            System.out.println(emailAddress);
            if (subscriberList.contains(emailAddress))
            {
                continue;
            }

            System.out.println("Email address not subscribed. So adding");
            Subscriber s = new Subscriber(emailAddress, topics, snsService);
            if(s!=null)
            {
                //subscriberList.put(emailAddress, s);
                subscriberList.add(emailAddress);
                s.subscribe();
            }
            System.out.println(subscriberList.size());
        }

               
        //-- Publish on a topic --//
        // send a notification for all topics
        for (Topic topic : topics) {
            publish(snsService, topic);
        }
    }

    public void publish(AmazonSNS snsService, Topic topic) {
        String topicARN = topic.getTopicArn(); 

        snsService.publish(new PublishRequest(topicARN,
                                              "This is a test msg!", 
                                              "Test SNS"));
    }

    private List<Topic> listTopics(AmazonSNS snsService) {
        
        // call the web service
        ListTopicsResult result = snsService.listTopics(new ListTopicsRequest());

        System.out.println("Topics: " + result.getTopics());
        
        // get that list of topics
        return result.getTopics();
    }
}