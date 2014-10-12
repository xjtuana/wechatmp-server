package org.ana.wcmp.model.auth;

import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.WechatUserSVC;
import org.ana.wcmp.db2modelVO.wechatUser.IO_SubWechatUserVO;
import org.ana.wcmp.model.vo.wechatUser.WechatUserVO;

public class WechatUserAuthentication {
	
	public boolean isBasicInfoBound(WechatUserVO user){
		IO_SubWechatUserVO userindb = new IO_SubWechatUserVO();
		userindb.setOpenid(user.getOpenid());
		try {
			return new WechatUserSVC().isBasicBound(userindb);
		} catch (DBServiceException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isActivatedUser(WechatUserVO user){
		IO_SubWechatUserVO userindb = new IO_SubWechatUserVO();
		userindb.setOpenid(user.getOpenid());
		try {
			return new WechatUserSVC().isActivatedUser(userindb);
		} catch (DBServiceException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
