package org.ana.wcmp.model.vo.msg.resp;

/**
 * 图文类的定义，其中包含：
 * 标题:Title   描述：Description   图片（地址）：PicUrl   消息地址：Url	
 * 图文消息实为新闻简报，为图文组（多组一图配一标题），此为单条内容的类。
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class Article {
	
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;
	
	public String getTitle(){
		return Title;
	}
	
	public String getDescription(){
		return null == Description ? "" : Description;
	}
	
	public String getPicUrl(){
		return null == PicUrl ? "" : PicUrl;
	}
	
	public String getUrl(){
		return null == Url ? "" : Url;
	}
	
	public void setTitle(String newtitle){
		Title = newtitle;
	}
	
	public void setDescription(String newdescription){
		Description = newdescription;
	}
	
	public void setPicUrl(String newpicurl){
		PicUrl = newpicurl;
	}
	
	public void setUrl(String newurl){
		Url = newurl;
	}
	
}
