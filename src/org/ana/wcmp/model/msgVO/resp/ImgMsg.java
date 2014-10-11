package org.ana.wcmp.model.msgVO.resp;

/**
 * 图片消息类，含有一个图片素材（对图片类进行了实例化）
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class ImgMsg extends CommonInfoResp{
	
	private Image Image;
	
	public Image getImage(){
		return Image;
	}
	
	public void setImage(Image newimage){
		Image = newimage;
	}

}
