package org.ana.wcmp.coop;

import java.text.SimpleDateFormat;
import java.util.Date;

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

/**
 * 程序中，名称以Mgr结尾的类基本都是模型层的业务处理核心类，里面集成了各种业务对应的方法，且：
 * 
 * 方法一定是动态的；
 * 
 * 对于当前开发的文字消息业务，输入的参数一定是org.ana.wcmp.model.vo.msg.req.TextMsg的对象（注意所属包），这一点在写好的业务入口中已经有保证；
 * 从TextMsg中可以获取的参数有：
 * FromUserName（发送用户的Openid，这一值在WechatUser表中是非空索引，可以一一对应到用户），
 * ToUserName（指向公众号的微信号，通常不做利用），
 * CreateTime（当前消息的创建时间，long型变量，值内容为1970年1月1日至今的秒数，通常可以直接利用java.util.Date进行转换，但是注意Date对象中包含的是1970年1月1日至今的毫秒数）
 * MsgId（微信服务器赋予消息的Id值，通常不做利用）
 * MsgType（请求消息类型，此处一定是text类型，故不用做改动）
 * Content（消息内容，业务文本消息格式通常为“#业务代码#业务参数1#业务参数2……业务参数n#”，业务代码由于在业务入口处已经分拣好，故通常不用做操作，考虑到用户体验，请大家尽量削减所需的参数）
 * 
 * 方法的返回一定是void，业务返回的消息内容通过类的成员变量BizResp及其Getter&Setter进行传递，这一对象中封装了微信所有类型的消息所包含的参数；
 * 
 * 业务返回的消息内容（包括办理成功与办理失败）需要在数据库以及服务端的Context中写入注册，返回时通常直接从DataContext中获取，并不手动建立消息对象；
 * 通常业务返回的也是文本消息，如有动态的内容，则在文本消息中设置占位符
 * 占位符格式诸如":V"+"大写的参数名"，在业务成功办理完后，先将Context中的内容赋值给BizResp，再依次用具体值替换掉BizResp的Content中的相应占位符
 * 
 * 
 * 
 * 关于数据库操作：
 * 数据库操作均写在SVC结尾的类中，通常一个业务也需要一个到多个的数据库操作方法的支持，必要的话可以自己写，详见本包中的SVCClass类
 * 
 * 数据库操作获取的值传递到模型层中，需要在db2modelVO包下创建相应的值对象，该类的对象仅作数据传递（事实上算作DTO），故尽量不要在模型层中对其进行操作和传递，模型层中的值对象应到org.ana.wcmp.model.vo包下创建
 * 
 * 传递值对象的命名通常是：IO|IN|OUT_VOname
 * 其中头上的IO、IN、OUT表示值对象即可传入也可传出、仅作传入（SVC类中方法的参数）、仅作传出（SVC类中方法的返回值）
 * 
 * 由于业务入口处的分拣，传入业务方法的消息信息是一定可以通过OpenID在WechatUser表以及关联的BasicUser表中找到唯一与其对应的值的，大家在获取用户时不必担心数据不同步问题。
 * 
 * 
 * 
 * 注意事项：
 * 关于业务返回消息的注册，大家在拟定好消息后将消息模板发给我，我帮大家写入到数据库以及程序的相应代码块中
 * 
 * 关于业务在数据库中的注册，大家在完成业务流程编写以后，我会帮大家整合微调并在数据库中注册生效
 * 
 * 此外，如果大家对现有代码还有什么好的意见与建议，也欢迎随时提出，大家共同探讨^ ^~
 * 
 * 
 * 
 * 以下请看方法示例public void example(TextMsg textrequest)
 * @author Godrick
 * @date 2014年10月18日
 */
public class MgrClass {
	
	private RespMsgGeneralVO BizResp;
	
	//TODO 在这里开始添加各种业务方法，目前用户方面需要的业务方法有：
	//凭故障单号进行：查询故障单、取消故障单（逻辑取消，将order_status置为7）、评价故障单（评分即可，五分制）
	//以上方法操作前最好先确认用户本人身份，可以检测故障单中order_client_wechat_user的openid与请求的openid是否一致
	//用户流量、费用、ip查询等，需要等待学校开放端口，获取信息的地方可以暂时用一个空值或者任意值代替，并注释出来
	
