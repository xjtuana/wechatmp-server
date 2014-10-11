package org.ana.wcmp.test;

import java.lang.reflect.Field;

import org.ana.wcmp.model.msgVO.EventMsgGeneralVO;
import org.ana.wcmp.model.msgVO.ReqMsgGeneralVO;

public class Test {
	
	public static void main(String args[]){
			Field[] f = ReqMsgGeneralVO.class.getDeclaredFields();
			for (int i = 0; i < f.length; i++){
				System.out.println("this.set"+f[i].getName()+"(rmgvo.get"+f[i].getName()+"());");
			}
			
	}

}
