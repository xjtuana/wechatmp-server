package org.ana.wcmp.model.vo.msg.resp;

/**
 * ������Ϣ�࣬����һ�������زģ����ӣ����������������ʵ������
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class MusicMsg extends CommonInfoResp{
	
	private Music Music;
	
	public Music getMusic(){
		return Music;
	}
	
	public void setMusic(Music newmusic){
		Music = newmusic;
	}

}
