package org.ana.wcmp.db2modelVO.fluxcost;

import java.util.Date;

import org.ana.wcmp.database.dao.FluxCostInquiryDAO;

public class IO_FluxCostVO extends FluxCostInquiryDAO{

	private Date inqDate;

	public Date getInqDate() {
		return inqDate;
	}

	public void setInqDate(Date inqDate) {
		this.inqDate = inqDate;
	}
	
}
