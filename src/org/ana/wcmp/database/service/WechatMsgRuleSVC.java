package org.ana.wcmp.database.service;

import java.util.List;

import org.ana.wcmp.database.dao.WechatTextRespRuleDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.ana.wcmp.db2modelVO.wechatRule.IO_TextRespRuleVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

@SuppressWarnings("unchecked")
public class WechatMsgRuleSVC {
	
	public IO_TextRespRuleVO[] getAllTextRules() 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
	    Transaction tx = session.beginTransaction();
	    
	    try {
	    	Criteria txtrulecri = session.createCriteria(WechatTextRespRuleDAO.class);
	    	List<WechatTextRespRuleDAO>  txtrulelist = txtrulecri.list();
	    	IO_TextRespRuleVO[] txtrules = new IO_TextRespRuleVO[txtrulelist.size()];
	    	for (int i = 0; i < txtrules.length; i++){
	    		IO_TextRespRuleVO temptextrule = new IO_TextRespRuleVO();
	    		temptextrule.setRespMsgID(txtrulelist.get(i).getText_rule_resp_msg_id());
	    		temptextrule.setRespType(txtrulelist.get(i).getText_rule_resp_msg_type());
	    		temptextrule.setRuleID(txtrulelist.get(i).getPk_text_rule());
	    		temptextrule.setRuleKeyword(txtrulelist.get(i).getText_rule_keyword());
	    		temptextrule.setRuleName(txtrulelist.get(i).getText_rule_name());
	    		temptextrule.setRuleMode(txtrulelist.get(i).getText_rule_mode());
	    		txtrules[i] = temptextrule;
	    	}
	    	
	    	return txtrules;
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	tx.rollback();
	    	
	    	throw new DBServiceException();
	    } finally {
	    	HibernateUtil.closeSession();
	    }
	}

}
