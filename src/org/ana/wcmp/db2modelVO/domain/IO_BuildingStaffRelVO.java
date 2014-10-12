package org.ana.wcmp.db2modelVO.domain;

public class IO_BuildingStaffRelVO {
	
	private Long building_id;
	private Long[] staff_ids;
	
	public Long getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(Long building_id) {
		this.building_id = building_id;
	}
	public Long[] getStaff_ids() {
		return staff_ids;
	}
	public void setStaff_ids(Long[] staff_ids) {
		this.staff_ids = staff_ids;
	}

}
