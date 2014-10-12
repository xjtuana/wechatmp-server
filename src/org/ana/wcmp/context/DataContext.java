package org.ana.wcmp.context;

import org.ana.wcmp.context.vo.BuildingContextVO;
import org.ana.wcmp.context.vo.StaffContextInfoVO;
import org.ana.wcmp.context.vo.TextRespRuleContextVO;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;

public class DataContext {
	
	public static StaffContextInfoVO[] STAFF_CONTEXT = new StaffContextInfoVO[0];
	public static BuildingContextVO[] BUILDING_CONTEXT = new BuildingContextVO[0];
	public static TextRespRuleContextVO[] TEXT_RULES = new TextRespRuleContextVO[0];
	public static RespMsgGeneralVO UNKNOWN_MSG = new RespMsgGeneralVO();
	public static RespMsgGeneralVO BIZ_NOT_FOUND = new RespMsgGeneralVO();
	public static RespMsgGeneralVO WELCOME_MSG = new RespMsgGeneralVO();
	public static RespMsgGeneralVO WRONG_INPUT = new RespMsgGeneralVO();
	public static RespMsgGeneralVO USER_BASIC_NOT_BOUND = new RespMsgGeneralVO();
	public static RespMsgGeneralVO HANDIN_ORDER_FAILED = new RespMsgGeneralVO();
	public static RespMsgGeneralVO HANDIN_ORDER_SUCCEEDED = new RespMsgGeneralVO();
	public static RespMsgGeneralVO ORDER_OUT_OF_RANGE = new RespMsgGeneralVO();
	public static RespMsgGeneralVO USER_LOCKED = new RespMsgGeneralVO();
	
}
