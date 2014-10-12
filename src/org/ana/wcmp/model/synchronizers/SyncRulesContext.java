package org.ana.wcmp.model.synchronizers;

import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.model.initializers.DataContextInitialize;

public class SyncRulesContext extends Thread{

	private DataContextInitialize dci = new DataContextInitialize();
	
	public void run(){
		while(true){
			try {
				Thread.sleep(ServerContext.WCMP_RULES_SYNC_TIME);
				dci.initRuleContext();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
