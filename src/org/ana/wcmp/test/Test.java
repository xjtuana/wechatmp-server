package org.ana.wcmp.test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Date;

import org.ana.wcmp.context.DataContext;
import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.context.vo.StaffContextInfoVO;
import org.ana.wcmp.database.dao.WechatTextPoolDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.ana.wcmp.database.service.WechatRespMsgSVC;
import org.ana.wcmp.database.util.BlobProcessor;
import org.ana.wcmp.db2modelVO.domain.IO_BuildingVO;
import org.ana.wcmp.db2modelVO.staff.OUT_StaffContactInfoVO;
import org.ana.wcmp.db2modelVO.wechatBiz.IO_WechatCustomerBizVO;
import org.ana.wcmp.db2modelVO.wechatMsg.OUT_RespMsgGeneralVO;
import org.ana.wcmp.db2modelVO.wechatRule.IO_TextRespRuleVO;
import org.ana.wcmp.model.initializers.DataContextInitialize;
import org.ana.wcmp.model.initializers.ServerContextInitialize;
import org.ana.wcmp.model.vo.msg.ReqMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	
	public static void main(String args[]){
			Field[] f = OUT_StaffContactInfoVO.class.getDeclaredFields();
			for (int i = 0; i < f.length; i++){
				System.out.println("thisadmin.set"+f[i].getName()+"(tempstaff.get"+f[i].getName()+"());");
			}

	}

}
