package org.ana.wcmp.model.initializers;

import java.util.Properties;

import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.util.loader.PropertiesLoader;

public class ServerContextInitialize {
	
	public void initServerContext(){
		ServerContext.SERVERBASE_PATH = Thread.currentThread().getContextClassLoader().getResource("").toString().replaceFirst("file:/", "").replaceAll("%20", " ");
		ServerContext.SERVERBASE_PATH = ServerContext.SERVERBASE_PATH.substring(0,ServerContext.SERVERBASE_PATH.length()-1);

		PropertiesLoader pu = new PropertiesLoader();
		Properties props = pu.getProperties(ServerContext.SERVERBASE_PATH+"/"+"org/ana/wcmp/context/ServerContext.properties");
		
		ServerContext.WEBROOT_PATH = props.getProperty("webroot_path");
		ServerContext.WCMP_BASIC_BIND_URI = props.getProperty("wcmp_basic_bind_uri");
		ServerContext.WCMP_TOKEN = props.getProperty("wcmp_token");
		ServerContext.WCMP_BIZ_MARKER = props.getProperty("wcmp_biz_marker");
		ServerContext.WCMP_ADMIN_BIZ_MARKER = props.getProperty("wcmp_admin_biz_marker");
		ServerContext.WCMP_UNKNOWN_MSG_RESP_ID = Long.parseLong(props.getProperty("wcmp_unknown_msg_resp_id"));
		ServerContext.WCMP_UNKNOWN_MSG_RESP_TYPE = Integer.parseInt(props.getProperty("wcmp_unknown_msg_resp_type"));
		ServerContext.WCMP_WELCOME_MSG_ID = Long.parseLong(props.getProperty("wcmp_welcome_msg_id"));
		ServerContext.WCMP_WELCOME_MSG_TYPE = Integer.parseInt(props.getProperty("wcmp_welcome_msg_type"));
		ServerContext.WCMP_RULES_SYNC_TIME = Long.parseLong(props.getProperty("wcmp_rules_sync_time"));
		ServerContext.WCMP_BIZ_NOT_FOUND_TYPE = Integer.parseInt(props.getProperty("wcmp_biz_not_found_type"));
		ServerContext.WCMP_BIZ_NOT_FOUND_ID = Long.parseLong(props.getProperty("wcmp_biz_not_found_id"));
		ServerContext.WCMP_BIZ_WRONG_INPUT_TYPE = Integer.parseInt(props.getProperty("wcmp_biz_wrong_input_type"));
		ServerContext.WCMP_BIZ_WRONG_INPUT_ID = Long.parseLong(props.getProperty("wcmp_biz_wrong_input_id"));
		ServerContext.WCMP_BASIC_USER_NOT_BOUND_TYPE = Integer.parseInt(props.getProperty("wcmp_basic_user_not_bound_type"));
		ServerContext.WCMP_BASIC_USER_NOT_BOUND_ID = Long.parseLong(props.getProperty("wcmp_basic_user_not_bound_id"));
		ServerContext.WCMP_MSG_SYNC_TIME = Long.parseLong(props.getProperty("wcmp_msg_sync_time"));
		ServerContext.WCMP_HANDIN_ORDER_FAILED_TYPE = Integer.parseInt(props.getProperty("wcmp_handin_order_failed_type"));
		ServerContext.WCMP_HANDIN_ORDER_FAILED_ID = Long.parseLong(props.getProperty("wcmp_handin_order_failed_id"));
		ServerContext.WCMP_HANDIN_ORDER_SUCCEEDED_TYPE = Integer.parseInt(props.getProperty("wcmp_handin_order_succeeded_type"));
		ServerContext.WCMP_HANDIN_ORDER_SUCCEEDED_ID = Long.parseLong(props.getProperty("wcmp_handin_order_succeeded_id"));
		ServerContext.WCMP_ORDER_OUT_OF_RANGE_TYPE = Integer.parseInt(props.getProperty("wcmp_order_out_of_range_type"));
		ServerContext.WCMP_ORDER_OUT_OF_RANGE_ID = Long.parseLong(props.getProperty("wcmp_order_out_of_range_id"));
		ServerContext.WCMP_USER_LOCKED_TYPE = Integer.parseInt(props.getProperty("wcmp_user_locked_type"));
		ServerContext.WCMP_USER_LOCKED_ID = Long.parseLong(props.getProperty("wcmp_user_locked_id"));
	}

}
