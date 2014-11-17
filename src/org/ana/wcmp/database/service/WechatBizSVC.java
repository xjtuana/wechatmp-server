package org.ana.wcmp.database.service;

import java.util.List;

import org.ana.wcmp.database.dao.WechatBizDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.ana.wcmp.database.util.BlobProcessor;
import org.ana.wcmp.db2modelVO.wechatBiz.IO_WechatCustomerBizVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public class WechatBizSVC {
	
	public IO_WechatCustomerBizVO getCustomerBizByCode(IO_WechatCustomerBizVO rawbiz) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Criteria cusbizcri = session.createCriteria(WechatBizDAO.class);
			cusbizcri.add(Restrictions.eq("wechat_biz_isadmin", false));
			cusbizcri.add(Restrictions.eq("wechat_biz_code", rawbiz.getBizCode()));
			List<WechatBizDAO> foundbiz = cusbizcri.list();
			if (foundbiz == null || foundbiz.size() <= 0) {
				tx.commit();
				return null;
			}
			WechatBizDAO thisbiz = foundbiz.get(0);
			rawbiz.setBizName(thisbiz.getWechat_biz_name());
			rawbiz.setBizLabel(thisbiz.getWechat_biz_label());
			rawbiz.setBizClass(thisbiz.getWechat_biz_class());
			rawbiz.setBizMethod(thisbiz.getWechat_biz_method());
			rawbiz.setBizAuthLevel(thisbiz.getWechat_biz_auth_level());
			if (thisbiz.getWechat_biz_rtn_param_ph() != null) {
				BlobProcessor bp = new BlobProcessor();
				bp.setUnhandled_blob(thisbiz.getWechat_biz_rtn_param_ph());
				rawbiz.setBizRtnParamPlaceholders(bp.blobToStr());
			}
			tx.commit();
			
			return rawbiz;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			
			throw new DBServiceException();
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
