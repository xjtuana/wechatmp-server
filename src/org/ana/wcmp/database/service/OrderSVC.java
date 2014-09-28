package org.ana.wcmp.database.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.ana.wcmp.database.dao.OrderDAO;
import org.ana.wcmp.database.dao.StaffDAO;
import org.ana.wcmp.database.dao.StaffOrderRelDAO;
import org.ana.wcmp.database.dao.WechatUserDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.db2model.order.vo.IN_NewOrderVO;
import org.hibernate.Criteria;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.ana.wcmp.database.hibernate.HibernateUtil;

@SuppressWarnings("unchecked")
public class OrderSVC {
	
	public void addNewOrder(IN_NewOrderVO neworder) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
	    Transaction tx = session.beginTransaction();
	    LobHelper l = session.getLobHelper();

		try {
			OrderDAO dborder = new OrderDAO();
			dborder.setOrder_client_name(neworder.getOrder_client_name());
			dborder.setOrder_client_building(neworder.getOrder_client_building());
			dborder.setOrder_client_netid(neworder.getOrder_client_netid());
			dborder.setOrder_client_room(neworder.getOrder_client_room());
			dborder.setOrder_client_phone(neworder.getOrder_client_phone());
			dborder.setOrder_certification_code(neworder.getOrder_certification_code());
			if (neworder.getOrder_fault_desc() != null){
				dborder.setOrder_fault_desc(l.createBlob(
						neworder.getOrder_fault_desc().getBytes("utf-8")));
			}
			dborder.setOrder_resv_time(neworder.getOrder_resv_time());
			dborder.setOrder_add_time(Calendar.getInstance());
			dborder.setOrder_status(neworder.getOrder_status());
			
			if (neworder.getOrder_client_wechat_user_openid() != null ){
				Criteria wcusercri = session.createCriteria(WechatUserDAO.class);
				wcusercri.add(Restrictions.eq("wechat_user_openid", neworder.getOrder_client_wechat_user_openid()));
				wcusercri.add(Restrictions.eq("wechat_user_status", 1));
				List<WechatUserDAO> wcuserlist = wcusercri.list();
				dborder.setOrder_client_wechat_user(wcuserlist.get(0));
			}
			
			session.save(dborder);
			
			if (neworder.getOrder_supposed_staff() != null && neworder.getOrder_supposed_staff().length > 0){
				long[] staff_ids = neworder.getOrder_supposed_staff();
				Criteria staffcri = session.createCriteria(StaffDAO.class);
				List<Criterion> staffidcri = new ArrayList<Criterion>();
				for (int i = 0; i < staff_ids.length; i++){
					staffidcri.add(Restrictions.eq("pk_staff", staff_ids[i]));
				}
				staffcri.add(Restrictions.or(staffidcri.toArray(new Criterion[0])));
				staffcri.add(Restrictions.eq("staff_status", 1));
				List<StaffDAO> supposed_staff = staffcri.list();
				for (Iterator<StaffDAO> i = supposed_staff.iterator(); i.hasNext();){
					StaffDAO tempstaff = i.next();
					StaffOrderRelDAO sor = new StaffOrderRelDAO();
					sor.setOrder(dborder);
					sor.setStaff(tempstaff);
					session.save(sor);
				}
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

}
