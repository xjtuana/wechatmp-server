package org.ana.wcmp.database.dao;

import java.sql.Blob;

/**
 * ��������ά����Ͻ¥����DAO��
 * @author Godrick
 * @date 2014��9��28��
 */
public class DomainBuildingDAO {
	
	private long pk_domain_building;
	private String domain_building_name;
	private DomainAreaDAO domain_building_area; //��¥���������䣬ԭ���ݿ���domain_building_area_id�ֶΣ��˴�Ϊ���һ���
	private GroupDAO domain_building_group; //��¥������С�飬ԭ���ݿ���domain_building_group_id�ֶΣ��˴�Ϊ���һ���
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
