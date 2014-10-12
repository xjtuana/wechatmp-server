package org.ana.wcmp.model.vo.msg.req;

/**
 * 请求消息中共有信息（基类）的封装，共有信息含：
 * 开发者微信号：ToUserName   发送方账号：FromUserName	消息创建时间（整型）：CreateTime
 * 消息类型：MsgType	消息ID(64位整型)：MsgId
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class CommonInfoMsg {
	
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private int MsgType;
	private String MsgId;
	
	public String getFromUserName(){
		return FromUserName;
	}

	public String getToUserName(){
		return ToUserName;
	}
	
	public long getCreateTime(){
		return CreateTime;
	}
	
	public int getMsgType(){
		return MsgType;
	}
	
	public String getMsgId(){
		return MsgId;
	}
	
	public void setFromUserName(String newfromusername){
		FromUserName = newfromusername;
	}

	public void setToUserName(String newtousername){
		ToUserName = newtousername;
	}
	
	public void setCreateTime(long newcreatetime){
		CreateTime = newcreatetime;
	}
	
	public void setMsgType(int newmsgtype){
		MsgType = newmsgtype;
	}
	
	public void setMsgId(String newmsgid){
		MsgId = newmsgid;
	}
}
