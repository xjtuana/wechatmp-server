package org.ana.wcmp.context.vo;

public class StaffContextInfoVO {

	private long staff_id;
	private String staff_stuid;
	private String staff_name;
	private String staff_gender;
	private String staff_phone;
	private String staff_qq;
	private String staff_wechat_acc;
	private String staff_campus;
	private String staff_addrbuilding;
	private String staff_addrroom;
	private String staff_selfdesc;
	private long[] domain_building_pointers;

	public long getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(long staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_stuid() {
		return staff_stuid;
	}

	public void setStaff_stuid(String staff_stuid) {
		this.staff_stuid = staff_stuid;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_gender() {
		return staff_gender;
	}

	public void setStaff_gender(String staff_gender) {
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

	public String getStaff_selfdesc() {
		return staff_selfdesc;
	}

	public void setStaff_selfdesc(String staff_selfdesc) {
		this.staff_selfdesc = staff_selfdesc;
	}

	public long[] getDomain_building_pointers() {
		return domain_building_pointers;
	}

	public void setDomain_building_pointers(long[] domain_building_pointers) {
		this.domain_building_pointers = domain_building_pointers;
	}

}
