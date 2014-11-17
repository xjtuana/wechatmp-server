package org.ana.wcmp.model.biz.user;

import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.req.TextMsg;

public class UserMgr {
	
	private RespMsgGeneralVO BizResp;
	
	public void boundBasicUser(TextMsg request){
		//TODO
	}
	
	public void unboundBasicUserBound(TextMsg request){
		//TODO
	}
	
	public RespMsgGeneralVO getBizResp() {
		return BizResp;
	}

	public void setBizResp(RespMsgGeneralVO bizResp) {
		BizResp = bizResp;
	}

}
