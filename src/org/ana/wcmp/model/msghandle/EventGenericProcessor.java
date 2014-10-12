package org.ana.wcmp.model.msghandle;

import org.ana.wcmp.model.eventreact.SubscribeProcess;
import org.ana.wcmp.model.mappings.EventMsgTypeMapping;
import org.ana.wcmp.model.vo.msg.EventMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.event.Subscribe;

public class EventGenericProcessor {
	
	private EventMsgGeneralVO event;
	
	public EventGenericProcessor(EventMsgGeneralVO event){
		this.event = event;
	}
	
	public RespMsgGeneralVO process(){
		
		switch(this.event.getEvent()){
		case EventMsgTypeMapping.SUBSCRIBE:
			SubscribeProcess sp = new SubscribeProcess();
			return sp.processSubscribe(this.general2subscribe());
		case EventMsgTypeMapping.UNSUBSCRIBE:
			SubscribeProcess unsp = new SubscribeProcess();
			unsp.processUnsubscribe(this.general2subscribe());
			break;
		case EventMsgTypeMapping.LOCATION:
			break;
		case EventMsgTypeMapping.SCAN:
			break;
		case EventMsgTypeMapping.CLICK:
			break;
		case EventMsgTypeMapping.VIEW:
		default:
		}
		
		return new RespMsgGeneralVO();
	}

	private Subscribe general2subscribe(){
		Subscribe subscribe = new Subscribe();
		subscribe.setCreateTime(this.event.getCreateTime());
		subscribe.setFromUserName(this.event.getFromUserName());
		subscribe.setToUserName(this.event.getToUserName());
		subscribe.setEvent(this.event.getEvent());
		subscribe.setMsgType(this.event.getMsgType());
		return subscribe;
	}
	
	public EventMsgGeneralVO getEvent() {
		return event;
	}

	public void setEvent(EventMsgGeneralVO event) {
		this.event = event;
	}

}
