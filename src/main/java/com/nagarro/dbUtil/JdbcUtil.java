package com.nagarro.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.nagarro.common.User;
import com.nagarro.entity.StatementEntity;
import com.nagarro.util.myStatement;

public class JdbcUtil {

	private static String databaseURL = "jdbc:ucanaccess://c://accountsdb.accdb";
	private static JdbcUtil instance;
    private Connection connection;
	
	public static JdbcUtil getInstance() {
		if(instance == null) {
			instance=new JdbcUtil();
		}
		return instance;
		
		
	}
	
	
	private JdbcUtil() {
		connection=getConnect();
		
	}
	

private Connection getConnect() {
	Connection connection =null;	
 try {
	 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	 connection=DriverManager.getConnection(databaseURL);
	 
} catch (SQLException | ClassNotFoundException e) {

	e.printStackTrace();
}	

return connection;
} 	
	
	
/**
 * get all statments
 * @return
 * @throws SQLException
 */
public  List<myStatement> getAllStatementEntity() throws SQLException {

	connection=getConnect();
	
	List<myStatement> lstStatment=new ArrayList<myStatement>();	
	
try {

	String sql = "SELECT * FROM statement";
    
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(sql);
     
    while (result.next()) {
     
    	int id = result.getInt("ID");
    	String d=result.getString("datefield");
    	String amount=result.getString("amount");
    	
     
        myStatement stat=new myStatement();
        stat.setID(id);
        stat.setDatefield(d);
        stat.setAmount(amount);
        lstStatment.add(stat);        
            
    }
    return lstStatment;
	
}
finally {
	connection.close();
}
	
	
	
}



public  List<myStatement> getStatementsByAccountId(int accountId) throws SQLException {

	connection=getConnect();
	
	List<myStatement> lstStatment=new ArrayList<myStatement>();	
	
try {

	String sql = "SELECT * FROM statement where account_id="+accountId ;
    
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(sql);
     
    while (result.next()) {
     
    	int id = result.getInt("ID");
    	String d=result.getString("datefield");
    	String amount=result.getString("amount");
    	
     
        myStatement stat=new myStatement();
        stat.setID(id);
        stat.setDatefield(d);
        stat.setAmount(amount);
        lstStatment.add(stat);        
            
    }
    return lstStatment;
	
}
finally {
	connection.close();
}
	
	
	
}



/**
 * 
 * @param accountId
 * @param start
 * @param end
 * @return
 * @throws SQLException
 */

public  List<myStatement> searchByDate(int accountId,String start,String end) throws SQLException {

	connection=getConnect();
	
	List<myStatement> lstStatment=new ArrayList<myStatement>();	
	
try {

	String sql = "SELECT * FROM statement where account_id="+accountId
	+" AND datefield > '"+start+"' And datefield < '"+end+"'";		
			
			
    
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(sql);
     
    while (result.next()) {
     
    	int id = result.getInt("ID");
    	String d=result.getString("datefield");
    	String amount=result.getString("amount");
    	
     
        myStatement stat=new myStatement();
        stat.setID(id);
        stat.setDatefield(d);
        stat.setAmount(amount);
        lstStatment.add(stat);        
            
    }
    return lstStatment;
	
}
finally {
	connection.close();
}
	
	
	
}


/**
 * 
 * @param start
 * @param end
 * @return
 * @throws SQLException
 */

public  List<myStatement> searchByDate(String start,String end) throws SQLException {

	connection=getConnect();
	
	List<myStatement> lstStatment=new ArrayList<myStatement>();	
	
try {

	String sql = "SELECT * FROM statement where" 
	+" datefield > "+start+" AND datefield < "+end;		
			
			
    
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(sql);
     
    while (result.next()) {
     
    	int id = result.getInt("ID");
    	String d=result.getString("datefield");
    	String amount=result.getString("amount");
    	
     
        myStatement stat=new myStatement();
        stat.setID(id);
        stat.setDatefield(d);
        stat.setAmount(amount);
        lstStatment.add(stat);        
            
    }
    return lstStatment;
	
}
finally {
	connection.close();
}
	
	
	
}



/**
 * 
 * @param accountId
 * @param start
 * @param end
 * @return
 * @throws SQLException
 */


public  List<myStatement> searchByAmount(int accountId,String start,String end) throws SQLException {

	connection=getConnect();
	
	List<myStatement> lstStatment=new ArrayList<myStatement>();	
	
try {

	String sql = "SELECT * FROM statement where account_id="+accountId
	+" AND amount > "+start+" AND amount < "+end+"";		
			
			
			
    
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(sql);
     
    while (result.next()) {
     
    	int id = result.getInt("ID");
    	String d=result.getString("datefield");
    	String amount=result.getString("amount");
    	
     
        myStatement stat=new myStatement();
        stat.setID(id);
        stat.setDatefield(d);
        stat.setAmount(amount);
        lstStatment.add(stat);        
            
    }
    return lstStatment;
	
}
finally {
	connection.close();
}
	
	
	
}




//check user

public int chkUser(String uname,String password) 
{
	
	if(uname.equals("testadmin") && password.equals("adminpassword"))
	{
		return 1;	
		
	}
	
	if(uname.equals("testUser") && password.equals("userpassword"))
	{
		
		return 2;	
		
	}
	
	
return 0;	
	
}



	
	
}//End class
