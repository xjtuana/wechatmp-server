package org.ana.wcmp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.model.initializers.DataContextInitialize;
import org.ana.wcmp.model.initializers.ServerContextInitialize;
import org.ana.wcmp.model.msghandle.Handler;
import org.ana.wcmp.model.synchronizers.SyncMsgContext;
import org.ana.wcmp.model.synchronizers.SyncRulesContext;
import org.ana.wcmp.util.encrypt.StringEncrypt;

/**
 * Servlet implementation class MainProgram
 * ΢�ſ�����ģʽ������
 * 
 * ������ģʽ��֤����Ϊ��΢�ŷ������򿪷��߷���������һ��http��GET�������а������ݣ�
 * ����ǩ����signature     ʱ�����timestamp    �����:nonce     ����ַ���:echostr
 * ���м�����������Ԥ����token��������ƴ�ӣ���sha1���ܺ���ǩ���Աȣ�����ͬ����ȷ����������΢�ŷ�����������echostr�����֤
 */
@WebServlet(name="Wechatmp" ,urlPatterns={"/wechatmp"}, loadOnStartup=1)  //�°��web.xml���
public class WeChatServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public WeChatServlet() {
    }
    
    public void init() {
    	ServerContextInitialize svrinit = new ServerContextInitialize();
    	DataContextInitialize datainit = new DataContextInitialize();
    	svrinit.initServerContext();
    	datainit.initBuildingContext();
    	datainit.initStaffContext();
    	datainit.initRuleContext();
    	datainit.initMsgContext();
    	new SyncRulesContext().start();
    	new SyncMsgContext().start();
    }   
        	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * ��������΢�ŷ�������GET����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		try{
			if (this.checkSig(signature, timestamp, nonce)){
				out.print(echostr);
			}		//�жϴ������Ϣ�Ƿ��ͬ�ڼ���ǩ����������֤ͨ��������Ԥ����echostr��΢�ŷ����������֤��
		} catch (NullPointerException ne){
			
		}
		out.close();
		out = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * ��Ϣ�Ľ��ա�������Ӧ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ֹ���룬����������Ӧ�����ı����ΪUTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//������֤������ȡ��ͬ��������֤һ����Ҫȷ����������΢�ŷ��������ܶ���
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		
		String respXml = null;
		//��֤�ɹ����򷵻���Ϣ
		try{
			if (this.checkSig(signature, timestamp, nonce)){
				respXml = new Handler().processReq(request);
			}
		} catch (NullPointerException ne) {
			
		}
		
		PrintWriter out = response.getWriter();
		out.print(respXml);
		out.close();
		out = null;
	}
	
	private boolean checkSig(String signature, String timestamp, String nonce) throws NullPointerException{
		String[] strArr = new String[] { ServerContext.WCMP_TOKEN, timestamp, nonce };
		Arrays.sort(strArr);	//����
		String AfterProcess = strArr[0].concat(strArr[1]).concat(strArr[2]);  //ƴ��
		String Encrypted = StringEncrypt.doEnc(AfterProcess, "SHA-1");
		
		return Encrypted != null ? Encrypted.equals(signature.toUpperCase()) : false;	
	}
	
}
