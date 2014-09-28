package org.ana.wcmp.database.dao;

import java.sql.Blob;

/**
 * 社团网络维护管辖区间表的DAO类
 * @author Godrick
 * @date 2014年9月28日
 */
public class DomainAreaDAO {
	
	private long pk_domain_area;
	private String domain_area_name;
	private Blob domain_area_desc;
	
	public long getPk_domain_area() {
		return pk_domain_area;
	}
	public void setPk_domain_area(long pk_domain_area) {
		this.pk_domain_area = pk_domain_area;
	}
	public String getDomain_area_name() {
		return domain_area_name;
	}
	public void setDomain_area_name(String domain_area_name) {
		this.domain_area_name = domain_area_name;
	}
	public Blob getDomain_area_desc() {
		return domain_area_desc;
	}
	public void setDomain_area_desc(Blob domain_area_desc) {
		this.domain_area_desc = domain_area_desc;
	}

}
