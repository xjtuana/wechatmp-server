package org.ana.wcmp.model.vo.msg.resp;

/**
 * 响应消息中共有信息（基类）的封装，共有信息含：
 * 开发者微信号：FromUserName   发送方账号：ToUserName	消息创建时间（整型）：CreateTime	消息类型：MsgType	
 * 此时收发方与请求消息相反
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class CommonInfoResp {

	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType;
	
	public String getFromUserName(){
		return FromUserName;
	}

	public String getToUserName(){
		return ToUserName;
	}
	
	public long getCreateTime(){
		return CreateTime;
	}
	
	public String getMsgType(){
		return MsgType;
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
	
	public void setMsgType(String newmsgtype){
		MsgType = newmsgtype;
	}
	
}
