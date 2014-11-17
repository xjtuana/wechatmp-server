package org.ana.wcmp.model.auth;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.util.encrypt.StringEncrypt;

public class InquiryAuthentication {
	
	public boolean isAuthorized(String signature){
		String rawkey = new SimpleDateFormat("yyyyMMddHHmm").format(new Date())+ServerContext.INQUIRY_AUTH_KEY;
		if (StringEncrypt.doEnc(rawkey, "md5").equalsIgnoreCase(signature)){
			return true;
		}
		return false;
	}

}
