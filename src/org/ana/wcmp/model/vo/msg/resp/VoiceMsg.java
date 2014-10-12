package org.ana.wcmp.model.vo.msg.resp;

/**
 * 语音消息类，含有一个语音素材（媒体ID拉取）（对语音类进行了实例化）
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
