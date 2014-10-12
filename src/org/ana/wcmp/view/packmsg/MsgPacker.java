package org.ana.wcmp.view.packmsg;

import org.ana.wcmp.model.mappings.RespMsgTypeMapping;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.resp.*;
import org.ana.wcmp.util.parser.XMLparser;

public class MsgPacker {
	
	public String general2anyMsg(RespMsgGeneralVO rawrespmsg){
		try {
			XMLparser xmlparser = new XMLparser();
			switch (rawrespmsg.getMsgType()){
			case RespMsgTypeMapping.TEXT_MSG:
				TextMsg resptext = new TextMsg();
				resptext.setFromUserName(rawrespmsg.getFromUserName());
				resptext.setToUserName(rawrespmsg.getToUserName());
				resptext.setCreateTime(rawrespmsg.getCreateTime());
				resptext.setMsgType("text");
				resptext.setContent(rawrespmsg.getContent().replaceAll("\\\\r\\\\n", "\r\n"));
				return xmlparser.msgToXml(resptext);
			case RespMsgTypeMapping.NEWS_MSG:
				NewsMsg respnews = new NewsMsg();
				respnews.setFromUserName(rawrespmsg.getFromUserName());
				respnews.setToUserName(rawrespmsg.getToUserName());
				respnews.setCreateTime(rawrespmsg.getCreateTime());
				respnews.setMsgType("news");
				respnews.setArticleCount(rawrespmsg.getArticleCount());
				respnews.setArticles(rawrespmsg.getArticles());
				return xmlparser.msgToXml(respnews);
			case RespMsgTypeMapping.PICTURE_MSG:
				ImgMsg respimg = new ImgMsg();
				respimg.setFromUserName(rawrespmsg.getFromUserName());
				respimg.setToUserName(rawrespmsg.getToUserName());
				respimg.setCreateTime(rawrespmsg.getCreateTime());
				respimg.setMsgType("image");
				Image imgcontent = new Image();
				imgcontent.setMediaId(rawrespmsg.getMediaId());
				respimg.setImage(imgcontent);
				return xmlparser.msgToXml(respimg);
			case RespMsgTypeMapping.MUSIC_MSG:
				MusicMsg respmusic = new MusicMsg();
				respmusic.setFromUserName(rawrespmsg.getFromUserName());
				respmusic.setToUserName(rawrespmsg.getToUserName());
				respmusic.setCreateTime(rawrespmsg.getCreateTime());
				respmusic.setMsgType("music");
				Music musiccontent = new Music();
				musiccontent.setTitle(rawrespmsg.getTitle());
				musiccontent.setThumbMediaId(rawrespmsg.getThumbMediaId());
				musiccontent.setMusicUrl(rawrespmsg.getMusicURL());
				musiccontent.setHQMusicUrl(rawrespmsg.getHQMusicUrl());
				musiccontent.setDescription(rawrespmsg.getDescription());
				respmusic.setMusic(musiccontent);
				return xmlparser.msgToXml(respmusic);
			case RespMsgTypeMapping.VIDEO_MSG:
				VideoMsg respvideo = new VideoMsg();
				respvideo.setFromUserName(rawrespmsg.getFromUserName());
				respvideo.setToUserName(rawrespmsg.getToUserName());
				respvideo.setCreateTime(rawrespmsg.getCreateTime());
				respvideo.setMsgType("video");
				Video videocontent = new Video();
				videocontent.setMediaId(rawrespmsg.getMediaId());
				videocontent.setThumbMediaId(rawrespmsg.getThumbMediaId());
				respvideo.setVideo(videocontent);
				return xmlparser.msgToXml(respvideo);
			case RespMsgTypeMapping.VOICE_MSG:
				VoiceMsg respvoice = new VoiceMsg();
				respvoice.setFromUserName(rawrespmsg.getFromUserName());
				respvoice.setToUserName(rawrespmsg.getToUserName());
				respvoice.setCreateTime(rawrespmsg.getCreateTime());
				respvoice.setMsgType("video");
				Voice voicecontent = new Voice();
				voicecontent.setMediaId(rawrespmsg.getMediaId());
				respvoice.setVoice(voicecontent);
				return xmlparser.msgToXml(respvoice);
			default:
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
