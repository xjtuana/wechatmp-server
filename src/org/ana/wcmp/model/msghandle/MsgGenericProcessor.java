package org.ana.wcmp.model.msghandle;

import org.ana.wcmp.model.mappings.ReqMsgTypeMapping;
import org.ana.wcmp.model.msgreact.TextMsgProcess;
import org.ana.wcmp.model.vo.msg.ReqMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.req.*;

public class MsgGenericProcessor {
	
	private ReqMsgGeneralVO reqmsg;
	
	public MsgGenericProcessor(){
	}
	
	public MsgGenericProcessor(ReqMsgGeneralVO reqmsg){
		this.reqmsg = reqmsg;
	}
	
	public RespMsgGeneralVO process(){
		
		switch(this.reqmsg.getMsgType()){
		case ReqMsgTypeMapping.TEXT_MSG:
			TextMsg reqtextmsg = this.general2text();
			TextMsgProcess tmpro = new TextMsgProcess();
			return tmpro.processTextMsg(reqtextmsg);
		case ReqMsgTypeMapping.PICTURE_MSG:
			break;
		case ReqMsgTypeMapping.LOCATION_MSG:
			break;
		case ReqMsgTypeMapping.LINK_MSG:
			break;
		case ReqMsgTypeMapping.VIDEO_MSG:
			break;
		case ReqMsgTypeMapping.VOICE_MSG:
			break;
		default:
			//TODO pointing to UnsupportedMsgType
		}
		
		return new RespMsgGeneralVO();
	}
	
	private TextMsg general2text(){
		TextMsg reqtextmsg = new TextMsg();
		reqtextmsg.setToUserName(this.reqmsg.getToUserName());
		reqtextmsg.setFromUserName(this.reqmsg.getFromUserName());
		reqtextmsg.setMsgId(this.reqmsg.getMsgId());
		reqtextmsg.setCreateTime(this.reqmsg.getCreateTime());
		reqtextmsg.setMsgType(this.reqmsg.getMsgType());
		reqtextmsg.setContent(this.reqmsg.getContent());
		return reqtextmsg;
	}
	
	public ReqMsgGeneralVO getReqmsg() {
		return reqmsg;
	}

	public void setReqmsg(ReqMsgGeneralVO reqmsg) {
		this.reqmsg = reqmsg;
	}

}
