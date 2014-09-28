package org.ana.wcmp.database.dao;

import java.sql.Blob;
import java.util.Calendar;

/**
 * 网管人员信息表DAO类
 * @author Godrick
 * @date 2014年9月28日
 */
public class StaffDAO {
	
	private long pk_staff;
	private String staff_stuid;
	private String staff_netid;
	private String staff_name;
	private Boolean staff_gender;
	private String staff_phone;
	private String staff_qq;
	private String staff_wechat_acc;
	private Integer staff_grade;
	private String staff_campus;
	private String staff_addrbuilding;
	private String staff_addrroom;
	private Blob staff_selfdesc;
	private WechatUserDAO staff_wechat_user; //网管微信账号，原表中staff_wechat_user_id字段，多对一外键
	private OAUserDAO staff_oa_user; //网管OA账号，原表中staff_oa_user_id字段，多对一外键
	private GroupDAO staff_group; //网管所属小组，原表中staff_group_id字段，多对一外键
	private DepartmentDAO staff_department; //网管所属部门，原表中staff_department_id字段，多对一外键
	private Boolean staff_sms_service;
	private Calendar staff_reg_in_time;
	private Calendar staff_reg_out_time;
	private Integer staff_status;
	
	public long getPk_staff() {
		return pk_staff;
	}
	public void setPk_staff(long pk_staff) {
		this.pk_staff = pk_staff;
	}
	public String getStaff_netid() {
		return staff_netid;
	}
	public void setStaff_netid(String staff_netid) {
		this.staff_netid = staff_netid;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public Boolean getStaff_gender() {
		return staff_gender;
	}
	public void setStaff_gender(Boolean staff_gender) {
		this.staff_gender = staff_gender;
	}
	public String getStaff_phone() {
		return staff_phone;
	}
	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}
	public String getStaff_qq() {
		return staff_qq;
	}
	public void setStaff_qq(String staff_qq) {
		this.staff_qq = staff_qq;
	}
	public String getStaff_wechat_acc() {
		return staff_wechat_acc;
	}
	public void setStaff_wechat_acc(String staff_wechat_acc) {
		this.staff_wechat_acc = staff_wechat_acc;
	}
	public Integer getStaff_grade() {
		return staff_grade;
	}
	public void setStaff_grade(Integer staff_grade) {
		this.staff_grade = staff_grade;
	}
	public String getStaff_campus() {
		return staff_campus;
	}
	public void setStaff_campus(String staff_campus) {
		this.staff_campus = staff_campus;
	}
	public String getStaff_addrbuilding() {
		return staff_addrbuilding;
	}
	public void setStaff_addrbuilding(String staff_addrbuilding) {
		this.staff_addrbuilding = staff_addrbuilding;
	}
	public String getStaff_addrroom() {
		return staff_addrroom;
	}
	public void setStaff_addrroom(String staff_addrroom) {
		this.staff_addrroom = staff_addrroom;
	}
	public Blob getStaff_selfdesc() {
		return staff_selfdesc;
	}
	public void setStaff_selfdesc(Blob staff_selfdesc) {
		this.staff_selfdesc = staff_selfdesc;
	}
	public WechatUserDAO getStaff_wechat_user() {
		return staff_wechat_user;
	}
	public void setStaff_wechat_user(WechatUserDAO staff_wechat_user) {
		this.staff_wechat_user = staff_wechat_user;
	}
	public OAUserDAO getStaff_oa_user() {
		return staff_oa_user;
	}
	public void setStaff_oa_user(OAUserDAO staff_oa_user) {
		this.staff_oa_user = staff_oa_user;
	}
	public GroupDAO getStaff_group() {
		return staff_group;
	}
	public void setStaff_group(GroupDAO staff_group) {
		this.staff_group = staff_group;
	}
	public DepartmentDAO getStaff_department() {
		return staff_department;
	}
	public void setStaff_department(DepartmentDAO staff_department) {
		this.staff_department = staff_department;
	}
	public Boolean getStaff_sms_service() {
		return staff_sms_service;
	}
	public void setStaff_sms_service(Boolean staff_sms_service) {
		this.staff_sms_service = staff_sms_service;
	}
	public Calendar getStaff_reg_in_time() {
		return staff_reg_in_time;
	}
	public void setStaff_reg_in_time(Calendar staff_reg_in_time) {
		this.staff_reg_in_time = staff_reg_in_time;
	}
	public Calendar getStaff_reg_out_time() {
		return staff_reg_out_time;
	}
	public void setStaff_reg_out_time(Calendar staff_reg_out_time) {
		this.staff_reg_out_time = staff_reg_out_time;
	}
	public Integer getStaff_status() {
		return staff_status;
	}
	public void setStaff_status(Integer staff_status) {
		this.staff_status = staff_status;
	}
	public String getStaff_stuid() {
		return staff_stuid;
	}
	public void setStaff_stuid(String staff_stuid) {
		this.staff_stuid = staff_stuid;
	}
	
}
