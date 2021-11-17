package com.nagarro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	int ID;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	@Column(name = "account_type")
	String account_type;
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	@Column(name = "account_number")
	String account_number;
	
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
	
//-----------------relation account to statment-----------------//
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "obj_AccountEntity")
	private Set<StatementEntity> set_StatementEntity = new HashSet<StatementEntity>();

	public Set<StatementEntity> getSet_StatementEntity() {
		return set_StatementEntity;
	}
	public void setSet_StatementEntity(Set<StatementEntity> set_StatementEntity) {
		this.set_StatementEntity = set_StatementEntity;
	}
	
	
	

}
