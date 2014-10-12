package org.ana.wcmp.model.vo.msg.req;

/**
 * 语音消息提取，包含信息：
 * 媒体ID：MediaId	格式：Format	语音识别结果(UTF8文本内容，服务号专有）：Recognition
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class VoiceMsg extends CommonInfoMsg{
	
	private String MediaId;
	private String Format;
	private String Recognition;

	public String getMediaId(){
		return MediaId;
	}

	public String getFormat(){
		return Format;
	}
	
	public String getRecognition(){
		return Recognition;
	}
	
	public void setMediaId(String newmediaid){
		MediaId = newmediaid;
	}

	public void setFormat(String newformat){
		Format = newformat;
	}
	
	public void setRecognition(String newrecognition){
		Recognition = newrecognition;
	}
}
