package org.ana.wcmp.model.vo.msg.resp;

/**
 * 视频消息类，含有一个视频素材（媒体ID拉取）（对视频类进行了实例化）
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class VideoMsg extends CommonInfoResp{
	
	private Video Video;
	
	public Video getVideo(){
		return Video;
	}
	
	public void setVideo(Video newvideo){
		Video = newvideo;
	}

}
