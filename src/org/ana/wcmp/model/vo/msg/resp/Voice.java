package org.ana.wcmp.model.vo.msg.resp;

/**
 * 语音(素材)类的定义，其中包含：
 * 媒体ID:MediaId	
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class Voice {
	
	private String MediaId;
	
	public String getMediaId(){
		return MediaId;
	}

	public void setMediaId(String newmediaid){
		MediaId = newmediaid;
	}

}
