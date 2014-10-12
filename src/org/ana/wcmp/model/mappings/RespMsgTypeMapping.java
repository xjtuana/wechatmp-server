package org.ana.wcmp.model.mappings;

public class RespMsgTypeMapping {
	
	public static final int TEXT_MSG = 0;
	public static final int NEWS_MSG = 1;
	public static final int PICTURE_MSG = 2;
	public static final int VOICE_MSG = 3;
	public static final int VIDEO_MSG = 4;
	public static final int MUSIC_MSG = 5;
	
	public String mapReturnType(int resptype){
		switch(resptype){
		case TEXT_MSG: return "text";
		case NEWS_MSG: return "news";
		case PICTURE_MSG: return "image";
		case VOICE_MSG: return "voice";
		case VIDEO_MSG: return "video";
		case MUSIC_MSG: return "music";
		default: return "unknown";
		}
	}

}
