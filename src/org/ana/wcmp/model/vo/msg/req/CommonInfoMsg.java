package org.ana.wcmp.model.vo.msg.req;

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
