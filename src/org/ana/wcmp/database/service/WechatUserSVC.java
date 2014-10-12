package org.ana.wcmp.database.service;

import java.util.Calendar;
import java.util.List;

import org.ana.wcmp.database.dao.WechatUserDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.ana.wcmp.db2modelVO.wechatUser.IO_SubWechatUserVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public class WechatUserSVC {
	
	public void subscribeChange(IO_SubWechatUserVO user) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Criteria usercri = session.createCriteria(WechatUserDAO.class);
			usercri.add(Restrictions.eq("wechat_user_openid", user.getOpenid()));
			List<WechatUserDAO> tryfinduser = usercri.list();
			if (tryfinduser == null || tryfinduser.size() <= 0) {
				WechatUserDAO newuser = new WechatUserDAO();
				Calendar subtime = Calendar.getInstance();
				subtime.setTimeInMillis(user.getSubtime());
				newuser.setWechat_user_sub_time(subtime);
				newuser.setWechat_user_openid(user.getOpenid());
				newuser.setWechat_user_status(user.getStatus());
				session.save(newuser);
			} else {
				WechatUserDAO thisuser = tryfinduser.get(0);
				thisuser.setWechat_user_status(user.getStatus());
				if (user.getStatus() == 1){
					Calendar subtime = Calendar.getInstance();
					subtime.setTimeInMillis(user.getSubtime());
					thisuser.setWechat_user_sub_time(subtime);
				} else {
					Calendar unsubtime = Calendar.getInstance();
					unsubtime.setTimeInMillis(user.getUnsubtime());
					thisuser.setWechat_user_unsub_time(unsubtime);
				}
				session.saveOrUpdate(thisuser);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			
			throw new DBServiceException();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public boolean isBasicBound(IO_SubWechatUserVO user) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Criteria usercri = session.createCriteria(WechatUserDAO.class);
			usercri.add(Restrictions.eq("wechat_user_openid", user.getOpenid()));
			List<WechatUserDAO> tryfinduser = usercri.list();
			if (tryfinduser == null || tryfinduser.size() <= 0) {
				WechatUserDAO newuser = new WechatUserDAO();
				Calendar subtime = Calendar.getInstance();
				newuser.setWechat_user_sub_time(subtime);
				newuser.setWechat_user_openid(user.getOpenid());
				newuser.setWechat_user_status(1);
				session.save(newuser);
				tx.commit();
				return false;
			} 
			WechatUserDAO thisuser = tryfinduser.get(0);
			if (thisuser.getWechat_user_basic() == null){
				tx.commit();
				return false;
			}
			tx.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			
			throw new DBServiceException();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public boolean isActivatedUser(IO_SubWechatUserVO user) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Criteria usercri = session.createCriteria(WechatUserDAO.class);
			usercri.add(Restrictions.eq("wechat_user_openid", user.getOpenid()));
			List<WechatUserDAO> tryfinduser = usercri.list();
			if (tryfinduser == null || tryfinduser.size() <= 0) {
				WechatUserDAO newuser = new WechatUserDAO();
				Calendar subtime = Calendar.getInstance();
				newuser.setWechat_user_sub_time(subtime);
				newuser.setWechat_user_openid(user.getOpenid());
				newuser.setWechat_user_status(1);
				session.save(newuser);
				tx.commit();
				return true;
			} 
			WechatUserDAO thisuser = tryfinduser.get(0);
			if (thisuser.getWechat_user_status() == null || thisuser.getWechat_user_status() != 1){
				tx.commit();
				return false;
			}
			tx.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			
			throw new DBServiceException();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
