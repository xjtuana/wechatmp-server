package org.ana.wcmp.database.dao;

public class WechatUserRoleRelDAO {
	
	private long pk_wcuser_role_rel;
	private WechatUserDAO wcuser_role_rel_user;
	private UserRoleDAO wcuser_role_rel_role;
	
	public long getPk_wcuser_role_rel() {
		return pk_wcuser_role_rel;
	}
	public void setPk_wcuser_role_rel(long pk_wcuser_role_rel) {
		this.pk_wcuser_role_rel = pk_wcuser_role_rel;
	}
	public WechatUserDAO getWcuser_role_rel_user() {
		return wcuser_role_rel_user;
	}
	public void setWcuser_role_rel_user(WechatUserDAO wcuser_role_rel_user) {
		this.wcuser_role_rel_user = wcuser_role_rel_user;
	}
	public UserRoleDAO getWcuser_role_rel_role() {
		return wcuser_role_rel_role;
	}
	public void setWcuser_role_rel_role(UserRoleDAO wcuser_role_rel_role) {
		this.wcuser_role_rel_role = wcuser_role_rel_role;
	}

}
