package org.ana.wcmp.model.biz.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.ana.wcmp.context.DataContext;
import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.BasicUserSVC;
import org.ana.wcmp.database.service.DomainSVC;
import org.ana.wcmp.database.service.OrderSVC;
import org.ana.wcmp.db2modelVO.basicUser.IO_BasicUserVO;
import org.ana.wcmp.db2modelVO.domain.IO_BuildingStaffRelVO;
import org.ana.wcmp.db2modelVO.order.IN_NewOrderVO;
import org.ana.wcmp.db2modelVO.order.OUT_NewOrderReturnVO;
import org.ana.wcmp.model.vo.msg.RespMsgGeneralVO;
import org.ana.wcmp.model.vo.msg.req.TextMsg;
import org.ana.wcmp.util.string.StringUtil;

public class OrderMgr {
	
	private static final char[] codecharlib = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l',
		'm','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U',
		'V','W','X','Y','Z'};
	
	private RespMsgGeneralVO BizResp;
	
	public void newOrder(TextMsg textrequest){
		IO_BasicUserVO basicinfo = new IO_BasicUserVO();
		IN_NewOrderVO neworder = new IN_NewOrderVO();
		basicinfo.setUser_wechat_openid(textrequest.getFromUserName());
		BasicUserSVC busvc = new BasicUserSVC();
		try {
			basicinfo = busvc.getBasicInfoByOpenid(basicinfo);
		} catch (DBServiceException e1) {
			e1.printStackTrace();
		}
		if (basicinfo == null){
			this.BizResp = DataContext.USER_BASIC_NOT_BOUND;
			return;
		}
		
		neworder.setOrder_client_name(basicinfo.getBasic_user_name());
		neworder.setOrder_client_ip(basicinfo.getBasic_user_ip());
		neworder.setOrder_client_building(basicinfo.getBasic_user_building());
		neworder.setOrder_client_room(basicinfo.getBasic_user_room());
		neworder.setOrder_client_netid(basicinfo.getBasic_user_netid());
		neworder.setOrder_client_wechat_user_openid(textrequest.getFromUserName());
		neworder.setOrder_add_time(textrequest.getCreateTime()*1000);
		neworder.setOrder_certification_code(this.generateCode(64));
		neworder.setOrder_status(1);
		String BizContent = StringUtil.tokenInitializer(
				StringUtil.fullToHalf(
						textrequest.getContent()),ServerContext.WCMP_BIZ_MARKER);	
		try{
			String phone = StringUtil.tokenizedStringToList(BizContent, ServerContext.WCMP_BIZ_MARKER).get(1);
			if (!phone.matches("[1][34578][0-9]{9}") && !phone.matches("[0-9]{8}")){
				this.BizResp = DataContext.WRONG_INPUT;
				return;
			}
			neworder.setOrder_client_phone(phone);
		} catch (IndexOutOfBoundsException e){
			this.BizResp = DataContext.WRONG_INPUT;
			return;
		}
		IO_BuildingStaffRelVO iobsrel = new IO_BuildingStaffRelVO();
		for (int i = 0; i < DataContext.BUILDING_CONTEXT.length; i++){
			if (DataContext.BUILDING_CONTEXT[i].getBuilding_name().equalsIgnoreCase(neworder.getOrder_client_building())){
				iobsrel.setBuilding_id(DataContext.BUILDING_CONTEXT[i].getBuilding_id());
				break;
			}
		}
		if (iobsrel.getBuilding_id() == null){
			this.BizResp = DataContext.ORDER_OUT_OF_RANGE;
			return;
		}
		try {
			iobsrel = new DomainSVC().getBuildingStaff(iobsrel);
			neworder.setOrder_supposed_staff(iobsrel.getStaff_ids());
		} catch (DBServiceException e1) {
			e1.printStackTrace();
		}
		
		OrderSVC osvc = new OrderSVC();
		try {
			OUT_NewOrderReturnVO orderret = osvc.addNewOrderWithWechatReturn(neworder);
			if (!orderret.isSucceeded()){
				this.BizResp = DataContext.HANDIN_ORDER_FAILED;
				return;
			}
			
			this.BizResp = DataContext.HANDIN_ORDER_SUCCEEDED;
			this.BizResp.setContent(this.BizResp.getContent()
					.replaceAll(":VORDER_ID", String.valueOf(orderret.getOrderid()))
					.replaceAll(":VUSER_NAME", orderret.getName())
					.replaceAll(":VUSER_PHONE", orderret.getPhone())
					.replaceAll(":VUSER_NETID", orderret.getNetid())
					.replaceAll(":VUSER_BUILDING", orderret.getBuilding())
					.replaceAll(":VUSER_ROOM", orderret.getRoom())
					.replaceAll(":VORDER_ADDTIME", new SimpleDateFormat("yyyy-MM-dd").format(new Date(orderret.getAddtime())))
			);
			if (orderret.getSupadmins() == null || orderret.getSupadmins().length <= 0){
				this.BizResp.setContent(this.BizResp.getContent().replaceAll(":VORDER_SUPADMIN", ""));
			} else {
				StringBuffer supadmin = new StringBuffer("\r\n为您找到了负责本楼的学生网管，您也可以直接联系他们获取帮助：");
				for (int i = 0; i < orderret.getSupadmins().length; i++){
					supadmin.append("\r\n"+orderret.getSupadmins()[i].getStaff_name()+"："+orderret.getSupadmins()[i].getStaff_phone());
				}
				this.BizResp.setContent(this.BizResp.getContent().replaceAll(":VORDER_SUPADMIN", supadmin.toString()));
			}
		} catch (DBServiceException e) {
			e.printStackTrace();
		}
		
	}

	public void searchOrderById(TextMsg textrequest){
		//TODO
	}
	
	public void searchMyOrders(TextMsg textrequest){
		//TODO
	}
	
	//生成凭证的方法传入参数为凭证长度，可以任意指定。由于没有防重复机制，为了减少重复的可能性，本案例中指定了64位，在案例对应的数据量下可以视为不会重复
	private String generateCode(int size){
		//由于需要多次添加操作，此处利用StringBuffer优化程序性能。
		StringBuffer code = new StringBuffer("");
		Random r = new Random();
			
		int range = codecharlib.length;
		int tempcursor;	
		for (int i = 0; i < size; i++) {	//在库中随机取size次，以生成指定位数的凭证（密钥）
			tempcursor = r.nextInt(range);
			code.append(codecharlib[tempcursor]);
		}
				
		return code.toString();
	}
	
	public RespMsgGeneralVO getBizResp() {
		return BizResp;
	}

	public void setBizResp(RespMsgGeneralVO bizResp) {
		BizResp = bizResp;
	}

}
