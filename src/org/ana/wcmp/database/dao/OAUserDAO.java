package org.ana.wcmp.database.dao;

/**
 * 社团OA用户表DAO类
 * @author Godrick
 * @date 2014年9月28日
 */
public class OAUserDAO {
	
	private long pk_oa_user;
	private String oa_user_name;
	private String oa_user_password;
	
	public long getPk_oa_user() {
		return pk_oa_user;
	}
	public void setPk_oa_user(long pk_oa_user) {
		this.pk_oa_user = pk_oa_user;
	}
	public String getOa_user_name() {
		return oa_user_name;
	}
	public void setOa_user_name(String oa_user_name) {
		this.oa_user_name = oa_user_name;
	}
	public String getOa_user_password() {
		return oa_user_password;
	}
	public void setOa_user_password(String oa_user_password) {
		this.oa_user_password = oa_user_password;
	}

}
