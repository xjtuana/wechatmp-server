package org.ana.wcmp.model.vo.msg.resp;

/**
 * ��Ӧ��Ϣ�й�����Ϣ�����ࣩ�ķ�װ��������Ϣ����
 * ������΢�źţ�FromUserName   ���ͷ��˺ţ�ToUserName	��Ϣ����ʱ�䣨���ͣ���CreateTime	��Ϣ���ͣ�MsgType	
 * ��ʱ�շ�����������Ϣ�෴
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
