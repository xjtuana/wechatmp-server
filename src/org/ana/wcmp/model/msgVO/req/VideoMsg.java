package org.ana.wcmp.model.msgVO.req;

/**
 * ��Ƶ��Ϣ��ȡ��������Ϣ��
 * ý��ID��MediaId	����ͼý��ID��ThumbMediaId
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class VideoMsg extends CommonInfoMsg{
	
	private String MediaId;
	private String ThumbMediaId;
	
	public String getMediaId(){
		return MediaId;
	}
	
	public String getThumbMediaId(){
		return ThumbMediaId;
	}
	
	public void setMediaId(String newmediaid){
		MediaId = newmediaid;
	}
	
	public void setThumbMediaId(String newthumbmediaid){
		ThumbMediaId = newthumbmediaid;
	}
	
}
