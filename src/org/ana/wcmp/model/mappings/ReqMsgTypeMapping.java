package org.ana.wcmp.model.mappings;

public class ReqMsgTypeMapping {
	
	public static final int TEXT_MSG = 0;
	public static final int PICTURE_MSG = 1;
	public static final int VOICE_MSG = 2;
	public static final int VIDEO_MSG = 3;
	public static final int LOCATION_MSG = 4;
	public static final int LINK_MSG = 5;
	public static final int EVENT = 99;
	
	public static final int UNKNOWN_MSG = -1;
	
	public int mapReqMsg(String in_type){
		in_type = in_type.toLowerCase();
		switch (in_type){
		case "text": return TEXT_MSG;
		case "image": return PICTURE_MSG;
		case "voice": return VOICE_MSG;
		case "video": return VIDEO_MSG;
		case "location": return LOCATION_MSG;
		case "link": return LINK_MSG;
		case "event": return EVENT;
		default: return UNKNOWN_MSG;
		}
	}

}
