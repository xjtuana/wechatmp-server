package org.ana.wcmp.test;

import java.util.Calendar;

import org.ana.wcmp.database.exceptions.DBServiceException;
import org.ana.wcmp.database.service.OrderSVC;
import org.ana.wcmp.db2model.order.vo.IN_NewOrderVO;

public class Test {
	
	public static void main(String args[]){
			IN_NewOrderVO neworder = new IN_NewOrderVO();
			neworder.setOrder_client_building("e13");
			neworder.setOrder_certification_code("test");
			neworder.setOrder_client_name("xmh");
			neworder.setOrder_client_netid("xxx");
			neworder.setOrder_client_phone("123456789");
			neworder.setOrder_client_room("231");
			neworder.setOrder_fault_desc("omg");
			neworder.setOrder_resv_time(Calendar.getInstance());
			neworder.setOrder_status(1);
			OrderSVC o = new OrderSVC();
			try {
				o.addNewOrder(neworder);
			} catch (DBServiceException e) {
				e.printStackTrace();
			}
			
	}

}
