package edu.sjsu.conference.domain;

import java.util.List;

import com.amazonaws.services.sns.model.Topic;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.SubscribeRequest;

public class Subscriber
{
	public String emailId;

	public Boolean subscribed;

	public List<Topic> subscriptionTopics;

	private AmazonSNS service;

	public Subscriber(String aEmail, List<Topic> aTopics, AmazonSNS aService)
	{
		emailId = aEmail;
		subscriptionTopics = aTopics;
		service = aService;
		subscribed = false;
	}

	public void subscribe()
	{
		// If already subscribed, do nothing
		if(subscribed)
			return;

		System.out.println("subscribe(): Not yet subscribed");
		for(Topic topic : subscriptionTopics)
		{
			String topicARN = topic.getTopicArn(); 

        	// subscribe the user to the topic with protocol = "email"
        	service.subscribe(new SubscribeRequest(topicARN, "email", emailId));
        }

        subscribed = true;
	}
}