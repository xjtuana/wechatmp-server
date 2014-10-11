package org.ana.wcmp.model.msgVO.req;

/**
 * 文本消息提取，包含信息：
 * 文本内容：Content
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
