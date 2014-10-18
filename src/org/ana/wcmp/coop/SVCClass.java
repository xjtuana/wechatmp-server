package org.ana.wcmp.coop;

import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * ���������ݿ�����࣬������ĳ����Ķ������ݿ�������䷽��д�����£�
 * 
 * ����һ���Ƕ�̬�ģ�
 * 
 * ���봫��ֵ�Ѿ���MgrClass��ע����������ϸ���ܣ���������أ�
 * 
 * ���ݿ������������Hibernate��д���������ö��󻯵Ĳ������У�������ʹ��SQL��HQL�����䲻Ҫƴ��SQL��HQL��䣻
 * 
 * �����в�������һ���׳�DBServiceException�������ϲ㴦��
 * 
 * 
 * �����Ƿ����ṹʾ�������巽����ֱ�ӵ�org.ana.wcmp.database.service�в鿴
 * @author Godrick
 * @date 2014��10��18��
 */
public class SVCClass {
	
	//�˴�ʾ���ṹ��������ֵ������ֵ�����У������н������ݿ⵽ģ�Ͳ��DTO����Ҫֱ������DAO��
	public void structureExample() 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
	    Transaction tx = session.beginTransaction();
	    
	    try{
	    	//�˴���ʼ���ݿ����
	    	
	    	tx.commit();//�����Ҫ����try��������return����֮ǰ��   	
	    	return;
	    } catch (Exception e){
	    	e.printStackTrace();
	    	tx.rollback();
			
			throw new DBServiceException();
	    } finally {
	    	HibernateUtil.closeSession();
	    }
	}

}
