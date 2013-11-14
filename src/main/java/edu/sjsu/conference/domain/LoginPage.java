package edu.sjsu.conference.domain;


public class LoginPage {
	protected String username;
	protected String password;
	protected String type="Organizer";
	
	
	public String getusername()
	{
		return username;
	}
	public void setusername(String s){username=s;}
	public void setpassword(String p){password=p;}
	public String getpassword()
	{
	return password;
	}
	public String gettype()
	{
		return type;
	}
	public void settype(String s){
		type=s;
		}
}
