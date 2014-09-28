package org.ana.wcmp.database.dao;

import java.util.Calendar;

/**
 * 微信用户表DAO类
 * @author Godrick
 * @date 2014年9月28日
 */
public class WechatUserDAO {
	
	private long pk_wechat_user;
	private String wechat_user_acc;
	private String wechat_user_openid;
	private Calendar wechat_user_sub_time;
	private Calendar wechat_user_unsub_time;
	private Integer wechat_user_status;
	private BasicUserDAO wechat_user_basic; //微信用户的基本信息，原wechat_user_basic_id字段，多对一外键
	private StaffDAO wechat_user_staff; //微信用户（若属于网管）的网管人员信息，原wechat_user_staff_id字段，多对一外键
	private Integer wechat_user_group_id;
	
	public long getPk_wechat_user() {
		return pk_wechat_user;
	}
	public void setPk_wechat_user(long pk_wechat_user) {
		this.pk_wechat_user = pk_wechat_user;
	}
	public String getWechat_user_acc() {
		return wechat_user_acc;
	}
	public void setWechat_user_acc(String wechat_user_acc) {
		this.wechat_user_acc = wechat_user_acc;
	}
	public String getWechat_user_openid() {
		return wechat_user_openid;
	}
	public void setWechat_user_openid(String wechat_user_openid) {
		this.wechat_user_openid = wechat_user_openid;
	}
	public Calendar getWechat_user_sub_time() {
		return wechat_user_sub_time;
	}
	public void setWechat_user_sub_time(Calendar wechat_user_sub_time) {
		this.wechat_user_sub_time = wechat_user_sub_time;
	}
	public Calendar getWechat_user_unsub_time() {
		return wechat_user_unsub_time;
	}
	public void setWechat_user_unsub_time(Calendar wechat_user_unsub_time) {
		this.wechat_user_unsub_time = wechat_user_unsub_time;
	}
	public Integer getWechat_user_status() {
		return wechat_user_status;
	}
	public void setWechat_user_status(Integer wechat_user_status) {
		this.wechat_user_status = wechat_user_status;
	}
	public BasicUserDAO getWechat_user_basic() {
		return wechat_user_basic;
	}
	public void setWechat_user_basic(BasicUserDAO wechat_user_basic) {
		this.wechat_user_basic = wechat_user_basic;
	}
	public StaffDAO getWechat_user_staff() {
		return wechat_user_staff;
	}
	public void setWechat_user_staff(StaffDAO wechat_user_staff) {
		this.wechat_user_staff = wechat_user_staff;
	}
	public Integer getWechat_user_group_id() {
		return wechat_user_group_id;
	}
	public void setWechat_user_group_id(Integer wechat_user_group_id) {
		this.wechat_user_group_id = wechat_user_group_id;
	}

}
