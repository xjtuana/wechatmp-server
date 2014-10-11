package org.ana.wcmp.model.initializers;

import org.ana.wcmp.context.DataContext;
import org.ana.wcmp.context.vo.StaffContextInfoVO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.StaffSVC;
import org.ana.wcmp.db2modelVO.staff.OUT_StaffContactInfoVO;

public class DataContextInitialize {
	
	public void initStaffContext(){
		StaffSVC ssvc = new StaffSVC();
		try{
			OUT_StaffContactInfoVO[] staffcontact = ssvc.getAllActiveStaffContactInfo();
			StaffContextInfoVO[] staff = new StaffContextInfoVO[staffcontact.length];
			for (int i = 0; i<staff.length; i++ ){
				staff[i].setStaff_id(staffcontact[i].getStaff_id());
				staff[i].setStaff_name(staffcontact[i].getStaff_name());
				staff[i].setStaff_gender(staffcontact[i].getStaff_gender()?"ÄÐ":"Å®");
				staff[i].setStaff_stuid(staffcontact[i].getStaff_stuid());
				staff[i].setStaff_phone(staffcontact[i].getStaff_phone());
				staff[i].setStaff_qq(staffcontact[i].getStaff_qq());
				staff[i].setStaff_wechat_acc(staffcontact[i].getStaff_wechat_acc());
				staff[i].setStaff_selfdesc(staffcontact[i].getStaff_selfdesc());
				staff[i].setStaff_campus(staffcontact[i].getStaff_campus());
				staff[i].setStaff_addrbuilding(staffcontact[i].getStaff_addrbuilding());
				staff[i].setStaff_addrroom(staffcontact[i].getStaff_addrroom());
				staff[i].setDomain_building_ids(ssvc.getStaffRespBuilding(staffcontact[i].getStaff_id()));
			}
			DataContext.STAFF_CONTEXT = staff;
		} catch (DBServiceException dbe){
			dbe.printStackTrace();
		}
		
	}

}
