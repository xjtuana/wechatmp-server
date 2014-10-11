package org.ana.wcmp.model.msgVO.resp;

/**
 * 文字消息类的定义，其中包含：
 * 消息内容:Content
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
