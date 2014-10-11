package org.ana.wcmp.model.msgVO.resp;

/**
 * 视频(素材)类的定义，其中包含：
 * 媒体ID:MediaId    缩略图ID：ThumbMediaId
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
