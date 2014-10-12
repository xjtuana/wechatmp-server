package org.ana.wcmp.database.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.ana.wcmp.database.dao.WechatArticlePoolDAO;
import org.ana.wcmp.database.dao.WechatMsgPoolNewsDAO;
import org.ana.wcmp.database.dao.WechatTextPoolDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.ana.wcmp.database.util.BlobProcessor;
import org.ana.wcmp.db2modelVO.wechatMsg.OUT_RespMsgGeneralVO;
import org.ana.wcmp.model.mappings.RespMsgTypeMapping;
import org.ana.wcmp.model.vo.msg.resp.Article;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class WechatRespMsgSVC {
	
	public OUT_RespMsgGeneralVO getRespMsg(int msgtype, long msgpk) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
	    Transaction tx = session.beginTransaction();
	    
	    try {
	    	OUT_RespMsgGeneralVO returnmsg = new OUT_RespMsgGeneralVO();
	    	BlobProcessor bp = new BlobProcessor();
	    	switch (msgtype){
	    	case RespMsgTypeMapping.TEXT_MSG:
	    		WechatTextPoolDAO textmsg = (WechatTextPoolDAO) session.get(WechatTextPoolDAO.class, msgpk);
	    		if (textmsg != null){
	    			bp.setUnhandled_blob(textmsg.getText_msg_content());
	    			returnmsg.setContent(bp.blobToStr());
	    		}
	    		break;
	    	case RespMsgTypeMapping.NEWS_MSG:
	    		WechatMsgPoolNewsDAO newsmsg = (WechatMsgPoolNewsDAO) session.get(WechatMsgPoolNewsDAO.class, msgpk);
	    		List<Article> articles = new ArrayList<Article>();
	    		Class<WechatMsgPoolNewsDAO> msgpool = WechatMsgPoolNewsDAO.class;
	    		for (int i = 1; i <= 10; i++){
	    			Method m = msgpool.getDeclaredMethod("getNews_msg_article"+i);
	    			WechatArticlePoolDAO temparticle = (WechatArticlePoolDAO) m.invoke(newsmsg, new Object[0]);
	    			if (temparticle != null){
	    				Article article = new Article();
	    				article.setPicUrl(temparticle.getArticle_pic_uri());
	    				article.setUrl(temparticle.getArticle_url());
	    				if (temparticle.getArticle_desc() != null){
	    					bp.setUnhandled_blob(temparticle.getArticle_desc());
	    					article.setDescription(bp.blobToStr());
	    				}
	    				if (temparticle.getArticle_title() != null){
	    					bp.setUnhandled_blob(temparticle.getArticle_title());
	    					article.setTitle(bp.blobToStr());
	    				}
	    				articles.add(article);
	    			} else {
	    				continue;
	    			}
	    		}
	    		returnmsg.setArticleCount(articles.size());
	    		returnmsg.setArticles(articles.toArray(new Article[0]));
	    		break;
	    	case RespMsgTypeMapping.PICTURE_MSG:
	    		break;
	    	case RespMsgTypeMapping.VIDEO_MSG:
	    		break;
	    	case RespMsgTypeMapping.VOICE_MSG:
	    		break;
	    	default:
	    	}
	    	tx.commit();
	    	
	    	return returnmsg;
	    } catch (Exception e){
	    	e.printStackTrace();
	    	tx.rollback();
	    	
	    	throw new DBServiceException();
	    } finally {
	    	HibernateUtil.closeSession();
	    }
	}

}
