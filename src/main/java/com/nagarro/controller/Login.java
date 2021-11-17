package com.nagarro.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.nagarro.common.User;
import com.nagarro.common.UserCache;
import com.nagarro.dbUtil.JdbcUtil;

@ManagedBean(name = "loginController")
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{userCache}")
    private UserCache userCache;
	

    private String password;
    private String message, uname;
    
    private boolean isLogin=false;
    private JdbcUtil myjdbc;    
    
    @PostConstruct
    private void init() {
    	
    	myjdbc=JdbcUtil.getInstance();
    	
    }
    
    
	public boolean getisLogin() {
		return isLogin;
	}
	public void setisLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	public String login() {
		User loggedUser;
		int type=myjdbc.chkUser(uname, password);	
		
		if(type==0) // not found
		{
			FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Login!",
	                "Please Try Again!"));
	
			
		}
                
		else 
		
		{
			loggedUser=new User(uname,password,type);
			userCache.setCurrentUser(loggedUser);
	
			return "statement";
		}
		
	
		
		return "";
		
	
		
	}
	
	
	
public String logout()
{	
	
    userCache.removeCurrentUser();
    
    javax.faces.context.FacesContext ctx = javax.faces.context.FacesContext.getCurrentInstance();
    
    HttpSession sess = (HttpSession) ctx.getExternalContext().getSession(false);
    sess.invalidate();
	
	
    
    
    try {
		ctx.getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath()+"/home.xhtml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    
	
	
	
	return "";

}
	
	
public UserCache getUserCache() {
	return userCache;
}
public void setUserCache(UserCache userCache) {
	this.userCache = userCache;
}
	
	
	
}//End class
