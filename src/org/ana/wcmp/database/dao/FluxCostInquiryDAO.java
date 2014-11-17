package org.ana.wcmp.database.dao;

public class FluxCostInquiryDAO {
	
	private String netId;
	private String ip;
	private Integer cost;
	private String name;
	private long totalinbytes;
	private long totaloutbytes;
	private long totalbytes;
	
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTotalinbytes() {
		return totalinbytes;
	}
	public void setTotalinbytes(long totalinbytes) {
		this.totalinbytes = totalinbytes;
	}
	public long getTotaloutbytes() {
		return totaloutbytes;
	}
	public void setTotaloutbytes(long totaloutbytes) {
		this.totaloutbytes = totaloutbytes;
	}
	public long getTotalbytes() {
		return totalbytes;
	}
	public void setTotalbytes(long totalbytes) {
		this.totalbytes = totalbytes;
	}
	

}
