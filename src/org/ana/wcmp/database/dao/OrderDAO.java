package org.ana.wcmp.database.dao;

import java.sql.Blob;
import java.util.Calendar;

/**
 * 派工单表的DAO类
 * @author Godrick
 * @date 2014年9月28日
 */
public class OrderDAO {
	
	private long pk_order;
	private String order_client_name;
	private String order_client_phone;
	private String order_client_ip;
	private String order_client_netid;
	private String order_client_building;
	private String order_client_room;
	private WechatUserDAO order_client_wechat_user; //报修人微信号，对应原表中order_client_wechat_user_id字段，多对一外键
	private Blob order_fault_desc;
	private Calendar order_add_time;
	private Calendar order_resv_time;
	private Integer order_status;
	private String order_certification_code;
	private StaffDAO order_resp_staff; //接单网管信息，对应原表中order_resp_staff_id字段，多对一外键
	private WechatUserDAO order_resp_staff_wechat_user;  //接单网管信息，对应原表中order_resp_staff_wechat_user_id字段，多对一外键
	private Blob order_fix_result;
	private Calendar order_fix_time;
	private Integer order_client_rate_score;
	private Blob order_client_rate_desc;
	
	public long getPk_order() {
		return pk_order;
	}
	public void setPk_order(long pk_order) {
		this.pk_order = pk_order;
	}
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
	public String getOrder_client_netid() {
		return order_client_netid;
	}
	public void setOrder_client_netid(String order_client_netid) {
		this.order_client_netid = order_client_netid;
	}
	public String getOrder_client_building() {
		return order_client_building;
	}
	public void setOrder_client_building(String order_client_building) {
		this.order_client_building = order_client_building;
	}
	public String getOrder_client_room() {
		return order_client_room;
	}
	public void setOrder_client_room(String order_client_room) {
		this.order_client_room = order_client_room;
	}
	public WechatUserDAO getOrder_client_wechat_user() {
		return order_client_wechat_user;
	}
	public void setOrder_client_wechat_user(WechatUserDAO order_client_wechat_user) {
		this.order_client_wechat_user = order_client_wechat_user;
	}
	public Blob getOrder_fault_desc() {
		return order_fault_desc;
	}
	public void setOrder_fault_desc(Blob order_fault_desc) {
		this.order_fault_desc = order_fault_desc;
	}
	public Calendar getOrder_add_time() {
		return order_add_time;
	}
	public void setOrder_add_time(Calendar order_add_time) {
		this.order_add_time = order_add_time;
	}
	public Calendar getOrder_resv_time() {
		return order_resv_time;
	}
	public void setOrder_resv_time(Calendar order_resv_time) {
		this.order_resv_time = order_resv_time;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public String getOrder_certification_code() {
		return order_certification_code;
	}
	public void setOrder_certification_code(String order_certification_code) {
		this.order_certification_code = order_certification_code;
	}
	public StaffDAO getOrder_resp_staff() {
		return order_resp_staff;
	}
	public void setOrder_resp_staff(StaffDAO order_resp_staff) {
		this.order_resp_staff = order_resp_staff;
	}
	public WechatUserDAO getOrder_resp_staff_wechat_user() {
		return order_resp_staff_wechat_user;
	}
	public void setOrder_resp_staff_wechat_user(
			WechatUserDAO order_resp_staff_wechat_user) {
		this.order_resp_staff_wechat_user = order_resp_staff_wechat_user;
	}
	public Blob getOrder_fix_result() {
		return order_fix_result;
	}
	public void setOrder_fix_result(Blob order_fix_result) {
		this.order_fix_result = order_fix_result;
	}
	public Calendar getOrder_fix_time() {
		return order_fix_time;
	}
	public void setOrder_fix_time(Calendar order_fix_time) {
		this.order_fix_time = order_fix_time;
	}
	public Integer getOrder_client_rate_score() {
		return order_client_rate_score;
	}
	public void setOrder_client_rate_score(Integer order_client_rate_score) {
		this.order_client_rate_score = order_client_rate_score;
	}
	public Blob getOrder_client_rate_desc() {
		return order_client_rate_desc;
	}
	public void setOrder_client_rate_desc(Blob order_client_rate_desc) {
		this.order_client_rate_desc = order_client_rate_desc;
	}
	
}
