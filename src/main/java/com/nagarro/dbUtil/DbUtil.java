package com.nagarro.dbUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.jpa.HibernatePersistenceProvider;

import com.nagarro.entity.StatementEntity;


public class DbUtil {
	
			
	
	private static final String PERSISTENCE_UNIT_NAME = "JSFJPACrud";

	
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	
	@SuppressWarnings("unchecked")
	public static List<StatementEntity> getAllStatementEntity() {
		Query queryObj = entityMgrObj.createQuery("SELECT s FROM StatementEntity s");
		List<StatementEntity> stList = queryObj.getResultList();
		if (stList != null && stList.size() > 0) {			
			return stList;
		} else {
			return null;
		}
	}

	
	@SuppressWarnings("unchecked")
	public static List<StatementEntity> getAllStatementEntityForAccountId(int id) {
		Query queryObj = entityMgrObj.createQuery("SELECT s FROM StatementEntity s where account_id="+id);
		List<StatementEntity> stList = queryObj.getResultList();
		if (stList != null && stList.size() > 0) {			
			return stList;
		} else {
			return null;
		}
	}
	
	
	
	

	
	
}//End Class
