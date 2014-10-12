package org.ana.wcmp.coop;

import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 此类是数据库服务类，集合了某方面的多种数据库操作，其方法写法如下：
 * 
 * 方法一定是动态的；
 * 
 * 传入传出值已经在MgrClass的注释中做了详细介绍，请务必遵守；
 * 
 * 数据库操作方法采用Hibernate编写，尽量利用对象化的操作进行，尽量少使用SQL或HQL，尤其不要拼接SQL或HQL语句；
 * 
 * 方法中产生错误，一律抛出DBServiceException，传至上层处理；
 * 
 * 
 * 下面是方法结构示例，具体方法请直接到org.ana.wcmp.database.service中查看
 * @author Godrick
 * @date 2014年10月18日
 */
public class SVCClass {
	
	//此处示例结构不含传入值及返回值，若有，请另行建立数据库到模型层的DTO，不要直接利用DAO类
	public void structureExample() 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
	    Transaction tx = session.beginTransaction();
	    
	    try{
	    	//此处开始数据库操作
	    	
	    	tx.commit();//此语句要跟在try块中所有return操作之前；   	
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
