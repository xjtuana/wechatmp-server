package org.ana.wcmp.model.inquirier;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.ana.wcmp.database.service.FluxCostInqSVC;
import org.ana.wcmp.db2modelVO.fluxcost.IO_FluxCostVO;
import org.ana.wcmp.model.vo.infoinquiry.FluxCostIPInfo;

public class FluxCostInqMgr {
	
	public FluxCostIPInfo inquiryFluxCostIPInfo(String NetID){
		if (NetID == null) return null;
		FluxCostInqSVC fcsvc = new FluxCostInqSVC();
    	IO_FluxCostVO inquiry = new IO_FluxCostVO();
    	inquiry.setNetId(NetID);
    	inquiry.setInqDate(new Date());
    	IO_FluxCostVO result = fcsvc.getFluxCostInfo(inquiry);
    	if (result == null) return null;
    	FluxCostIPInfo fcipi = new FluxCostIPInfo();
    	fcipi.setCost(result.getCost()+"");
    	fcipi.setInFlux(result.getTotalinbytes()+"");
    	fcipi.setOutFlux(result.getTotaloutbytes()+"");
    	fcipi.setTotalFlux(result.getTotalbytes()+"");
    	fcipi.setIP(result.getIp());
    	fcipi.setName(result.getName());
    	fcipi.setMonth(new SimpleDateFormat("yyyy-MM-dd").format(result.getInqDate()));
    	return fcipi;
	}

}
