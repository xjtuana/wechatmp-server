package org.ana.wcmp.model.msgVO.req;

/**
 * 图片位置消息提取，包含信息：
 * 图片地址：PicUrl
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class PicMsg extends CommonInfoMsg{

	private String PicUrl;
	private String MediaId;
	
	public String getPicUrl(){
		return this.PicUrl;
	}

	public void setPicUrl(String picurl){
		this.PicUrl = picurl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		this.MediaId = mediaId;
	}
}
