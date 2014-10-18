package org.ana.wcmp.model.vo.msg.resp;

/**
 * ͼ����Ķ��壬���а�����
 * ����:Title   ������Description   ͼƬ����ַ����PicUrl   ��Ϣ��ַ��Url	
 * ͼ����ϢʵΪ���ż򱨣�Ϊͼ���飨����һͼ��һ���⣩����Ϊ�������ݵ��ࡣ
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
