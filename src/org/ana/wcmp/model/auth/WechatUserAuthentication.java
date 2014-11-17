package org.ana.wcmp.model.auth;

import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.WechatUserSVC;
import org.ana.wcmp.db2modelVO.wechatUser.IO_SubWechatUserVO;
import org.ana.wcmp.model.vo.wechatUser.WechatUserVO;

public class WechatUserAuthentication {
	
	public static final int ANYONE = 0;
	public static final int SELF_AND_ADMINS = 1;
	public static final int SELF_ONLY = 2;
	public static final int ADMINS_ONLY = 3;
	public static final int LEADERS_ONLY = 4;
	public static final int DEVELOPERS_ONLY = 5;
	
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
	
	public boolean isAuthorized(int authMethod, WechatUserVO user){
		boolean authorized = false;
		switch(authMethod){
		case ANYONE:
			authorized = true;
			break;
		case SELF_AND_ADMINS:
			authorized = this.authSelfAndAdmins(user);
			break;
		case SELF_ONLY:
			authorized = this.authSelfOnly(user);
			break;
		case ADMINS_ONLY:
			authorized = this.authAdminsOnly(user);
			break;
		case LEADERS_ONLY:
			authorized = this.authLeadersOnly(user);
			break;
		case DEVELOPERS_ONLY:
			authorized = this.authDevelopersOnly(user);
			break;
		default:
		}
		
		//TODO
		return authorized;
	}
	
	private boolean authSelfAndAdmins(WechatUserVO user){
		return (this.authAdminsOnly(user) || this.authSelfOnly(user));
	}
	
	private boolean authAdminsOnly(WechatUserVO user){
		//TODO
		return false;
	}
	
	private boolean authSelfOnly(WechatUserVO user){
		//TODO
		return false;
	}
	
	private boolean authLeadersOnly(WechatUserVO user){
		//TODO
		return false;
	}
	
	private boolean authDevelopersOnly(WechatUserVO user){
		//TODO
		return false;
	}
	
}
