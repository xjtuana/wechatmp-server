package org.ana.wcmp.model.msgVO.req;

/**
 * 视频消息提取，包含信息：
 * 媒体ID：MediaId	缩略图媒体ID：ThumbMediaId
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
