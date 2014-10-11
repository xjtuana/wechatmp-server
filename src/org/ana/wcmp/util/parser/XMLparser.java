package org.ana.wcmp.util.parser;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import org.ana.wcmp.model.msgVO.resp.*;

public class XMLparser {
	
	//将XML转化成HashMap对象
	@SuppressWarnings({ "unchecked" })
	public static HashMap<String,String> parseXml(HttpServletRequest request) throws Exception{
		HashMap<String,String> map = new HashMap<String,String>();	
			
		InputStream inrawmsg = request.getInputStream();	
		SAXReader reader = new SAXReader();
		Document document = reader.read(inrawmsg);	
		Element root = document.getRootElement();	//获得根元素
		List<Element> allelement = root.elements();	//得到根元素的所有子节点
		
		//遍历根元素所有子节点，将其内容置入HashMap中
		for (Element e : allelement) {
			map.put(e.getName(),e.getText());
		}

		inrawmsg.close();
		inrawmsg = null;
		
		return map;
	}

	//扩展xstream使其支持CDATA
	private static XStream xstream = new XStream(new XppDriver(){
		public HierarchicalStreamWriter createWriter(Writer out){
			return new PrettyPrintWriter(out) {
				//默认所有节点都添加CDATA
				boolean cdata = true;
				
				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class cls){
					super.startNode(name, cls);
				}
					
				protected void writeText(QuickWriter writer, String text){
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
	
	
	//文本消息转换
	public String msgToXml(TextMsg txtmsg){
		xstream.alias("xml", txtmsg.getClass());
		return xstream.toXML(txtmsg);
	}
		
	//图片消息转换
	public String msgToXml(ImgMsg imgmsg){
		xstream.alias("xml", imgmsg.getClass());
		return xstream.toXML(imgmsg);
	}
		
	//语音消息转换
	public String msgToXml(VoiceMsg voicemsg){
		xstream.alias("xml", voicemsg.getClass());
		return xstream.toXML(voicemsg);
	}

	//视频消息转换
	public String msgToXml(VideoMsg videomsg){
		xstream.alias("xml", videomsg.getClass());
		return xstream.toXML(videomsg);
	}
		
	//音乐消息转换
	public String msgToXml(MusicMsg musicmsg){
		xstream.alias("xml", musicmsg.getClass());
		return xstream.toXML(musicmsg);
	}
		
	//图文消息转换
	public String msgToXml(NewsMsg newsmsg){
		xstream.alias("xml", newsmsg.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsmsg);
	}
}
