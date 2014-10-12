package org.ana.wcmp.database.service;

import org.ana.wcmp.database.dao.BasicUserDAO;
import org.ana.wcmp.database.dao.WechatUserDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.ana.wcmp.db2modelVO.basicUser.IO_BasicUserVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class BasicUserSVC {
	
	public IO_BasicUserVO getBasicInfoByOpenid(IO_BasicUserVO inputuser) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			Criteria wcusercri = session.createCriteria(WechatUserDAO.class);
			wcusercri.add(Restrictions.eq("wechat_user_openid", inputuser.getUser_wechat_openid()));
			WechatUserDAO wcuser = (WechatUserDAO) wcusercri.list().get(0);
			BasicUserDAO basicinfo = wcuser.getWechat_user_basic();
			if (basicinfo == null){
				tx.commit();
				return null;
			}
			inputuser.setBasic_user_id(basicinfo.getPk_basic_user());
			inputuser.setBasic_user_building(basicinfo.getBasic_user_building());
			inputuser.setBasic_user_ip(basicinfo.getBasic_user_ip());
			inputuser.setBasic_user_name(basicinfo.getBasic_user_name());
			inputuser.setBasic_user_netid(basicinfo.getBasic_user_netid());
			inputuser.setBasic_user_room(basicinfo.getBasic_user_room());
			inputuser.setBasic_user_stuid(basicinfo.getBasic_user_stuid());
			tx.commit();
			
			return inputuser;
		} catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			
			throw new DBServiceException();
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
