package org.ana.wcmp.model.biz.entry;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.ana.wcmp.context.DataContext;
import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.WechatBizSVC;
import org.ana.wcmp.db2modelVO.wechatBiz.IO_WechatCustomerBizVO;
import org.ana.wcmp.model.auth.WechatUserAuthentication;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.req.TextMsg;
import org.ana.wcmp.model.vo.wechatUser.WechatUserVO;
import org.ana.wcmp.util.string.StringUtil;

@SuppressWarnings({"rawtypes","unchecked"})
public class TextBizEntry {
	
	private TextMsg BizRequest;
	private RespMsgGeneralVO BizResp;
	
	public void dispatchAndProcess(){
		WechatUserVO user = new WechatUserVO();
		user.setOpenid(BizRequest.getFromUserName());
		WechatUserAuthentication wcuserauth = new WechatUserAuthentication();
		if (!wcuserauth.isActivatedUser(user)){
			this.BizResp = DataContext.USER_LOCKED;
			return;
		}
		
		if (!wcuserauth.isBasicInfoBound(user)){
			this.BizResp = DataContext.USER_BASIC_NOT_BOUND;
			return;
		}
		
		WechatBizSVC bizsvc = new WechatBizSVC();
		IO_WechatCustomerBizVO thisbiz = new IO_WechatCustomerBizVO();
		String BizContent = StringUtil.tokenInitializer(
				StringUtil.fullToHalf(
						BizRequest.getContent()),ServerContext.WCMP_BIZ_MARKER);	
		try{
			thisbiz.setBizCode(StringUtil.tokenizedStringToList(BizContent, ServerContext.WCMP_BIZ_MARKER).get(0));
		} catch (IndexOutOfBoundsException e){
			this.BizResp = DataContext.BIZ_NOT_FOUND;
			return;
		}
		try {
			thisbiz = bizsvc.getCustomerBizByCode(thisbiz);
			if (thisbiz == null) {
				this.BizResp = DataContext.BIZ_NOT_FOUND;
				return;
			}
			
			Class BizClass = Class.forName(thisbiz.getBizClass());
			Object BizObj = BizClass.newInstance();
			Method BizMethod = BizClass.getDeclaredMethod(thisbiz.getBizMethod(), new Class[]{TextMsg.class});
			BizMethod.invoke(BizObj, new Object[]{this.BizRequest});
			this.BizResp = (RespMsgGeneralVO) BizClass.getDeclaredMethod("getBizResp").invoke(BizObj, new Object[0]);
		} catch (DBServiceException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException | NoSuchMethodException e) {
			e.printStackTrace();
			this.BizResp = DataContext.BIZ_NOT_FOUND;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			this.BizResp = DataContext.WRONG_INPUT;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public TextMsg getBizRequest() {
		return BizRequest;
	}

	public void setBizRequest(TextMsg bizRequest) {
		BizRequest = bizRequest;
	}

	public RespMsgGeneralVO getBizResp() {
		return BizResp;
	}

	public void setBizResp(RespMsgGeneralVO bizResp) {
		BizResp = bizResp;
	}

}
