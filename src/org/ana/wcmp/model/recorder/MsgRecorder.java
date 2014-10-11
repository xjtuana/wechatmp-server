package org.ana.wcmp.model.recorder;

import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.WechatMsgRecSVC;
import org.ana.wcmp.db2modelVO.wechatMsg.IN_ReqMsgGeneralVO;
import org.ana.wcmp.model.msgVO.ReqMsgGeneralVO;

public class MsgRecorder extends Thread{

	private IN_ReqMsgGeneralVO reqmsg;
	
	public MsgRecorder(ReqMsgGeneralVO reqmsg){
		this.reqmsg = new IN_ReqMsgGeneralVO(reqmsg);
	}
	
	public void run(){
		WechatMsgRecSVC msgsvc = new WechatMsgRecSVC();
		try {
			msgsvc.saveNewMsg(this.reqmsg);
		} catch (DBServiceException e) {
			e.printStackTrace();
		}
	}
}
