package org.ana.wcmp.database.dao;

import java.sql.Blob;

/**
 * 社团小组表DAO类
 * @author Godrick
 * @date 2014年9月28日
 */
public class GroupDAO {
	
	private long pk_group;
	private String group_name;
	private Blob group_desc;
	
	public long getPk_group() {
		return pk_group;
	}
	public void setPk_group(long pk_group) {
		this.pk_group = pk_group;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public Blob getGroup_desc() {
		return group_desc;
	}
	public void setGroup_desc(Blob group_desc) {
		this.group_desc = group_desc;
	}

}
