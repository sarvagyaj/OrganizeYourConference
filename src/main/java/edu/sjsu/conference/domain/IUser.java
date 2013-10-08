package edu.sjsu.conference.domain;

public interface IUser {
	
	public String name ="";
	public long id =0;
	public String email="";
	public String location="";

	public void getProfile();
	public void validateUser();
}
