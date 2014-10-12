package org.ana.wcmp.model.initializers;

import org.ana.wcmp.context.DataContext;
import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.context.vo.BuildingContextVO;
import org.ana.wcmp.context.vo.StaffContextInfoVO;
import org.ana.wcmp.context.vo.TextRespRuleContextVO;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.DomainSVC;
import org.ana.wcmp.database.service.StaffSVC;
import org.ana.wcmp.database.service.WechatMsgRuleSVC;
import org.ana.wcmp.database.service.WechatRespMsgSVC;
import org.ana.wcmp.db2modelVO.domain.IO_BuildingVO;
import org.ana.wcmp.db2modelVO.staff.OUT_StaffContactInfoVO;
import org.ana.wcmp.db2modelVO.staff.OUT_StaffRespBuildingVO;
import org.ana.wcmp.db2modelVO.wechatMsg.OUT_RespMsgGeneralVO;
import org.ana.wcmp.db2modelVO.wechatRule.IO_TextRespRuleVO;

public class DataContextInitialize {
	
	public void initBuildingContext(){
		DomainSVC dsvc = new DomainSVC();
		try {
			IO_BuildingVO[] rawbuildings = dsvc.getAllBuildings();
			BuildingContextVO[] buildings = new BuildingContextVO[rawbuildings.length];
			for (int i = 0; i < buildings.length; i++){
				BuildingContextVO tempbuilding = new BuildingContextVO();
				tempbuilding.setBuilding_id(rawbuildings[i].getBuilding_id());
				tempbuilding.setBuilding_name(rawbuildings[i].getBuilding_name());
				tempbuilding.setBuilding_desc(rawbuildings[i].getBuilding_desc());
				tempbuilding.setBuilding_group_id(rawbuildings[i].getBuilding_group_id());
				tempbuilding.setBuilding_area_id(rawbuildings[i].getBuilding_area_id());
				buildings[i] = tempbuilding;
			}
			synchronized(DataContext.BUILDING_CONTEXT){
				DataContext.BUILDING_CONTEXT = buildings;
			}
		} catch (DBServiceException e) {
			e.printStackTrace();
		}
	}
	
	public void initStaffContext(){
		StaffSVC ssvc = new StaffSVC();
		try{
			OUT_StaffContactInfoVO[] staffcontact = ssvc.getAllActiveStaffContactInfo();
			OUT_StaffRespBuildingVO[] staffbuildings = ssvc.getAllStaffRespBuilding();
			StaffContextInfoVO[] staff = new StaffContextInfoVO[staffcontact.length];
			for (int i = 0; i<staff.length; i++ ){
				staff[i] = new StaffContextInfoVO();
				staff[i].setStaff_id(staffcontact[i].getStaff_id());
				staff[i].setStaff_name(staffcontact[i].getStaff_name());
				staff[i].setStaff_gender(staffcontact[i].getStaff_gender()?"ÄÐ":"Å®");
				staff[i].setStaff_stuid(staffcontact[i].getStaff_stuid());
				staff[i].setStaff_phone(staffcontact[i].getStaff_phone());
				staff[i].setStaff_qq(staffcontact[i].getStaff_qq());
				staff[i].setStaff_wechat_acc(staffcontact[i].getStaff_wechat_acc());
				staff[i].setStaff_selfdesc(staffcontact[i].getStaff_selfdesc());
				staff[i].setStaff_campus(staffcontact[i].getStaff_campus());
				staff[i].setStaff_addrbuilding(staffcontact[i].getStaff_addrbuilding());
				staff[i].setStaff_addrroom(staffcontact[i].getStaff_addrroom());
//				staff[i].setDomain_building_ids(ssvc.getStaffRespBuilding(staffcontact[i].getStaff_id()));
				for (int ii = 0; ii<staffbuildings.length; ii++){
					if (staffbuildings[ii].getStaff_id() == staff[i].getStaff_id()){
						long[] thisrel = staffbuildings[ii].getBuilding_id();
						long[] newrel = new long[thisrel.length];
						for (int iii = 0; iii < thisrel.length; iii++){
							for (int iiii = 0; iiii < DataContext.BUILDING_CONTEXT.length; iiii++){
								if (DataContext.BUILDING_CONTEXT[iiii].getBuilding_id() == thisrel[iii]){
									newrel[iii] = (long)iiii;
									break;
								}
							}
						}
						staff[i].setDomain_building_pointers(newrel);
						break;
					}
				}
			}
			synchronized(DataContext.STAFF_CONTEXT){
				DataContext.STAFF_CONTEXT = staff;
			}
		} catch (DBServiceException dbe){
			dbe.printStackTrace();
		}
	}
	
