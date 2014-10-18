package org.ana.wcmp.model.vo.msg.req;

/**
 * ������Ϣ��ȡ��������Ϣ��
 * ���⣺Title	����������Description	���ӵ�ַ��Url
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class UrlMsg extends CommonInfoMsg{
	
	private String Title;
	private String Description;
	private String Url;

	public String getTitle(){
		return Title;
	}

	public String getDescription(){
		return Description;
	}
	
	public String getUrl(){
		return Url;
	}
	
	public void setTitle(String newtitle){
		Title = newtitle;
	}

	public void setDescription(String newdescription){
		Description = newdescription;
	}
	
	public void setRecognition(String newurl){
		Url = newurl;
	}

}
