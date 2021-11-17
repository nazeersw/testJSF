package com.nagarro.common;

public class User {
	
	private String Uname;
	private String Password;
	//0,1
	private int type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public User(String Uname,String Password,int type)
	{
		this.Uname=Uname;
		this.Password=Password;
	    this.type=type;	
		
	}
	

}
