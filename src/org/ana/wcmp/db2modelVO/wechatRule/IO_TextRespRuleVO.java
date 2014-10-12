package org.ana.wcmp.db2modelVO.wechatRule;

public class IO_TextRespRuleVO {
	
	private long RuleID;
	private String RuleName;
	private String RuleKeyword;
	private int RuleMode;
	private int RespType;
	private long RespMsgID;
	
	public long getRuleID() {
		return RuleID;
	}
	public void setRuleID(long ruleID) {
		RuleID = ruleID;
	}
	public String getRuleName() {
		return RuleName;
	}
	public void setRuleName(String ruleName) {
		RuleName = ruleName;
	}
	public String getRuleKeyword() {
		return RuleKeyword;
	}
	public void setRuleKeyword(String ruleKeyword) {
		RuleKeyword = ruleKeyword;
	}
	public int getRuleMode() {
		return RuleMode;
	}
	public void setRuleMode(int ruleMode) {
		RuleMode = ruleMode;
	}
	public int getRespType() {
		return RespType;
	}
	public void setRespType(int respType) {
		RespType = respType;
	}
	public long getRespMsgID() {
		return RespMsgID;
	}
	public void setRespMsgID(long respMsgID) {
		RespMsgID = respMsgID;
	}


}
