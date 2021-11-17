package com.nagarro.util;

public class myStatement {
	
	private int ID; 
	
	private  int account_id; 
	
	private  String datefield; 
	
	private  String amount;
	
	public myStatement() {}
	public myStatement(int ID,int account_id,String datefield,String amount)
	{
		this.ID=ID;
		this.account_id=account_id;
		this.datefield=datefield;
		this.amount=amount;
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getDatefield() {
		return datefield;
	}

	public void setDatefield(String datefield) {
		this.datefield = datefield;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	

}
