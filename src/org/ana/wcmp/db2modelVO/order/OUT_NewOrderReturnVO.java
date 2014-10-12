package org.ana.wcmp.db2modelVO.order;

import org.ana.wcmp.db2modelVO.staff.OUT_StaffContactInfoVO;

public class OUT_NewOrderReturnVO {

	private boolean succeeded;
	private long orderid;
	private String name;
	private String phone;
	private String netid;
	private String building;
	private String room;
	private long addtime;
	private OUT_StaffContactInfoVO[] supadmins;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public long getAddtime() {
		return addtime;
	}

	public void setAddtime(long addtime) {
		this.addtime = addtime;
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}

	public OUT_StaffContactInfoVO[] getSupadmins() {
		return supadmins;
	}

	public void setSupadmins(OUT_StaffContactInfoVO[] staffs) {
		this.supadmins = staffs;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
}
