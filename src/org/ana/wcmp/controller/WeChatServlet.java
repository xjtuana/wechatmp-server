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
 * 微信开发者模式主程序
 * 
 * 开发者模式认证流程为，微信服务器向开发者服务器发送一个http的GET请求，其中包含数据：
 * 加密签名：signature     时间戳：timestamp    随机数:nonce     随机字符串:echostr
 * 对中间两组数据与预留的token进行排序、拼接，并sha1加密后，与签名对比，若等同，则确认请求来自微信服务器，返回echostr完成认证
 */
@WebServlet(name="Wechatmp" ,urlPatterns={"/wechatmp"})  //新版的web.xml替代
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
	 * 处理来自微信服务器的GET请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		
		if (this.checkSig(signature, timestamp, nonce)){
			out.print(echostr);
		}		//判断处理后信息是否等同于加密签名，是则认证通过，返回预定的echostr至微信服务器完成认证。
		out.close();
		out = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 消息的接收、处理、响应
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//防止乱码，设置请求、响应的中文编码均为UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//加密认证参数获取，同开发者认证一样，要确认请求来自微信服务器才能动作
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		
		String respXml = null;
		//认证成功，则返回消息
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
		Arrays.sort(strArr);	//排序
		String AfterProcess = strArr[0].concat(strArr[1]).concat(strArr[2]);  //拼接
		String Encrypted = StringEncrypt.doEnc(AfterProcess, "SHA-1");
		
		return Encrypted != null ? Encrypted.equals(signature.toUpperCase()) : false;	//判断并返回一个布尔值
	}
	
}
