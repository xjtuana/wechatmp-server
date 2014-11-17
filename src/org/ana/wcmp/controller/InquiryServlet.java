package org.ana.wcmp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ana.wcmp.model.auth.InquiryAuthentication;
import org.ana.wcmp.model.inquirier.FluxCostInqMgr;
import org.ana.wcmp.model.vo.infoinquiry.FluxCostIPInfo;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class InquiryServlet
 * Encrypted inquiry api.
 * Time format: 00:00~23:59
 */
@WebServlet(name="netinfo" ,urlPatterns={"/netinfo"},loadOnStartup=1) 
public class InquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(){
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		String signature = request.getParameter("signature");
		if (signature == null || !(new InquiryAuthentication().isAuthorized(signature))){
			out.print("You are not authorized!");
			return;
		}
		String netid = request.getParameter("netid");
		FluxCostIPInfo f = new FluxCostInqMgr().inquiryFluxCostIPInfo(netid);
		String json = JSON.toJSONString(f, true);
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return;
	}

}
