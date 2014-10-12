package org.ana.wcmp.model.eventreact;

import java.util.Date;

import org.ana.wcmp.context.DataContext;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.WechatUserSVC;
import org.ana.wcmp.db2modelVO.wechatUser.IO_SubWechatUserVO;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.event.Subscribe;

public class SubscribeProcess {
	
	private RespMsgGeneralVO respmsg = new RespMsgGeneralVO();
	
	public RespMsgGeneralVO processSubscribe(Subscribe subscribe){
		WechatUserSVC wcusersvc = new WechatUserSVC();
		IO_SubWechatUserVO subuser = new IO_SubWechatUserVO();
		subuser.setOpenid(subscribe.getFromUserName());
		subuser.setStatus(1);
		subuser.setSubtime(subscribe.getCreateTime()*1000);
		try {
			wcusersvc.subscribeChange(subuser);
		} catch (DBServiceException e1) {
			e1.printStackTrace();
		}
		
		this.respmsg = DataContext.WELCOME_MSG;
		this.respmsg.setFromUserName(subscribe.getToUserName());
		this.respmsg.setToUserName(subscribe.getFromUserName());
		this.respmsg.setCreateTime(new Date().getTime()/1000);
		
		return this.respmsg;
	}

	public void processUnsubscribe(Subscribe subscribe){
		WechatUserSVC wcusersvc = new WechatUserSVC();
		IO_SubWechatUserVO subuser = new IO_SubWechatUserVO();
		subuser.setOpenid(subscribe.getFromUserName());
		subuser.setStatus(0);
		subuser.setUnsubtime(subscribe.getCreateTime()*1000);
		try {
			wcusersvc.subscribeChange(subuser);
		} catch (DBServiceException e1) {
			e1.printStackTrace();
		}
	}
	
}
