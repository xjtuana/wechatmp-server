package org.ana.wcmp.db2modelVO.wechatUser;

public class IO_SubWechatUserVO {
	
	private String openid;
	private long subtime;
	private long unsubtime;
	private int status;
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public long getSubtime() {
		return subtime;
	}
	public void setSubtime(long subtime) {
		this.subtime = subtime;
	}
	public long getUnsubtime() {
		return unsubtime;
	}
	public void setUnsubtime(long unsubtime) {
		this.unsubtime = unsubtime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	} 
	
}
