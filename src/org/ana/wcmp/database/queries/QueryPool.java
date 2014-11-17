package org.ana.wcmp.database.queries;

public class QueryPool {
	
	public static final String SQLSERVER_GET_COST_FLUX_IP = "SELECT [stu_num],[name],[ip_string],[totalinbytes],[totaloutbytes],[totalbytes],[accountValue] FROM [MonitorFlow].[dbo].[useraccount_table_:DTABLE_YYYYMM] WHERE [user_login_name]=:VUSER_LOGIN_NAME";

}
