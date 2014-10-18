package org.ana.wcmp.model.vo.msg.req;

/**
 * ������Ϣ��ȡ��������Ϣ��
 * ý��ID��MediaId	��ʽ��Format	����ʶ����(UTF8�ı����ݣ������ר�У���Recognition
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
