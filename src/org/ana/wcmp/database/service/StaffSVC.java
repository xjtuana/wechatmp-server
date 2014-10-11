package org.ana.wcmp.database.service;

import java.util.Iterator;
import java.util.List;

import org.ana.wcmp.database.dao.StaffBuildingRelDAO;
import org.ana.wcmp.database.dao.StaffDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.ana.wcmp.database.util.BlobProcessor;
import org.ana.wcmp.db2modelVO.staff.OUT_StaffContactInfoVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public class StaffSVC {
	
	public OUT_StaffContactInfoVO[] getAllActiveStaffContactInfo() 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
	    Transaction tx = session.beginTransaction();
	    
	    try{
	    	Criteria staffcri = session.createCriteria(StaffDAO.class);
	    	tx.commit();
	    	staffcri.add(Restrictions.eq("staff_status", 1));
	    	List<StaffDAO> staff_raw = staffcri.list();
	    	OUT_StaffContactInfoVO staff[] = new OUT_StaffContactInfoVO[staff_raw.size()];
	    	int staffcursor = 0;
	    	BlobProcessor bp = new BlobProcessor();
	    	for (Iterator<StaffDAO> i = staff_raw.iterator(); i.hasNext();){
	    		StaffDAO tempstaff = i.next();
	    		
	    		staff[staffcursor].setStaff_id(tempstaff.getPk_staff());
	    		staff[staffcursor].setStaff_gender(tempstaff.getStaff_gender());
	    		staff[staffcursor].setStaff_name(tempstaff.getStaff_name());
	    		staff[staffcursor].setStaff_phone(tempstaff.getStaff_phone());
	    		staff[staffcursor].setStaff_qq(tempstaff.getStaff_qq());
	    		staff[staffcursor].setStaff_stuid(tempstaff.getStaff_stuid());
	    		staff[staffcursor].setStaff_wechat_acc(tempstaff.getStaff_wechat_acc());
	    		staff[staffcursor].setStaff_campus(tempstaff.getStaff_campus());
	    		staff[staffcursor].setStaff_addrbuilding(tempstaff.getStaff_addrbuilding());
	    		staff[staffcursor].setStaff_addrroom(tempstaff.getStaff_addrroom());
	    		bp.setUnhandled_blob(tempstaff.getStaff_selfdesc());
	    		staff[staffcursor].setStaff_selfdesc(bp.blobToStr());
	    		
	    		staffcursor++;
	    	}
	    	
	    	return staff;
	    } catch (Exception e){
	    	e.printStackTrace();
	    	tx.rollback();
			
			throw new DBServiceException();
	    } finally{
	    	HibernateUtil.closeSession();
	    }
	}
	
	public long[] getStaffRespBuilding(long staff_id) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
	    Transaction tx = session.beginTransaction();
	    
	    try{
	    	Criteria staffbuildingcri = session.createCriteria(StaffBuildingRelDAO.class);
	    	staffbuildingcri.add(Restrictions.eq("staff", (StaffDAO)session.get(StaffDAO.class, staff_id)));
	    	staffbuildingcri.add(Restrictions.isNotNull("building"));
	    	staffbuildingcri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	    	List<StaffBuildingRelDAO> sbr = staffbuildingcri.list();
	    	long[] building_ids = new long[sbr.size()];
	    	int idcursor = 0;
	    	for (Iterator<StaffBuildingRelDAO> i = sbr.iterator(); i.hasNext();){
	    		StaffBuildingRelDAO tempsbr = i.next();
	    		building_ids[idcursor] = tempsbr.getBuilding().getPk_domain_building();
	    		idcursor++;
	    	}
	    	
	    	return building_ids;
	    } catch (Exception e){
	    	e.printStackTrace();
	    	tx.rollback();
			
			throw new DBServiceException();
	    } finally {
	    	HibernateUtil.closeSession();
	    }
	}

}
