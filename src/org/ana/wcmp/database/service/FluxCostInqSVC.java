package org.ana.wcmp.database.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.ana.wcmp.database.queries.QueryPool;
import org.ana.wcmp.database.sqlserver.C3P0SQLPool;
import org.ana.wcmp.db2modelVO.fluxcost.IO_FluxCostVO;

public class FluxCostInqSVC {
	
	private C3P0SQLPool sqlpool = C3P0SQLPool.getInstance();
	
	public IO_FluxCostVO getFluxCostInfo(IO_FluxCostVO inquiry){
		HashMap<String,Object> params = new HashMap<String,Object>();
		if (inquiry.getNetId() == null) return null;
		params.put("USER_LOGIN_NAME", inquiry.getNetId());
		ResultSet rs = sqlpool.executeQuery(
				QueryPool.SQLSERVER_GET_COST_FLUX_IP.replace(":DTABLE_YYYYMM", new SimpleDateFormat("yyyyMM").format(inquiry.getInqDate())), params);
		IO_FluxCostVO outinfo = new IO_FluxCostVO();
		outinfo.setNetId(inquiry.getNetId());
		outinfo.setInqDate(inquiry.getInqDate());
		try {
			if (rs.next()){
				outinfo.setCost(rs.getInt("accountValue"));
				outinfo.setIp(rs.getString("ip_string"));
				outinfo.setName(rs.getString("name"));
				outinfo.setTotalbytes(rs.getLong("totalbytes"));
				outinfo.setTotalinbytes(rs.getLong("totalinbytes"));
				outinfo.setTotaloutbytes(rs.getLong("totaloutbytes"));
			} else {
				return null;
			}
			rs.close();
			rs = null;
			return outinfo;
		} catch (SQLException e) {
			e.printStackTrace();
			rs = null;
			return null;
		}
	}

}
