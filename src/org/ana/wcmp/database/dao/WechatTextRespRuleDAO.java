package org.ana.wcmp.database.dao;

public class WechatTextRespRuleDAO {
	
	private long pk_text_rule;
	private String text_rule_name;
	private Integer text_rule_mode;
	private String text_rule_keyword;
	private Integer text_rule_resp_msg_type;
	private Integer text_rule_resp_msg_id;
	
	public long getPk_text_rule() {
		return pk_text_rule;
	}
	public void setPk_text_rule(long pk_text_rule) {
		this.pk_text_rule = pk_text_rule;
	}
	public String getText_rule_name() {
		return text_rule_name;
	}
	public void setText_rule_name(String text_rule_name) {
		this.text_rule_name = text_rule_name;
	}
	public Integer getText_rule_mode() {
		return text_rule_mode;
	}
	public void setText_rule_mode(Integer text_rule_mode) {
		this.text_rule_mode = text_rule_mode;
	}
	public String getText_rule_keyword() {
		return text_rule_keyword;
	}
	public void setText_rule_keyword(String text_rule_keyword) {
		this.text_rule_keyword = text_rule_keyword;
	}
	public Integer getText_rule_resp_msg_type() {
		return text_rule_resp_msg_type;
	}
	public void setText_rule_resp_msg_type(Integer text_rule_resp_msg_type) {
		this.text_rule_resp_msg_type = text_rule_resp_msg_type;
	}
	public Integer getText_rule_resp_msg_id() {
		return text_rule_resp_msg_id;
	}
	public void setText_rule_resp_msg_id(Integer text_rule_resp_msg_id) {
		this.text_rule_resp_msg_id = text_rule_resp_msg_id;
	}

}
