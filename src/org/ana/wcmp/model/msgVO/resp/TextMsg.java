package org.ana.wcmp.model.msgVO.resp;

/**
 * ������Ϣ��Ķ��壬���а�����
 * ��Ϣ����:Content
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class TextMsg extends CommonInfoResp{
	
	private String Content;
	 
	public String getContent(){
		return Content;
	}

	public void setContent(String newcontent){
		Content = newcontent;
	}
}
