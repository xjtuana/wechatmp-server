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
 * �����У�������Mgr��β�����������ģ�Ͳ��ҵ��������࣬���漯���˸���ҵ���Ӧ�ķ������ң�
 * 
 * ����һ���Ƕ�̬�ģ�
 * 
 * ���ڵ�ǰ������������Ϣҵ������Ĳ���һ����org.ana.wcmp.model.vo.msg.req.TextMsg�Ķ���ע��������������һ����д�õ�ҵ��������Ѿ��б�֤��
 * ��TextMsg�п��Ի�ȡ�Ĳ����У�
 * FromUserName�������û���Openid����һֵ��WechatUser�����Ƿǿ�����������һһ��Ӧ���û�����
 * ToUserName��ָ���ںŵ�΢�źţ�ͨ���������ã���
 * CreateTime����ǰ��Ϣ�Ĵ���ʱ�䣬long�ͱ�����ֵ����Ϊ1970��1��1�������������ͨ������ֱ������java.util.Date����ת��������ע��Date�����а�������1970��1��1������ĺ�������
 * MsgId��΢�ŷ�����������Ϣ��Idֵ��ͨ���������ã�
 * MsgType��������Ϣ���ͣ��˴�һ����text���ͣ��ʲ������Ķ���
 * Content����Ϣ���ݣ�ҵ���ı���Ϣ��ʽͨ��Ϊ��#ҵ�����#ҵ�����1#ҵ�����2����ҵ�����n#����ҵ�����������ҵ����ڴ��Ѿ��ּ�ã���ͨ�����������������ǵ��û����飬���Ҿ�����������Ĳ�����
 * 
 * �����ķ���һ����void��ҵ�񷵻ص���Ϣ����ͨ����ĳ�Ա����BizResp����Getter&Setter���д��ݣ���һ�����з�װ��΢���������͵���Ϣ�������Ĳ�����
 * 
 * ҵ�񷵻ص���Ϣ���ݣ���������ɹ������ʧ�ܣ���Ҫ�����ݿ��Լ�����˵�Context��д��ע�ᣬ����ʱͨ��ֱ�Ӵ�DataContext�л�ȡ�������ֶ�������Ϣ����
 * ͨ��ҵ�񷵻ص�Ҳ���ı���Ϣ�����ж�̬�����ݣ������ı���Ϣ������ռλ��
 * ռλ����ʽ����":V"+"��д�Ĳ�����"����ҵ��ɹ���������Ƚ�Context�е����ݸ�ֵ��BizResp���������þ���ֵ�滻��BizResp��Content�е���Ӧռλ��
 * 
 * 
 * 
 * �������ݿ������
 * ���ݿ������д��SVC��β�����У�ͨ��һ��ҵ��Ҳ��Ҫһ������������ݿ����������֧�֣���Ҫ�Ļ������Լ�д����������е�SVCClass��
 * 
 * ���ݿ������ȡ��ֵ���ݵ�ģ�Ͳ��У���Ҫ��db2modelVO���´�����Ӧ��ֵ���󣬸���Ķ���������ݴ��ݣ���ʵ������DTO�����ʾ�����Ҫ��ģ�Ͳ��ж�����в����ʹ��ݣ�ģ�Ͳ��е�ֵ����Ӧ��org.ana.wcmp.model.vo���´���
 * 
 * ����ֵ���������ͨ���ǣ�IO|IN|OUT_VOname
 * ����ͷ�ϵ�IO��IN��OUT��ʾֵ���󼴿ɴ���Ҳ�ɴ������������루SVC���з����Ĳ�����������������SVC���з����ķ���ֵ��
 * 
 * ����ҵ����ڴ��ķּ𣬴���ҵ�񷽷�����Ϣ��Ϣ��һ������ͨ��OpenID��WechatUser���Լ�������BasicUser�����ҵ�Ψһ�����Ӧ��ֵ�ģ�����ڻ�ȡ�û�ʱ���ص������ݲ�ͬ�����⡣
 * 
 * 
 * 
 * ע�����
 * ����ҵ�񷵻���Ϣ��ע�ᣬ������ⶨ����Ϣ����Ϣģ�巢���ң��Ұ���д�뵽���ݿ��Լ��������Ӧ�������
 * 
 * ����ҵ�������ݿ��е�ע�ᣬ��������ҵ�����̱�д�Ժ��һ��������΢���������ݿ���ע����Ч
 * 
 * ���⣬�����Ҷ����д��뻹��ʲô�õ�����뽨�飬Ҳ��ӭ��ʱ�������ҹ�ͬ̽��^ ^~
 * 
 * 
 * 
 * �����뿴����ʾ��public void example(TextMsg textrequest)
 * @author Godrick
 * @date 2014��10��18��
 */
