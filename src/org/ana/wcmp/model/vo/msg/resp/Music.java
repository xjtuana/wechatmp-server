package org.ana.wcmp.model.vo.msg.resp;

/**
 * 音乐(素材)类的定义，其中包含：
 * 标题:Title   描述：Description   音乐链接：MusicUrl    高品音乐链接（Wi-Fi环境优先使用）：HQMusicUrl    缩略图ID：ThumbMediaId
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class Music {
	
	private String Title;
	private String Description;
	private String MusicUrl;
	private String HQMusicUrl;
	private String ThumbMediaId;
	
	public String getTitle(){
		return Title;
	}
	
	public String getDescription(){
		return Description;
	}
	
	public String getMusicUrl(){
		return MusicUrl;
	}
	
	public String getHQMusicUrl(){
		return HQMusicUrl;
	}
	
	public String getThumbMediaId(){
		return ThumbMediaId;
	}
	
	public void setTitle(String newtitle){
		Title = newtitle;
	}
	
	public void setDescription(String newdescription){
		Description = newdescription;
	}
	
	public void setMusicUrl(String newmusicurl){
		MusicUrl = newmusicurl;
	}
	
	public void setHQMusicUrl(String newhqmusicurl){
		HQMusicUrl = newhqmusicurl;
	}
	
	public void setThumbMediaId(String newthumbmediaid){
		ThumbMediaId = newthumbmediaid;
	}

}
