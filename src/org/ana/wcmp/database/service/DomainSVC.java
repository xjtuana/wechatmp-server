package org.ana.wcmp.database.service;

import java.util.List;

import org.ana.wcmp.database.dao.DomainBuildingDAO;
import org.ana.wcmp.database.dao.StaffBuildingRelDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.ana.wcmp.database.util.BlobProcessor;
import org.ana.wcmp.db2modelVO.domain.IO_BuildingStaffRelVO;
import org.ana.wcmp.db2modelVO.domain.IO_BuildingVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public class DomainSVC {
	
	public IO_BuildingVO[] getAllBuildings() 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Criteria buildingcri = session.createCriteria(DomainBuildingDAO.class);
			List<DomainBuildingDAO> gettedbuildings = buildingcri.list();
			IO_BuildingVO[] buildings = new IO_BuildingVO[gettedbuildings.size()];
			BlobProcessor bp = new BlobProcessor();
			for (int i = 0; i < buildings.length; i++){
				DomainBuildingDAO tempbuilding = gettedbuildings.get(i);
				IO_BuildingVO thisbuilding = new IO_BuildingVO();
				thisbuilding.setBuilding_id(tempbuilding.getPk_domain_building());
				thisbuilding.setBuilding_name(tempbuilding.getDomain_building_name());
				thisbuilding.setBuilding_area_id(tempbuilding.getDomain_building_area().getPk_domain_area());
				Long groupid = tempbuilding.getDomain_building_group() == null? null : tempbuilding.getDomain_building_group().getPk_group();
				thisbuilding.setBuilding_group_id(groupid);
				if (tempbuilding.getDomain_building_desc() != null){
					bp.setUnhandled_blob(tempbuilding.getDomain_building_desc());
					thisbuilding.setBuilding_desc(bp.blobToStr());
				}
				buildings[i] = thisbuilding;
			}
			tx.commit();
			
			return buildings;
		} catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			
			throw new DBServiceException();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public IO_BuildingStaffRelVO getBuildingStaff(IO_BuildingStaffRelVO input) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Criteria bsrelcri = session.createCriteria(StaffBuildingRelDAO.class);
			DomainBuildingDAO building = (DomainBuildingDAO) session.get(DomainBuildingDAO.class, input.getBuilding_id());
			bsrelcri.add(Restrictions.eq("building", building));
			List<StaffBuildingRelDAO> stafflist = bsrelcri.list();
			Long[] staffids = new Long[stafflist.size()];
			for (int i = 0; i < staffids.length; i++){
				long staffid = stafflist.get(i).getStaff().getPk_staff();
				staffids[i] = staffid;
			}
			input.setStaff_ids(staffids);
			tx.commit();
			
			return input;
		} catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			
			throw new DBServiceException();
		} finally {
			HibernateUtil.closeSession();
		}
		
	}
}
