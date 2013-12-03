package edu.sjsu.conference.domain;

import edu.sjsu.conference.controller.AWSSNS;

public class AwsService
{
	private static AWSSNS sns;

	private AwsService() 
	{

	}

	public static AWSSNS create()
	{
		if(sns == null)
		{
			System.out.println("SNS is NULL");
			sns = new AWSSNS();
		}

		return sns;
	}
}