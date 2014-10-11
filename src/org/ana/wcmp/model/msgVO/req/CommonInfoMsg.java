package org.ana.wcmp.model.msgVO.req;

/**
 * ������Ϣ�й�����Ϣ�����ࣩ�ķ�װ��������Ϣ����
 * ������΢�źţ�ToUserName   ���ͷ��˺ţ�FromUserName	��Ϣ����ʱ�䣨���ͣ���CreateTime
 * ��Ϣ���ͣ�MsgType	��ϢID(64λ����)��MsgId
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class CommonInfoMsg {
	
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType;
	private long MsgId;
	
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
	
	public long getMsgId(){
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
	
	public void setMsgType(String newmsgtype){
		MsgType = newmsgtype;
	}
	
	public void setMsgId(long newmsgid){
		MsgId = newmsgid;
	}
}