public class MgrClass {
	
	private RespMsgGeneralVO BizResp;
	
	//TODO �����￪ʼ��Ӹ���ҵ�񷽷���Ŀǰ�û�������Ҫ��ҵ�񷽷��У�
	//ƾ���ϵ��Ž��У���ѯ���ϵ���ȡ�����ϵ����߼�ȡ������order_status��Ϊ7�������۹��ϵ������ּ��ɣ�����ƣ�
	//���Ϸ�������ǰ�����ȷ���û�������ݣ����Լ����ϵ���order_client_wechat_user��openid�������openid�Ƿ�һ��
	//�û����������á�ip��ѯ�ȣ���Ҫ�ȴ�ѧУ���Ŷ˿ڣ���ȡ��Ϣ�ĵط�������ʱ��һ����ֵ��������ֵ���棬��ע�ͳ���
	
	//������Ա��Ҫ��ҵ�񷽷��У�
	//ע��������ݣ���Ҫ�õ������½�ӿڣ��������������ϸ���ۣ�����ѯӦ�ӵĵ����б���ѯ��ǰ���ڸ���ĵ����б��ӵ�����order_status��Ϊ2����д���Լ�����Ϣ����Ӧ���������ù���Ϊ����ɣ���order_status��Ϊ3�������ʱ�����
	//���ܲ�����Ҫ�ϸ�������֤��wechatuser���е�staffid����԰��������֤��ע����ݵľ���������Ҫ��ϸ����
	
	//�����ʲô��ıȽϺõ�ҵ��Ҳ���������~
	
	
	//������ҵ�񷽷�ʾ��������һ����ӹ����ķ���
	public void example(TextMsg textrequest){
		
		//������һ�����ݿ����ʱ��Ҫ���ݵ�ֵ����
		IO_BasicUserVO basicinfo = new IO_BasicUserVO();
		
		//����Ҫ�����ֵ����������ֵ
		basicinfo.setUser_wechat_openid(textrequest.getFromUserName());
		
		//������һ�����ݿ�����ķ�����󣬲����÷����������ݿ��ѯ
		BasicUserSVC busvc = new BasicUserSVC();
		try {
			basicinfo = busvc.getBasicInfoByOpenid(basicinfo);
		} catch (DBServiceException e1) {
			e1.printStackTrace();
		}
		
		//�����ڶ������ݿ����ʱ��Ҫ���ݵ�ֵ���󣬲���ֵ������ֵ��Դ�ڵ�һ�����ݿ��ѯ��ȡ��ֵ
		//�˴���ֵ���ڳ����Context�ռ��в�ѯ����ѯ��������Ϊ����ֵ�Ƿ���ֱ�ӵ�����Ӧ��ҵ�����ʧ����Ϣ������
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
		
		//����ֵ�Ϸ�����������ݿ��ѯ��������ȡ����ֵ
		try {
			iobsrel = new DomainSVC().getBuildingStaff(iobsrel);
		} catch (DBServiceException e1) {
			e1.printStackTrace();
		}
		
		//�������������ݿ����ʱ��Ҫ���ݵ�ֵ���󣬲���ֵ��ֵ��Դ��ǰ������ݿ��ѯ��������Ϣ�д��еĲ������ı��Լ����������ɵ�����
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
		//�˴��ĸ�ֵ��Դ���û�������ı������������try\catch����if�Ƚ�����Ϣ���ݺϷ��Ե��ж����Ƿ��������ֱ�ӵ���DataContext.WRONG_INPUT�����أ�
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
		
		//�������������ݿ�����ķ�����󣬲����÷����������ݿ�д��
		OrderSVC osvc = new OrderSVC();
		try {
			OUT_NewOrderReturnVO orderret = osvc.addNewOrderWithWechatReturn(neworder);
			//д�벻�ɹ��������ҵ�����ʧ����Ϣ������
			if (!orderret.isSucceeded()){
				this.BizResp = DataContext.HANDIN_ORDER_FAILED;
				return;
			}
			
			//д��ɹ��������ҵ��ɹ�������Ϣ����ʱ���з���ֵ�����轫ռλ��һһ�滻�������Ƴ������ķ�����Ϣ��ע�ⲻҪֱ�Ӷ�DataContext�е���Ϣ�������������Ϣ�޷��ٴ����ã�
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
				StringBuffer supadmin = new StringBuffer("\r\nΪ���ҵ��˸���¥��ѧ�����ܣ���Ҳ����ֱ����ϵ���ǻ�ȡ������");
				for (int i = 0; i < orderret.getSupadmins().length; i++){
					supadmin.append("\r\n"+orderret.getSupadmins()[i].getStaff_name()+"��"+orderret.getSupadmins()[i].getStaff_phone());
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
