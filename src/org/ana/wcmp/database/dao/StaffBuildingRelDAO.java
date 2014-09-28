package org.ana.wcmp.database.dao;

/**
 * 楼宇以及负责网管的映射表
 * @author Godrick
 * @date 2014年9月28日
 */
public class StaffBuildingRelDAO {
	
	private long pk_staff_building;
	private StaffDAO staff; //映射网管信息，原表中staff_id字段，多对一外键
	private DomainBuildingDAO building; //映射楼宇信息，原表中building_id字段，多对一外键
	
	public long getPk_staff_building() {
		return pk_staff_building;
	}
	public void setPk_staff_building(long pk_staff_building) {
		this.pk_staff_building = pk_staff_building;
	}
	public StaffDAO getStaff() {
		return staff;
	}
	public void setStaff(StaffDAO staff) {
		this.staff = staff;
	}
	public DomainBuildingDAO getBuilding() {
		return building;
	}
	public void setBuilding(DomainBuildingDAO building) {
		this.building = building;
	}

}
