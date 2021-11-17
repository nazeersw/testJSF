package com.nagarro.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.nagarro.common.UserCache;
import com.nagarro.dbUtil.DbUtil;
import com.nagarro.dbUtil.JdbcUtil;
import com.nagarro.entity.StatementEntity;
import com.nagarro.util.Account;
import com.nagarro.util.myStatement;

@ManagedBean(name = "statementController")
@SessionScoped
public class StatementController implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	@ManagedProperty(value = "#{userCache}")
    private UserCache userCache;

	
	SimpleDateFormat format = 
	        new SimpleDateFormat("dd.MM.yyyy");
	
	


	private JdbcUtil myjdbc;
	private List<myStatement> statements;
    private int id;
    private Date  sdate;
    private Date  edate;
    private String samount;
    private String eamount;
    



    public void process() throws SQLException {

    	
    	if(userCache.getCurrentUser().getType()==1) //its admin
    	{    	
    	
    	if(this.sdate!=null && this.edate!=null)
    	{
    		
    		searchByDate(this.id,format.format(this.sdate), format.format(this.edate));
    	
    	
    	}
    	
    	else if(!this.samount.isEmpty() && !this.eamount.isEmpty()) 

                  		
    		this.searhByAmount(this.id, this.samount, this.eamount);  	
  
    	}
    	
    	else 
    	{
    		Date threeMonthAgo = Date.from(LocalDateTime.now().minusMonths(3).toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
    
    	    Date now=new Date(); 
    	    searchByDate(this.id,format.format(threeMonthAgo), format.format(now));    	    
  		
    		
    		
    	}	
    	
    	
    	
    }
    

	public String getSamount() {
		return samount;
	}


	public void setSamount(String samount) {
		this.samount = samount;
	}


	public String getEamount() {
		return eamount;
	}


	public void setEamount(String eamount) {
		this.eamount = eamount;
	}


	public  StatementController() throws SQLException  {
   
		statements=new ArrayList<myStatement>()	;	

		myjdbc=JdbcUtil.getInstance();
		
        
    }
    
    
	
	
	
	
public void searchByAccountId(int accountId) throws SQLException{
	
	statements.clear();
	statements.addAll(myjdbc.getStatementsByAccountId(accountId));
	
}


public void searchByDate(int accountId,String start,String end) throws SQLException{
	statements.clear();
	statements.addAll(myjdbc.searchByDate(accountId,start,end));
	
	
	
} 


public void searhByAmount(int accountId,String samount,String eamount) throws SQLException
{

	statements.clear();
	statements.addAll(myjdbc.searchByAmount(accountId,samount,eamount));
	

}

	public List<myStatement> getStatements() {
		return statements;
	}


	public void setStatements(List<myStatement> statements) {
		this.statements = statements;
	}
	

    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date  getSdate() {
		return sdate;
	}


	public void setSdate(Date  sdate) {
		this.sdate = sdate;
	}


	public Date  getEdate() {
		return edate;
	}


	public void setEdate(Date  edate) {
		this.edate = edate;
	}


	public UserCache getUserCache() {
		return userCache;
	}


	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

	

	
}//End class
