package org.ana.wcmp.model.vo.msg.resp;

/**
 * ����(�ز�)��Ķ��壬���а�����
 * ����:Title   ������Description   �������ӣ�MusicUrl    ��Ʒ�������ӣ�Wi-Fi��������ʹ�ã���HQMusicUrl    ����ͼID��ThumbMediaId
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
