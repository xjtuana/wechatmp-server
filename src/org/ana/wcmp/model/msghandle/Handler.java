package org.ana.wcmp.model.msghandle;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.ana.wcmp.model.mappings.EventMsgTypeMapping;
import org.ana.wcmp.model.mappings.ReqMsgTypeMapping;
import org.ana.wcmp.model.recorder.MsgRecorder;
import org.ana.wcmp.model.vo.msg.EventMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.ReqMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.ana.wcmp.util.parser.XMLparser;
import org.ana.wcmp.view.packmsg.MsgPacker;

public class Handler {
	
	public String processReq(HttpServletRequest request){
		
		HashMap<String,String> rawReqMsg = new HashMap<String,String>();
		RespMsgGeneralVO respmsg;
		try {
			rawReqMsg = XMLparser.parseXml(request);			
			if( rawReqMsg.get("MsgType").equalsIgnoreCase("event")) {	
				EventMsgGeneralVO event = this.packReqEvent(rawReqMsg);
				EventGenericProcessor eventprocessor = new EventGenericProcessor(event);
				respmsg = eventprocessor.process();
			} else {
				ReqMsgGeneralVO reqmsg = this.packReqMsg(rawReqMsg);
				MsgRecorder mrec = new MsgRecorder(reqmsg);
				mrec.start();
				MsgGenericProcessor msgprocessor = new MsgGenericProcessor(reqmsg);
				respmsg = msgprocessor.process();
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
			respmsg = null;
		}
		
		MsgPacker mpack = new MsgPacker();
		return mpack.general2anyMsg(respmsg);	
	}
	
	private ReqMsgGeneralVO packReqMsg(HashMap<String,String> reqmsg_raw){
		ReqMsgGeneralVO reqmsg = new ReqMsgGeneralVO();
		ReqMsgTypeMapping rtmap = new ReqMsgTypeMapping();
		reqmsg.setToUserName(reqmsg_raw.get("ToUserName"));
		reqmsg.setFromUserName(reqmsg_raw.get("FromUserName"));
		reqmsg.setCreateTime(Long.parseLong(reqmsg_raw.get("CreateTime")));
		reqmsg.setMsgType(rtmap.mapReqMsg(reqmsg_raw.get("MsgType")));
		reqmsg.setMsgId(reqmsg_raw.get("MsgId"));
		reqmsg.setContent(reqmsg_raw.get("Content"));
		reqmsg.setPicUrl(reqmsg_raw.get("PicUrl"));
		reqmsg.setMediaId(reqmsg_raw.get("MediaId"));
		reqmsg.setFormat(reqmsg_raw.get("Format"));
		reqmsg.setRecognition(reqmsg_raw.get("Recognition"));
		reqmsg.setThumbMediaId(reqmsg_raw.get("ThumbMediaId"));
		reqmsg.setLocation_X(reqmsg_raw.get("Location_X"));
		reqmsg.setLocation_Y(reqmsg_raw.get("Location_Y"));
		reqmsg.setScale(reqmsg_raw.get("Scale"));
		reqmsg.setLabel(reqmsg_raw.get("Label"));
		reqmsg.setTitle(reqmsg_raw.get("Title"));
		reqmsg.setDescription(reqmsg_raw.get("Description"));
		reqmsg.setUrl(reqmsg_raw.get("Url"));
		return reqmsg;
	}

	private EventMsgGeneralVO packReqEvent(HashMap<String,String> reqmsg_raw){
		EventMsgGeneralVO event = new EventMsgGeneralVO();
		EventMsgTypeMapping etmap = new EventMsgTypeMapping();
		event.setToUserName(reqmsg_raw.get("ToUserName"));
		event.setFromUserName(reqmsg_raw.get("FromUserName"));
		event.setCreateTime(Long.parseLong(reqmsg_raw.get("CreateTime")));
		event.setMsgType(ReqMsgTypeMapping.EVENT);
		event.setEvent(etmap.mapEvent(reqmsg_raw.get("Event")));
		event.setEventKey(reqmsg_raw.get("EventKey"));
		event.setLatitude(reqmsg_raw.get("Latitude"));
		event.setLongitude(reqmsg_raw.get("Longitude"));
		event.setPrecision(reqmsg_raw.get("Precision"));
		event.setTicket(reqmsg_raw.get("Ticket"));
		return event;
	}
}
