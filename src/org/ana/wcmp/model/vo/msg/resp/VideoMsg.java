package org.ana.wcmp.model.vo.msg.resp;

/**
 * ��Ƶ��Ϣ�࣬����һ����Ƶ�زģ�ý��ID��ȡ��������Ƶ�������ʵ������
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
