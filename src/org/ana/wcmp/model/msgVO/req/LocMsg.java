package org.ana.wcmp.model.msgVO.req;

/**
 * 地理位置消息提取，包含信息：
 * 纬度：Location_X	经度：Location_Y	地图缩放大小：Scale	地理位置信息：Label
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class LocMsg extends CommonInfoMsg{
	
	private String Location_X;
	private String Location_Y;
	private String Scale;
	private String Label;
	
	public String getLocation_X(){
		return Location_X;		
	}
	
	public String getLocation_Y(){
		return Location_Y;	
	}

	public String getScale(){
		return Scale;
	}
	
	public String getLabel(){
		return Label;
	}
	
	public void setLocation_X(String newlocx){
		Location_X = newlocx;
	}

	public void setMyName(String newlocy){
		Location_Y = newlocy;
	}
	
	public void setScale(String newscale){
		Scale = newscale;
	}
	
	public void setLabel(String newlabel){
		Label = newlabel;
	}
}
