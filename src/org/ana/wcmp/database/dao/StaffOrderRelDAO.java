package org.ana.wcmp.database.dao;

/**
 * �ɹ�����Ӧ������ӳ���ϵ���DAO��
 * @author Godrick
 * @date 2014��9��29��
 */
public class StaffOrderRelDAO {
	
	private long pk_staff_order;
	private OrderDAO order; //������ԭorder_id�࣬���һ���
	private StaffDAO staff; //������ԭstaff_id�࣬���һ���
	
	public long getPk_staff_order() {
		return pk_staff_order;
	}
	public void setPk_staff_order(long pk_order_staff) {
		this.pk_staff_order = pk_order_staff;
	}
	public OrderDAO getOrder() {
		return order;
	}
	public void setOrder(OrderDAO order) {
		this.order = order;
	}
	public StaffDAO getStaff() {
		return staff;
	}
	public void setStaff(StaffDAO staff) {
		this.staff = staff;
	}

}
