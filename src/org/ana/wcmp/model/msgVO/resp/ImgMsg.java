package org.ana.wcmp.model.msgVO.resp;

/**
 * ͼƬ��Ϣ�࣬����һ��ͼƬ�زģ���ͼƬ�������ʵ������
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
