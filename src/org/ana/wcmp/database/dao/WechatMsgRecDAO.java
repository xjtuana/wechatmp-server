package org.ana.wcmp.database.dao;

import java.sql.Blob;
import java.util.Calendar;

/**
 * 微信消息记录表DAO类
 * @author Godrick
 * @date 2014年9月28日
 */
public class WechatMsgRecDAO {
	
	private long pk_msg_rec;
	private String msg_id;
	private Calendar msg_rcv_time;
	private String msg_from_user;
	private String msg_to_user;
	private Integer msg_type;
	private Blob msg_content;
	private String msg_picurl;
	private String msg_mediaid;
	private String msg_format;
	private Blob msg_recognition;
	private String msg_thumb_mediaid;
	private String msg_location_x;
	private String msg_location_y;
	private String msg_scale;
	private String msg_label;
	private String msg_url_title;
	private Blob msg_url_desc;
	private String msg_url;
	
	public long getPk_msg_rec() {
		return pk_msg_rec;
	}
	public void setPk_msg_rec(long pk_msg_rec) {
		this.pk_msg_rec = pk_msg_rec;
	}
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public Calendar getMsg_rcv_time() {
		return msg_rcv_time;
	}
	public void setMsg_rcv_time(Calendar msg_rcv_time) {
		this.msg_rcv_time = msg_rcv_time;
	}
	public String getMsg_from_user() {
		return msg_from_user;
	}
	public void setMsg_from_user(String msg_from_user) {
		this.msg_from_user = msg_from_user;
	}
	public String getMsg_to_user() {
		return msg_to_user;
	}
	public void setMsg_to_user(String msg_to_user) {
		this.msg_to_user = msg_to_user;
	}
	public Integer getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(Integer msg_type) {
		this.msg_type = msg_type;
	}
	public Blob getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(Blob msg_content) {
		this.msg_content = msg_content;
	}
	public String getMsg_picurl() {
		return msg_picurl;
	}
	public void setMsg_picurl(String msg_picurl) {
		this.msg_picurl = msg_picurl;
	}
	public String getMsg_mediaid() {
		return msg_mediaid;
	}
	public void setMsg_mediaid(String msg_mediaid) {
		this.msg_mediaid = msg_mediaid;
	}
	public String getMsg_format() {
		return msg_format;
	}
	public void setMsg_format(String msg_format) {
		this.msg_format = msg_format;
	}
	public Blob getMsg_recognition() {
		return msg_recognition;
	}
	public void setMsg_recognition(Blob msg_recognition) {
		this.msg_recognition = msg_recognition;
	}
	public String getMsg_thumb_mediaid() {
		return msg_thumb_mediaid;
	}
	public void setMsg_thumb_mediaid(String msg_thumb_mediaid) {
		this.msg_thumb_mediaid = msg_thumb_mediaid;
	}
	public String getMsg_location_x() {
		return msg_location_x;
	}
	public void setMsg_location_x(String msg_location_x) {
		this.msg_location_x = msg_location_x;
	}
	public String getMsg_location_y() {
		return msg_location_y;
	}
	public void setMsg_location_y(String msg_location_y) {
		this.msg_location_y = msg_location_y;
	}
	public String getMsg_scale() {
		return msg_scale;
	}
	public void setMsg_scale(String msg_scale) {
		this.msg_scale = msg_scale;
	}
	public String getMsg_label() {
		return msg_label;
	}
	public void setMsg_label(String msg_label) {
		this.msg_label = msg_label;
	}
	public String getMsg_url_title() {
		return msg_url_title;
	}
	public void setMsg_url_title(String msg_url_title) {
		this.msg_url_title = msg_url_title;
	}
	public Blob getMsg_url_desc() {
		return msg_url_desc;
	}
	public void setMsg_url_desc(Blob msg_url_desc) {
		this.msg_url_desc = msg_url_desc;
	}
	public String getMsg_url() {
		return msg_url;
	}
	public void setMsg_url(String msg_url) {
		this.msg_url = msg_url;
	}

}
