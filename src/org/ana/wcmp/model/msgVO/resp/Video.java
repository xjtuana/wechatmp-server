package org.ana.wcmp.model.msgVO.resp;

/**
 * ��Ƶ(�ز�)��Ķ��壬���а�����
 * ý��ID:MediaId    ����ͼID��ThumbMediaId
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class Video {
	
	private String MediaId;
	private String ThumbMediaId;
	
	public String getMediaId(){
		return MediaId;
	}

	public void setMediaId(String newmediaid){
		MediaId = newmediaid;
	}

	public String getThumbMediaId(){
		return ThumbMediaId;
	}

	public void setThumbMediaId(String newthumbmediaid){
		MediaId = newthumbmediaid;
	}
}
