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
	
	//��XMLת����HashMap����
	@SuppressWarnings({ "unchecked" })
	public static HashMap<String,String> parseXml(HttpServletRequest request) throws Exception{
		HashMap<String,String> map = new HashMap<String,String>();	
			
		InputStream inrawmsg = request.getInputStream();	
		SAXReader reader = new SAXReader();
		Document document = reader.read(inrawmsg);	
		Element root = document.getRootElement();	//��ø�Ԫ��
		List<Element> allelement = root.elements();	//�õ���Ԫ�ص������ӽڵ�
		
		//������Ԫ�������ӽڵ㣬������������HashMap��
		for (Element e : allelement) {
			map.put(e.getName(),e.getText());
		}

		inrawmsg.close();
		inrawmsg = null;
		
		return map;
	}

	//��չxstreamʹ��֧��CDATA
	private static XStream xstream = new XStream(new XppDriver(){
		public HierarchicalStreamWriter createWriter(Writer out){
			return new PrettyPrintWriter(out) {
				//Ĭ�����нڵ㶼���CDATA
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
	
	
	//�ı���Ϣת��
	public String msgToXml(TextMsg txtmsg){
		xstream.alias("xml", txtmsg.getClass());
		return xstream.toXML(txtmsg);
	}
		
	//ͼƬ��Ϣת��
	public String msgToXml(ImgMsg imgmsg){
		xstream.alias("xml", imgmsg.getClass());
		return xstream.toXML(imgmsg);
	}
		
	//������Ϣת��
	public String msgToXml(VoiceMsg voicemsg){
		xstream.alias("xml", voicemsg.getClass());
		return xstream.toXML(voicemsg);
	}

	//��Ƶ��Ϣת��
	public String msgToXml(VideoMsg videomsg){
		xstream.alias("xml", videomsg.getClass());
		return xstream.toXML(videomsg);
	}
		
	//������Ϣת��
	public String msgToXml(MusicMsg musicmsg){
		xstream.alias("xml", musicmsg.getClass());
		return xstream.toXML(musicmsg);
	}
		
	//ͼ����Ϣת��
	public String msgToXml(NewsMsg newsmsg){
		xstream.alias("xml", newsmsg.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsmsg);
	}
}
