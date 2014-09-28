package org.ana.wcmp.database.dao;

import java.sql.Blob;

public class WechatTextPoolDAO {
	
	private long pk_text_msg;
	private String text_msg_name;
	private Blob text_msg_content;
	
	public long getPk_text_msg() {
		return pk_text_msg;
	}
	public void setPk_text_msg(long pk_text_msg) {
		this.pk_text_msg = pk_text_msg;
	}
	public String getText_msg_name() {
		return text_msg_name;
	}
	public void setText_msg_name(String text_msg_name) {
		this.text_msg_name = text_msg_name;
	}
	public Blob getText_msg_content() {
		return text_msg_content;
	}
	public void setText_msg_content(Blob text_msg_content) {
		this.text_msg_content = text_msg_content;
	}

}