	//网管人员需要的业务方法有：
	//注册网管身份（需要用到单点登陆接口，具体可以找我详细讨论）、查询应接的单号列表、查询当前正在负责的单号列表、接单（将order_status置为2，并写入自己的信息到相应栏）、设置工单为已完成（将order_status置为3，并添加时间戳）
	//网管操作需要严格的身份验证，wechatuser表中的staffid项可以帮助身份验证，注册身份的具体事宜需要详细讨论
	
	//大家有什么别的比较好的业务也可以提出来~
	
	
	//以下是业务方法示例，这是一个添加工单的方法
	public void example(TextMsg textrequest){
		
		//建立第一个数据库操作时需要传递的值对象
		IO_BasicUserVO basicinfo = new IO_BasicUserVO();
		
		//对需要传入的值对象赋予条件值
		basicinfo.setUser_wechat_openid(textrequest.getFromUserName());
		
		//建立第一个数据库操作的服务对象，并调用方法进行数据库查询
		BasicUserSVC busvc = new BasicUserSVC();
		try {
			basicinfo = busvc.getBasicInfoByOpenid(basicinfo);
		} catch (DBServiceException e1) {
			e1.printStackTrace();
		}
		
		//建立第二个数据库操作时需要传递的值对象，并赋值，输入值来源于第一次数据库查询获取的值
		//此处赋值会在程序的Context空间中查询，查询不到则视为输入值非法，直接调用相应的业务办理失败消息并返回
		IO_BuildingStaffRelVO iobsrel = new IO_BuildingStaffRelVO();
		for (int i = 0; i < DataContext.BUILDING_CONTEXT.length; i++){
			if (DataContext.BUILDING_CONTEXT[i].getBuilding_name().equalsIgnoreCase(basicinfo.getBasic_user_building())){
				iobsrel.setBuilding_id(DataContext.BUILDING_CONTEXT[i].getBuilding_id());
				break;
			}
		}
		if (iobsrel.getBuilding_id() == null){
			this.BizResp = DataContext.ORDER_OUT_OF_RANGE;
			return;
		}
		
		//输入值合法，则进行数据库查询操作并获取返回值
		try {
			iobsrel = new DomainSVC().getBuildingStaff(iobsrel);
		} catch (DBServiceException e1) {
			e1.printStackTrace();
		}
		
		//建立第三个数据库操作时需要传递的值对象，并赋值，值来源于前面的数据库查询操作、消息中带有的参数和文本以及程序本身生成的内容
		IN_NewOrderVO neworder = new IN_NewOrderVO();
		neworder.setOrder_client_name(basicinfo.getBasic_user_name());
		neworder.setOrder_client_ip(basicinfo.getBasic_user_ip());
		neworder.setOrder_client_building(basicinfo.getBasic_user_building());
		neworder.setOrder_client_room(basicinfo.getBasic_user_room());
		neworder.setOrder_client_netid(basicinfo.getBasic_user_netid());
		neworder.setOrder_client_wechat_user_openid(textrequest.getFromUserName());
		neworder.setOrder_add_time(textrequest.getCreateTime()*1000);
//		neworder.setOrder_certification_code(this.generateCode(64));
		neworder.setOrder_status(1);
		String BizContent = StringUtil.tokenInitializer(
				StringUtil.fullToHalf(
						textrequest.getContent()),ServerContext.WCMP_BIZ_MARKER);	
		neworder.setOrder_supposed_staff(iobsrel.getStaff_ids());
		//此处的赋值来源于用户输入的文本，故最好利用try\catch或者if等进行消息内容合法性的判定，非法输入可以直接调用DataContext.WRONG_INPUT并返回；
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
		
		//建立第三个数据库操作的服务对象，并调用方法进行数据库写入
		OrderSVC osvc = new OrderSVC();
		try {
			OUT_NewOrderReturnVO orderret = osvc.addNewOrderWithWechatReturn(neworder);
			//写入不成功，则调用业务办理失败消息并返回
			if (!orderret.isSucceeded()){
				this.BizResp = DataContext.HANDIN_ORDER_FAILED;
				return;
			}
			
			//写入成功，则调用业务成功办理消息，此时如有返回值，还需将占位符一一替换，最终制成完整的返回消息（注意不要直接对DataContext中的消息操作，否则该消息无法再次利用）
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
	
	
	public RespMsgGeneralVO getBizResp() {
		return BizResp;
	}

	public void setBizResp(RespMsgGeneralVO bizResp) {
		BizResp = bizResp;
	}

}
