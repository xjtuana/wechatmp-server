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
import org.ana.wcmp.db2modelVO.order.IN_NewOrderVO;
import org.ana.wcmp.db2modelVO.order.OUT_NewOrderReturnVO;
import org.ana.wcmp.db2modelVO.staff.OUT_StaffContactInfoVO;
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
				Long[] staff_ids = neworder.getOrder_supposed_staff();
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

	public OUT_NewOrderReturnVO addNewOrderWithWechatReturn(IN_NewOrderVO neworderraw) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
	    Transaction tx = session.beginTransaction();

		try {
			OUT_NewOrderReturnVO wechatret = new OUT_NewOrderReturnVO();
			OrderDAO neworder = new OrderDAO();
			Calendar order_add_time = Calendar.getInstance();
			order_add_time.setTimeInMillis(neworderraw.getOrder_add_time());
			neworder.setOrder_add_time(order_add_time);
			neworder.setOrder_certification_code(neworderraw.getOrder_certification_code());
			neworder.setOrder_client_phone(neworderraw.getOrder_client_phone());
			neworder.setOrder_status(neworderraw.getOrder_status());
			neworder.setOrder_client_name(neworderraw.getOrder_client_name());
			neworder.setOrder_client_building(neworderraw.getOrder_client_building());
			neworder.setOrder_client_ip(neworderraw.getOrder_client_ip());
			neworder.setOrder_client_netid(neworderraw.getOrder_client_netid());
			neworder.setOrder_client_room(neworderraw.getOrder_client_room());
			Criteria wcusercri = session.createCriteria(WechatUserDAO.class);
			wcusercri.add(Restrictions.eq("wechat_user_openid", neworderraw.getOrder_client_wechat_user_openid()));
			wcusercri.add(Restrictions.eq("wechat_user_status", 1));
			List<WechatUserDAO> wcuser = wcusercri.list();
			if (wcuser != null && wcuser.size() > 0){
				neworder.setOrder_client_wechat_user(wcuser.get(0));
			}
			session.save(neworder);
			
			if (neworderraw.getOrder_supposed_staff() != null && neworderraw.getOrder_supposed_staff().length > 0){
				Long[] staff_ids = neworderraw.getOrder_supposed_staff();
				Criteria staffcri = session.createCriteria(StaffDAO.class);
				List<Criterion> staffidcri = new ArrayList<Criterion>();
				for (int i = 0; i < staff_ids.length; i++){
					staffidcri.add(Restrictions.eq("pk_staff", staff_ids[i]));
				}
				staffcri.add(Restrictions.or(staffidcri.toArray(new Criterion[0])));
				staffcri.add(Restrictions.eq("staff_status", 1));
				List<StaffDAO> supposed_staff = staffcri.list();
				OUT_StaffContactInfoVO[] staffs = new OUT_StaffContactInfoVO[supposed_staff.size()];
				for (int i = 0; i < staffs.length; i++){
					StaffDAO tempstaff = supposed_staff.get(i);
					OUT_StaffContactInfoVO thisadmin = new OUT_StaffContactInfoVO();
					thisadmin.setStaff_id(tempstaff.getPk_staff());
					thisadmin.setStaff_stuid(tempstaff.getStaff_stuid());
					thisadmin.setStaff_name(tempstaff.getStaff_name());
					thisadmin.setStaff_gender(tempstaff.getStaff_gender());
					thisadmin.setStaff_phone(tempstaff.getStaff_phone());
					thisadmin.setStaff_qq(tempstaff.getStaff_qq());
					thisadmin.setStaff_wechat_acc(tempstaff.getStaff_wechat_acc());
					thisadmin.setStaff_campus(tempstaff.getStaff_campus());
					thisadmin.setStaff_addrbuilding(tempstaff.getStaff_addrbuilding());
					thisadmin.setStaff_addrroom(tempstaff.getStaff_addrroom());
					staffs[i] = thisadmin;
					StaffOrderRelDAO sor = new StaffOrderRelDAO();
					sor.setOrder(neworder);
					sor.setStaff(tempstaff);
					session.save(sor);
				}
				wechatret.setSupadmins(staffs);
			}
			
			wechatret.setOrderid(neworder.getPk_order());
			wechatret.setAddtime(neworder.getOrder_add_time().getTimeInMillis());
			wechatret.setBuilding(neworder.getOrder_client_building());
			wechatret.setName(neworder.getOrder_client_name());
			wechatret.setNetid(neworder.getOrder_client_netid());
			wechatret.setPhone(neworder.getOrder_client_phone());
			wechatret.setRoom(neworder.getOrder_client_room());
			wechatret.setSucceeded(true);
			tx.commit();
			return wechatret;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			
			throw new DBServiceException();
		} finally {
		    HibernateUtil.closeSession();
		}
	}
	
}
