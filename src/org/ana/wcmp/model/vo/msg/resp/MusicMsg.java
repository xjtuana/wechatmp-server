package org.ana.wcmp.model.vo.msg.resp;

/**
 * 音乐消息类，含有一个音乐素材（链接）（对音乐类进行了实例化）
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
