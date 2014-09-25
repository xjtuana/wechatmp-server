package org.ana.wcmp.test;

import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	
	public static void main(String args[]){
			Session s = HibernateUtil.currentSession();
			Transaction tx = s.beginTransaction();
			
			tx.commit();
			HibernateUtil.closeSession();
	}

}
