package org.ana.wcmp.model.vo.msg.resp;

/**
 * ������Ϣ�࣬����һ�������زģ�ý��ID��ȡ�����������������ʵ������
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class VoiceMsg extends CommonInfoResp{
	
	private Voice Voice;
	
	public Voice getVoice(){
		return Voice;
	}
	
	public void setVoice(Voice newvoice){
		Voice = newvoice;
	}

}
