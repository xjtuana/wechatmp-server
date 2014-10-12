package org.ana.wcmp.db2modelVO.staff;

public class OUT_StaffRespBuildingVO {
	
	private long staff_id;
	private long[] building_id;
	
	public long getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(long staff_id) {
		this.staff_id = staff_id;
	}
	public long[] getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(long[] building_id) {
		this.building_id = building_id;
	}

}