	public void initRuleContext(){
		WechatMsgRuleSVC wmrsvc = new WechatMsgRuleSVC();
		try {
			IO_TextRespRuleVO[] gettedtxtrules = wmrsvc.getAllTextRules();
			TextRespRuleContextVO[] txtrules = new TextRespRuleContextVO[gettedtxtrules.length];
			for (int i = 0; i < gettedtxtrules.length; i++){
				TextRespRuleContextVO temptxtrules = new TextRespRuleContextVO();
				temptxtrules.setRuleID(gettedtxtrules[i].getRuleID());
				temptxtrules.setRuleName(gettedtxtrules[i].getRuleName());
				temptxtrules.setRuleKeyword(gettedtxtrules[i].getRuleKeyword());
				temptxtrules.setRuleMode(gettedtxtrules[i].getRuleMode());
				temptxtrules.setRespType(gettedtxtrules[i].getRespType());
				temptxtrules.setRespMsgID(gettedtxtrules[i].getRespMsgID());
				txtrules[i] = temptxtrules;
			}
			synchronized(DataContext.TEXT_RULES){
				DataContext.TEXT_RULES = txtrules;
			}
		} catch (DBServiceException e) {
			e.printStackTrace();
		}
	}
	
	public void initMsgContext(){
		WechatRespMsgSVC wrespsvc = new WechatRespMsgSVC();
		synchronized(DataContext.UNKNOWN_MSG){
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(ServerContext.WCMP_UNKNOWN_MSG_RESP_TYPE, ServerContext.WCMP_UNKNOWN_MSG_RESP_ID);
				DataContext.UNKNOWN_MSG.setMsgType(ServerContext.WCMP_UNKNOWN_MSG_RESP_TYPE);
				DataContext.UNKNOWN_MSG.setContent(gettedrespmsg.getContent());
				DataContext.UNKNOWN_MSG.setMediaId(gettedrespmsg.getMediaId());
				DataContext.UNKNOWN_MSG.setTitle(gettedrespmsg.getTitle());
				DataContext.UNKNOWN_MSG.setDescription(gettedrespmsg.getDescription());
				DataContext.UNKNOWN_MSG.setMusicURL(gettedrespmsg.getMusicURL());
				DataContext.UNKNOWN_MSG.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				DataContext.UNKNOWN_MSG.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				DataContext.UNKNOWN_MSG.setArticleCount(gettedrespmsg.getArticleCount());
				DataContext.UNKNOWN_MSG.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		}
		
		synchronized(DataContext.BIZ_NOT_FOUND){
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(ServerContext.WCMP_BIZ_NOT_FOUND_TYPE, ServerContext.WCMP_BIZ_NOT_FOUND_ID);
				DataContext.BIZ_NOT_FOUND.setMsgType(ServerContext.WCMP_BIZ_NOT_FOUND_TYPE);
				DataContext.BIZ_NOT_FOUND.setContent(gettedrespmsg.getContent());
				DataContext.BIZ_NOT_FOUND.setMediaId(gettedrespmsg.getMediaId());
				DataContext.BIZ_NOT_FOUND.setTitle(gettedrespmsg.getTitle());
				DataContext.BIZ_NOT_FOUND.setDescription(gettedrespmsg.getDescription());
				DataContext.BIZ_NOT_FOUND.setMusicURL(gettedrespmsg.getMusicURL());
				DataContext.BIZ_NOT_FOUND.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				DataContext.BIZ_NOT_FOUND.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				DataContext.BIZ_NOT_FOUND.setArticleCount(gettedrespmsg.getArticleCount());
				DataContext.BIZ_NOT_FOUND.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		}
		
		synchronized(DataContext.USER_BASIC_NOT_BOUND){
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(ServerContext.WCMP_BASIC_USER_NOT_BOUND_TYPE, ServerContext.WCMP_BASIC_USER_NOT_BOUND_ID);
				DataContext.USER_BASIC_NOT_BOUND.setMsgType(ServerContext.WCMP_BASIC_USER_NOT_BOUND_TYPE);
				DataContext.USER_BASIC_NOT_BOUND.setContent(gettedrespmsg.getContent().replaceAll(":VBASIC_USER_BOUDN_HREF", "http://"+ServerContext.WEBROOT_PATH+ServerContext.WCMP_BASIC_BIND_URI));
				DataContext.USER_BASIC_NOT_BOUND.setMediaId(gettedrespmsg.getMediaId());
				DataContext.USER_BASIC_NOT_BOUND.setTitle(gettedrespmsg.getTitle());
				DataContext.USER_BASIC_NOT_BOUND.setDescription(gettedrespmsg.getDescription());
				DataContext.USER_BASIC_NOT_BOUND.setMusicURL(gettedrespmsg.getMusicURL());
				DataContext.USER_BASIC_NOT_BOUND.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				DataContext.USER_BASIC_NOT_BOUND.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				DataContext.USER_BASIC_NOT_BOUND.setArticleCount(gettedrespmsg.getArticleCount());
				DataContext.USER_BASIC_NOT_BOUND.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		}
		
		synchronized(DataContext.WELCOME_MSG){
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(ServerContext.WCMP_WELCOME_MSG_TYPE, ServerContext.WCMP_WELCOME_MSG_ID);
				DataContext.WELCOME_MSG.setMsgType(ServerContext.WCMP_WELCOME_MSG_TYPE);
				DataContext.WELCOME_MSG.setContent(gettedrespmsg.getContent());
				DataContext.WELCOME_MSG.setMediaId(gettedrespmsg.getMediaId());
				DataContext.WELCOME_MSG.setTitle(gettedrespmsg.getTitle());
				DataContext.WELCOME_MSG.setDescription(gettedrespmsg.getDescription());
				DataContext.WELCOME_MSG.setMusicURL(gettedrespmsg.getMusicURL());
				DataContext.WELCOME_MSG.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				DataContext.WELCOME_MSG.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				DataContext.WELCOME_MSG.setArticleCount(gettedrespmsg.getArticleCount());
				DataContext.WELCOME_MSG.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		}
		
		synchronized(DataContext.WRONG_INPUT){
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(ServerContext.WCMP_BIZ_WRONG_INPUT_TYPE, ServerContext.WCMP_BIZ_WRONG_INPUT_ID);
				DataContext.WRONG_INPUT.setMsgType(ServerContext.WCMP_BIZ_WRONG_INPUT_TYPE);
				DataContext.WRONG_INPUT.setContent(gettedrespmsg.getContent());
				DataContext.WRONG_INPUT.setMediaId(gettedrespmsg.getMediaId());
				DataContext.WRONG_INPUT.setTitle(gettedrespmsg.getTitle());
				DataContext.WRONG_INPUT.setDescription(gettedrespmsg.getDescription());
				DataContext.WRONG_INPUT.setMusicURL(gettedrespmsg.getMusicURL());
				DataContext.WRONG_INPUT.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				DataContext.WRONG_INPUT.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				DataContext.WRONG_INPUT.setArticleCount(gettedrespmsg.getArticleCount());
				DataContext.WRONG_INPUT.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		}
		
		synchronized(DataContext.HANDIN_ORDER_FAILED){
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(ServerContext.WCMP_HANDIN_ORDER_FAILED_TYPE, ServerContext.WCMP_HANDIN_ORDER_FAILED_ID);
				DataContext.HANDIN_ORDER_FAILED.setMsgType(ServerContext.WCMP_HANDIN_ORDER_FAILED_TYPE);
				DataContext.HANDIN_ORDER_FAILED.setContent(gettedrespmsg.getContent().replaceAll(":VBASIC_USER_BOUDN_HREF", "http://"+ServerContext.WEBROOT_PATH+ServerContext.WCMP_BASIC_BIND_URI));
				DataContext.HANDIN_ORDER_FAILED.setMediaId(gettedrespmsg.getMediaId());
				DataContext.HANDIN_ORDER_FAILED.setTitle(gettedrespmsg.getTitle());
				DataContext.HANDIN_ORDER_FAILED.setDescription(gettedrespmsg.getDescription());
				DataContext.HANDIN_ORDER_FAILED.setMusicURL(gettedrespmsg.getMusicURL());
				DataContext.HANDIN_ORDER_FAILED.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				DataContext.HANDIN_ORDER_FAILED.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				DataContext.HANDIN_ORDER_FAILED.setArticleCount(gettedrespmsg.getArticleCount());
				DataContext.HANDIN_ORDER_FAILED.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		}
		
		synchronized(DataContext.HANDIN_ORDER_SUCCEEDED){
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(ServerContext.WCMP_HANDIN_ORDER_SUCCEEDED_TYPE, ServerContext.WCMP_HANDIN_ORDER_SUCCEEDED_ID);
				DataContext.HANDIN_ORDER_SUCCEEDED.setMsgType(ServerContext.WCMP_HANDIN_ORDER_SUCCEEDED_TYPE);
				DataContext.HANDIN_ORDER_SUCCEEDED.setContent(gettedrespmsg.getContent());
				DataContext.HANDIN_ORDER_SUCCEEDED.setMediaId(gettedrespmsg.getMediaId());
				DataContext.HANDIN_ORDER_SUCCEEDED.setTitle(gettedrespmsg.getTitle());
				DataContext.HANDIN_ORDER_SUCCEEDED.setDescription(gettedrespmsg.getDescription());
				DataContext.HANDIN_ORDER_SUCCEEDED.setMusicURL(gettedrespmsg.getMusicURL());
				DataContext.HANDIN_ORDER_SUCCEEDED.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				DataContext.HANDIN_ORDER_SUCCEEDED.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				DataContext.HANDIN_ORDER_SUCCEEDED.setArticleCount(gettedrespmsg.getArticleCount());
				DataContext.HANDIN_ORDER_SUCCEEDED.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		}
		
		synchronized(DataContext.ORDER_OUT_OF_RANGE){
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(ServerContext.WCMP_ORDER_OUT_OF_RANGE_TYPE, ServerContext.WCMP_ORDER_OUT_OF_RANGE_ID);
				DataContext.ORDER_OUT_OF_RANGE.setMsgType(ServerContext.WCMP_ORDER_OUT_OF_RANGE_TYPE);
				DataContext.ORDER_OUT_OF_RANGE.setContent(gettedrespmsg.getContent());
				DataContext.ORDER_OUT_OF_RANGE.setMediaId(gettedrespmsg.getMediaId());
				DataContext.ORDER_OUT_OF_RANGE.setTitle(gettedrespmsg.getTitle());
				DataContext.ORDER_OUT_OF_RANGE.setDescription(gettedrespmsg.getDescription());
				DataContext.ORDER_OUT_OF_RANGE.setMusicURL(gettedrespmsg.getMusicURL());
				DataContext.ORDER_OUT_OF_RANGE.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				DataContext.ORDER_OUT_OF_RANGE.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				DataContext.ORDER_OUT_OF_RANGE.setArticleCount(gettedrespmsg.getArticleCount());
				DataContext.ORDER_OUT_OF_RANGE.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		}
		
		synchronized(DataContext.USER_LOCKED){
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(ServerContext.WCMP_USER_LOCKED_TYPE, ServerContext.WCMP_USER_LOCKED_ID);
				DataContext.USER_LOCKED.setMsgType(ServerContext.WCMP_USER_LOCKED_TYPE);
				DataContext.USER_LOCKED.setContent(gettedrespmsg.getContent());
				DataContext.USER_LOCKED.setMediaId(gettedrespmsg.getMediaId());
				DataContext.USER_LOCKED.setTitle(gettedrespmsg.getTitle());
				DataContext.USER_LOCKED.setDescription(gettedrespmsg.getDescription());
				DataContext.USER_LOCKED.setMusicURL(gettedrespmsg.getMusicURL());
				DataContext.USER_LOCKED.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				DataContext.USER_LOCKED.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				DataContext.USER_LOCKED.setArticleCount(gettedrespmsg.getArticleCount());
				DataContext.USER_LOCKED.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		}
	}
	
}
