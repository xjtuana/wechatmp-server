package org.ana.wcmp.model.msgVO.req;

/**
 * �ı���Ϣ��ȡ��������Ϣ��
 * �ı����ݣ�Content
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class TextMsg extends CommonInfoMsg{
	
	private String Content;
	 
	public String getContent(){
		return Content;
	}

	public void setContent(String newcontent){
		Content = newcontent;
	}
}
