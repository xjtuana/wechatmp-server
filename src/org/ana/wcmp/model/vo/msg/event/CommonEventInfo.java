package org.ana.wcmp.model.vo.msg.event;

public class CommonEventInfo {
	
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private int MsgType;
	private int Event;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public int getMsgType() {
		return MsgType;
	}
	public void setMsgType(int msgType) {
		MsgType = msgType;
	}
	public int getEvent() {
		return Event;
	}
	public void setEvent(int event) {
		Event = event;
	}
}
