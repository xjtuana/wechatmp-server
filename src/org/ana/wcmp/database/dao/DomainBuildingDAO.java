package org.ana.wcmp.database.dao;

import java.sql.Blob;

/**
 * 社团网络维护管辖楼宇表的DAO类
 * @author Godrick
 * @date 2014年9月28日
 */
public class DomainBuildingDAO {
	
	private long pk_domain_building;
	private String domain_building_name;
	private DomainAreaDAO domain_building_area; //该楼宇所属区间，原数据库中domain_building_area_id字段，此处为多对一外键
	private GroupDAO domain_building_group; //该楼宇所属小组，原数据库中domain_building_group_id字段，此处为多对一外键
	private Blob domain_building_desc;
	
	public long getPk_domain_building() {
		return pk_domain_building;
	}
	public void setPk_domain_building(long pk_domain_building) {
		this.pk_domain_building = pk_domain_building;
	}
	public String getDomain_building_name() {
		return domain_building_name;
	}
	public void setDomain_building_name(String domain_building_name) {
		this.domain_building_name = domain_building_name;
	}
	public DomainAreaDAO getDomain_building_area() {
		return domain_building_area;
	}
	public void setDomain_building_area(DomainAreaDAO domain_building_area) {
		this.domain_building_area = domain_building_area;
	}
	public GroupDAO getDomain_building_group() {
		return domain_building_group;
	}
	public void setDomain_building_group(GroupDAO domain_building_group) {
		this.domain_building_group = domain_building_group;
	}
	public Blob getDomain_building_desc() {
		return domain_building_desc;
	}
	public void setDomain_building_desc(Blob domain_building_desc) {
		this.domain_building_desc = domain_building_desc;
	}

}
