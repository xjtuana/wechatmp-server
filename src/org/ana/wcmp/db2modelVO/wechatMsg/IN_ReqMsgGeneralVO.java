package org.ana.wcmp.db2modelVO.wechatMsg;

import org.ana.wcmp.model.vo.msg.ReqMsgGeneralVO;

public class IN_ReqMsgGeneralVO extends ReqMsgGeneralVO{
	
	public IN_ReqMsgGeneralVO(){
	}

	public IN_ReqMsgGeneralVO(ReqMsgGeneralVO rmgvo){
		this.setToUserName(rmgvo.getToUserName());
		this.setFromUserName(rmgvo.getFromUserName());
		this.setCreateTime(rmgvo.getCreateTime());
		this.setMsgType(rmgvo.getMsgType());
		this.setMsgId(rmgvo.getMsgId());
		this.setContent(rmgvo.getContent());
		this.setPicUrl(rmgvo.getPicUrl());
		this.setMediaId(rmgvo.getMediaId());
		this.setFormat(rmgvo.getFormat());
		this.setRecognition(rmgvo.getRecognition());
		this.setThumbMediaId(rmgvo.getThumbMediaId());
		this.setLocation_X(rmgvo.getLocation_X());
		this.setLocation_Y(rmgvo.getLocation_Y());
		this.setScale(rmgvo.getScale());
		this.setLabel(rmgvo.getLabel());
		this.setTitle(rmgvo.getTitle());
		this.setDescription(rmgvo.getDescription());
		this.setUrl(rmgvo.getUrl());
	}
}
