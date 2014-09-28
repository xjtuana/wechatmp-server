package org.ana.wcmp.database.dao;

public class BasicUserDAO {

	private long pk_basic_user;
	private String basic_user_netid;
	private String basic_user_stuid;
	private String basic_user_ip;
	private String basic_user_building;
	private String basic_user_room;
	
	public long getPk_basic_user() {
		return pk_basic_user;
	}
	public void setPk_basic_user(long pk_basic_user) {
		this.pk_basic_user = pk_basic_user;
	}
	public String getBasic_user_netid() {
		return basic_user_netid;
	}
	public void setBasic_user_netid(String basic_user_netid) {
		this.basic_user_netid = basic_user_netid;
	}
	public String getBasic_user_stuid() {
		return basic_user_stuid;
	}
	public void setBasic_user_stuid(String basic_user_stuid) {
		this.basic_user_stuid = basic_user_stuid;
	}
	public String getBasic_user_ip() {
		return basic_user_ip;
	}
	public void setBasic_user_ip(String basic_user_ip) {
		this.basic_user_ip = basic_user_ip;
	}
	public String getBasic_user_building() {
		return basic_user_building;
	}
	public void setBasic_user_building(String basic_user_building) {
		this.basic_user_building = basic_user_building;
	}
	public String getBasic_user_room() {
		return basic_user_room;
	}
	public void setBasic_user_room(String basic_user_room) {
		this.basic_user_room = basic_user_room;
	}
	
}
