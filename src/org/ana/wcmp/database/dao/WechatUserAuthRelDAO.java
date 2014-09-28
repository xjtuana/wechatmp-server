package org.ana.wcmp.database.dao;

public class WechatUserAuthRelDAO {

	private long pk_wcauth_rel;
	private WechatBizDAO wechat_biz;
	private UserRoleDAO user_role;
	
	public long getPk_wcauth_rel() {
		return pk_wcauth_rel;
	}
	public void setPk_wcauth_rel(long pk_wcauth_rel) {
		this.pk_wcauth_rel = pk_wcauth_rel;
	}
	public WechatBizDAO getWechat_biz() {
		return wechat_biz;
	}
	public void setWechat_biz(WechatBizDAO wechat_biz) {
		this.wechat_biz = wechat_biz;
	}
	public UserRoleDAO getUser_role() {
		return user_role;
	}
	public void setUser_role(UserRoleDAO user_role) {
		this.user_role = user_role;
	}
	
}
