package org.ana.wcmp.database.service;

import java.util.Calendar;

import org.ana.wcmp.database.dao.WechatMsgRecDAO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.hibernate.HibernateUtil;
import org.ana.wcmp.db2modelVO.wechatMsg.IN_ReqMsgGeneralVO;
import org.ana.wcmp.model.mappings.ReqMsgTypeMapping;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class WechatMsgRecSVC {
	
	public void saveNewMsg(IN_ReqMsgGeneralVO inmsg ) 
			throws DBServiceException{
		Session session = HibernateUtil.currentSession();
	    Transaction tx = session.beginTransaction();
	    LobHelper l = session.getLobHelper();
	    
	    try {
	    	WechatMsgRecDAO wmsg = new WechatMsgRecDAO();
	    	wmsg.setMsg_to_user(inmsg.getToUserName());
	    	wmsg.setMsg_from_user(inmsg.getFromUserName());
	    	Calendar createtime = Calendar.getInstance();
	    	createtime.setTimeInMillis(inmsg.getCreateTime() * 1000);
	    	wmsg.setMsg_rcv_time(createtime);
	    	wmsg.setMsg_type(inmsg.getMsgType());
	    	wmsg.setMsg_id(inmsg.getMsgId());
	    	switch (inmsg.getMsgType()){
	    	case ReqMsgTypeMapping.TEXT_MSG:   		
	    		wmsg.setMsg_content(l.createBlob(
						inmsg.getContent().getBytes("utf-8")));
	    	case ReqMsgTypeMapping.PICTURE_MSG:
	    		wmsg.setMsg_mediaid(inmsg.getMediaId());
	    		wmsg.setMsg_picurl(inmsg.getPicUrl());
	    	case ReqMsgTypeMapping.VOICE_MSG:
	    		wmsg.setMsg_format(inmsg.getFormat());
	    		wmsg.setMsg_mediaid(inmsg.getMediaId());
	    		if (inmsg.getRecognition() != null){
	    			wmsg.setMsg_recognition(l.createBlob(
	    					inmsg.getRecognition().getBytes("utf-8")));
	    		}
	    	case ReqMsgTypeMapping.VIDEO_MSG:
	    		wmsg.setMsg_mediaid(inmsg.getMediaId());
	    		wmsg.setMsg_thumb_mediaid(inmsg.getThumbMediaId());
	    	case ReqMsgTypeMapping.LOCATION_MSG:
	    		wmsg.setMsg_location_x(inmsg.getLocation_X());
	    		wmsg.setMsg_location_y(inmsg.getLocation_Y());
	    		wmsg.setMsg_scale(inmsg.getScale());
	    		wmsg.setMsg_label(inmsg.getLabel());
	    	case ReqMsgTypeMapping.LINK_MSG:
	    		wmsg.setMsg_url_title(inmsg.getTitle());
	    		if (inmsg.getDescription() != null) {
	    			wmsg.setMsg_url_desc(l.createBlob(
	    					inmsg.getDescription().getBytes("utf-8")));
	    		}
	    		wmsg.setMsg_url(inmsg.getUrl());
	    	case ReqMsgTypeMapping.UNKNOWN_MSG:
	    	
	    	}
	    	session.save(wmsg);
	    	tx.commit();
	    } catch (Exception e){
	    	e.printStackTrace();
	    	tx.rollback();
	    	
	    	throw new DBServiceException();
	    } finally {
	    	HibernateUtil.closeSession();
	    }
		
	}

}
