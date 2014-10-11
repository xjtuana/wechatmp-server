package org.ana.wcmp.model.msgVO.req;

/**
 * ����λ����Ϣ��ȡ��������Ϣ��
 * γ�ȣ�Location_X	���ȣ�Location_Y	��ͼ���Ŵ�С��Scale	����λ����Ϣ��Label
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
