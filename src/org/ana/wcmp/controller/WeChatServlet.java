package org.ana.wcmp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ana.wcmp.util.encrypt.StringEncrypt;

/**
 * Servlet implementation class MainProgram
 * ΢�ſ�����ģʽ������
 * 
 * ������ģʽ��֤����Ϊ��΢�ŷ������򿪷��߷���������һ��http��GET�������а������ݣ�
 * ����ǩ����signature     ʱ�����timestamp    �����:nonce     ����ַ���:echostr
 * ���м�����������Ԥ����token��������ƴ�ӣ���sha1���ܺ���ǩ���Աȣ�����ͬ����ȷ����������΢�ŷ�����������echostr�����֤
 */
@WebServlet(name="Wechatmp" ,urlPatterns={"/wechatmp"})  //�°��web.xml���
public class WeChatServlet extends HttpServlet {
	
	public static ServletContext serc;
	
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public WeChatServlet() {
    }
    
    public void init() {
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
		
		if (this.checkSig(signature, timestamp, nonce)){
			out.print(echostr);
		}		//�жϴ������Ϣ�Ƿ��ͬ�ڼ���ǩ����������֤ͨ��������Ԥ����echostr��΢�ŷ����������֤��
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
		if (this.checkSig(signature, timestamp, nonce)){
		}
		
		PrintWriter out = response.getWriter();
		out.print(respXml);
		out.close();
		out = null;
	}
	
	private boolean checkSig(String signature, String timestamp, String nonce){
		String token = "myToken";
		String[] strArr = new String[] { token, timestamp, nonce };
		Arrays.sort(strArr);	//����
		String AfterProcess = strArr[0].concat(strArr[1]).concat(strArr[2]);  //ƴ��
		String Encrypted = StringEncrypt.doEnc(AfterProcess, "SHA-1");
		
		return Encrypted != null ? Encrypted.equals(signature.toUpperCase()) : false;	//�жϲ�����һ������ֵ
	}
	
}
