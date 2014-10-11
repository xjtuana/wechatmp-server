package org.ana.wcmp.model.mappings;

public class EventMsgTypeMapping {
	
	public static final int SUBSCRIBE = 0;
	public static final int UNSUBSCRIBE=1;
	public static final int SCAN = 2;
	public static final int LOCATION = 3;
	public static final int CLICK = 4;
	public static final int VIEW = 5;
	
	public static final int UNKNOWN_EVENT = -1;
	
	public int mapEvent(String in_type){
		in_type = in_type.toLowerCase();
		switch (in_type){
		case "subscribe": return SUBSCRIBE;
		case "unsubscribe": return UNSUBSCRIBE;
		case "scan": return SCAN;
		case "location": return LOCATION;
		case "click": return CLICK;
		case "view": return VIEW;
		default: return UNKNOWN_EVENT;
		}
	}

}
