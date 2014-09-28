package org.ana.wcmp.database.dao;

import java.sql.Blob;

public class UserRoleDAO {

	private long pk_user_role;
	private String user_role_name;
	private Blob user_role_desc;
	
	public long getPk_user_role() {
		return pk_user_role;
	}
	public void setPk_user_role(long pk_user_role) {
		this.pk_user_role = pk_user_role;
	}
	public String getUser_role_name() {
		return user_role_name;
	}
	public void setUser_role_name(String user_role_name) {
		this.user_role_name = user_role_name;
	}
	public Blob getUser_role_desc() {
		return user_role_desc;
	}
	public void setUser_role_desc(Blob user_role_desc) {
		this.user_role_desc = user_role_desc;
	}
	
}
