package org.ana.wcmp.database.dao;

/**
 * ¥���Լ��������ܵ�ӳ���
 * @author Godrick
 * @date 2014��9��28��
 */
public class StaffBuildingRelDAO {
	
	private long pk_staff_building;
	private StaffDAO staff; //ӳ��������Ϣ��ԭ����staff_id�ֶΣ����һ���
	private DomainBuildingDAO building; //ӳ��¥����Ϣ��ԭ����building_id�ֶΣ����һ���
	
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
