package org.ana.wcmp.db2modelVO.order;

import java.util.Calendar;

public class IN_NewOrderVO {
	
	private long order_add_time;
	private String order_client_name;
	private String order_client_phone;
	private String order_client_ip;
	private String order_client_building;
	private String order_client_netid;
	private String order_client_room;
	private String order_client_wechat_user_openid;
	private String order_fault_desc;
	private Calendar order_resv_time;
	private int order_status;
	private String order_certification_code;
	private Long[] order_supposed_staff;
	
	public String getOrder_client_name() {
		return order_client_name;
	}
	public void setOrder_client_name(String order_client_name) {
		this.order_client_name = order_client_name;
	}
	public String getOrder_client_phone() {
		return order_client_phone;
	}
	public void setOrder_client_phone(String order_client_phone) {
		this.order_client_phone = order_client_phone;
	}
	public String getOrder_client_ip() {
		return order_client_ip;
	}
	public void setOrder_client_ip(String order_client_ip) {
		this.order_client_ip = order_client_ip;
	}
	public String getOrder_client_building() {
		return order_client_building;
	}
	public void setOrder_client_building(String order_client_building) {
		this.order_client_building = order_client_building;
	}
	public String getOrder_client_netid() {
		return order_client_netid;
	}
	public void setOrder_client_netid(String order_client_netid) {
		this.order_client_netid = order_client_netid;
	}
	public String getOrder_client_room() {
		return order_client_room;
	}
	public void setOrder_client_room(String order_client_room) {
		this.order_client_room = order_client_room;
	}
	public String getOrder_client_wechat_user_openid() {
		return order_client_wechat_user_openid;
	}
	public void setOrder_client_wechat_user_openid(String order_client_wechat_user_id) {
		this.order_client_wechat_user_openid = order_client_wechat_user_id;
	}
	public String getOrder_fault_desc() {
		return order_fault_desc;
	}
	public void setOrder_fault_desc(String order_fault_desc) {
		this.order_fault_desc = order_fault_desc;
	}
	public Calendar getOrder_resv_time() {
		return order_resv_time;
	}
	public void setOrder_resv_time(Calendar order_resv_time) {
		this.order_resv_time = order_resv_time;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public String getOrder_certification_code() {
		return order_certification_code;
	}
	public void setOrder_certification_code(String order_certification_code) {
		this.order_certification_code = order_certification_code;
	}
	public Long[] getOrder_supposed_staff() {
		return order_supposed_staff;
	}
	public void setOrder_supposed_staff(Long[] order_supposed_staff) {
		this.order_supposed_staff = order_supposed_staff;
	}
	public long getOrder_add_time() {
		return order_add_time;
	}
	public void setOrder_add_time(long order_add_time) {
		this.order_add_time = order_add_time;
	}

}
