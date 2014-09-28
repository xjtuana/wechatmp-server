package org.ana.wcmp.database.dao;

/**
 * 派工单与应接网管映射关系表的DAO类
 * @author Godrick
 * @date 2014年9月29日
 */
public class StaffOrderRelDAO {
	
	private long pk_staff_order;
	private OrderDAO order; //工单，原order_id类，多对一外键
	private StaffDAO staff; //工单，原staff_id类，多对一外键
	
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
