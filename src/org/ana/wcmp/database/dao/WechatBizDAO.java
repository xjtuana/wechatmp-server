package org.ana.wcmp.database.dao;

import java.sql.Blob;

public class WechatBizDAO {
	
	private long pk_wechat_biz;
	private String wechat_biz_name;
	private String wechat_biz_label;
	private String wechat_biz_class;
	private String wechat_biz_method;
	private String wechat_biz_code;
	private boolean wechat_biz_isadmin;
	private Blob wechat_biz_rtn_param_ph;
	
	public long getPk_wechat_biz() {
		return pk_wechat_biz;
	}
	public void setPk_wechat_biz(long pk_wechat_biz) {
		this.pk_wechat_biz = pk_wechat_biz;
	}
	public String getWechat_biz_name() {
		return wechat_biz_name;
	}
	public void setWechat_biz_name(String wechat_biz_name) {
		this.wechat_biz_name = wechat_biz_name;
	}
	public String getWechat_biz_label() {
		return wechat_biz_label;
	}
	public void setWechat_biz_label(String wechat_biz_label) {
		this.wechat_biz_label = wechat_biz_label;
	}
	public String getWechat_biz_class() {
		return wechat_biz_class;
	}
	public void setWechat_biz_class(String wechat_biz_class) {
		this.wechat_biz_class = wechat_biz_class;
	}
	public String getWechat_biz_method() {
		return wechat_biz_method;
	}
	public void setWechat_biz_method(String wechat_biz_method) {
		this.wechat_biz_method = wechat_biz_method;
	}
	public String getWechat_biz_code() {
		return wechat_biz_code;
	}
	public void setWechat_biz_code(String wechat_biz_code) {
		this.wechat_biz_code = wechat_biz_code;
	}
	public boolean isWechat_biz_isadmin() {
		return wechat_biz_isadmin;
	}
	public void setWechat_biz_isadmin(boolean wechat_biz_isadmin) {
		this.wechat_biz_isadmin = wechat_biz_isadmin;
	}
	public Blob getWechat_biz_rtn_param_ph() {
		return wechat_biz_rtn_param_ph;
	}
	public void setWechat_biz_rtn_param_ph(Blob wechat_biz_rtn_param_ph) {
		this.wechat_biz_rtn_param_ph = wechat_biz_rtn_param_ph;
	}

}
