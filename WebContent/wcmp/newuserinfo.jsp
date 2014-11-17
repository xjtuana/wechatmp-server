<%@page import="org.ana.wcmp.webservice.client.caris.UserAttribute"%>
<%@page import="org.ana.wcmp.webservice.client.info.xsd.UserInfoDto"%>
<%@page import="org.ana.wcmp.webservice.client.info.xsd.SimpleInfoDto"%>
<%@page import="org.ana.wcmp.webservice.client.info.UserInfoPortTypeProxy"%>
<%@page import="org.ana.wcmp.webservice.client.info.UserInfoPortType"%>
<%@page import="org.ana.wcmp.db2modelVO.basicUser.IO_BasicUserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生网管会微信平台基本信息绑定</title>
</head>
<body>

	<%

	String netId = request.getUserPrincipal().getName() ;
	UserInfoPortType proxy = new UserInfoPortTypeProxy();
	UserInfoDto stu = proxy.getInfoById("diff",netId);
	
	String userType = stu.getUsertype();
	String affiliation = "";
	if(userType.equalsIgnoreCase("1")){
		affiliation = "student";
	}else if(userType.equalsIgnoreCase("2")){
		affiliation = "faculty";
	}else{
		affiliation = "others";
	}
	
	
	
	IO_BasicUserVO iobu = new IO_BasicUserVO();
	iobu.setBasic_user_name(stu.getUsername());
	iobu.setBasic_user_stuid(stu.getUserno());
	iobu.setBasic_user_netid(netId);
	String address = stu.getRoomnumber();
	iobu.setUser_wechat_openid("");
%>
	<p>
		netId:<%= netId%>

	</p>
	<p>
		Userno:<%=iobu.getBasic_user_stuid() %>
		roomnumber:<%=address %>
	</p>
	<p>
		<a href="/logout.jsp">logout</a>
	</p>

</body>
</html>