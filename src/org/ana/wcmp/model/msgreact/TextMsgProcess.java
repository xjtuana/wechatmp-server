package org.ana.wcmp.model.msgreact;

import java.util.Date;

import org.ana.wcmp.context.DataContext;
import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.WechatRespMsgSVC;
import org.ana.wcmp.db2modelVO.wechatMsg.OUT_RespMsgGeneralVO;
import org.ana.wcmp.model.biz.entry.TextBizEntry;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.req.TextMsg;

public class TextMsgProcess {
	
	public static final int TEXT_RESP_MODE_CONTAINS = 0;
	public static final int TEXT_RESP_MODE_STARTWITH = 1;
	public static final int TEXT_RESP_MODE_ENDWITH = 2;
	public static final int TEXT_RESP_MODE_REGEXP = 3;
	public static final int TEXT_RESP_MODE_FULLY_EQUAL = 4;
	
	private RespMsgGeneralVO respmsg = new RespMsgGeneralVO();
	
	public RespMsgGeneralVO processTextMsg(TextMsg reqtextmsg){
		
		if (reqtextmsg.getContent().startsWith(ServerContext.WCMP_BIZ_MARKER)){
			TextBizEntry tbe = new TextBizEntry();
			tbe.setBizRequest(reqtextmsg);
			tbe.dispatchAndProcess();
			this.respmsg = tbe.getBizResp();
			//TODO
		} else if (reqtextmsg.getContent().startsWith(ServerContext.WCMP_ADMIN_BIZ_MARKER)) {
			//TODO
		} else {
			this.autoReply(reqtextmsg.getContent());
		}
		
		this.respmsg.setFromUserName(reqtextmsg.getToUserName());
		this.respmsg.setToUserName(reqtextmsg.getFromUserName());
		this.respmsg.setCreateTime(new Date().getTime()/1000);
		
		return this.respmsg;
	}

	private void autoReply(String content){
		boolean tested = false;
		int i;
		for (i = 0; i < DataContext.TEXT_RULES.length; i++){
			switch (DataContext.TEXT_RULES[i].getRuleMode()){
			case TEXT_RESP_MODE_CONTAINS:
				tested = content.contains(DataContext.TEXT_RULES[i].getRuleKeyword());
				break;
			case TEXT_RESP_MODE_STARTWITH:
				tested = content.startsWith(DataContext.TEXT_RULES[i].getRuleKeyword());
				break;
			case TEXT_RESP_MODE_ENDWITH:
				tested = content.endsWith(DataContext.TEXT_RULES[i].getRuleKeyword());
				break;
			case TEXT_RESP_MODE_REGEXP:
				tested = content.matches(DataContext.TEXT_RULES[i].getRuleKeyword());
				break;
			case TEXT_RESP_MODE_FULLY_EQUAL:
				tested = content.equals(DataContext.TEXT_RULES[i].getRuleKeyword());
				break;
			default:
				tested = content.contains(DataContext.TEXT_RULES[i].getRuleKeyword());	
			}
			if (tested) break;
		}
		WechatRespMsgSVC wrespsvc = new WechatRespMsgSVC();
		if (tested){	
			try {
				OUT_RespMsgGeneralVO gettedrespmsg = wrespsvc.getRespMsg(DataContext.TEXT_RULES[i].getRespType(),DataContext.TEXT_RULES[i].getRespMsgID());
				this.respmsg.setMsgType(DataContext.TEXT_RULES[i].getRespType());
				this.respmsg.setContent(gettedrespmsg.getContent());
				this.respmsg.setMediaId(gettedrespmsg.getMediaId());
				this.respmsg.setTitle(gettedrespmsg.getTitle());
				this.respmsg.setDescription(gettedrespmsg.getDescription());
				this.respmsg.setMusicURL(gettedrespmsg.getMusicURL());
				this.respmsg.setHQMusicUrl(gettedrespmsg.getHQMusicUrl());
				this.respmsg.setThumbMediaId(gettedrespmsg.getThumbMediaId());
				this.respmsg.setArticleCount(gettedrespmsg.getArticleCount());
				this.respmsg.setArticles(gettedrespmsg.getArticles());
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
		} else {
			this.respmsg = DataContext.UNKNOWN_MSG;
		}
	}
}
