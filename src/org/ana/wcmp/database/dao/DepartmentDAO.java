package org.ana.wcmp.database.dao;

import java.sql.Blob;

/**
 * ���Ų��ű��DAO��
 * @author Godrick
 * @date 2014��9��28��
 */
public class DepartmentDAO {
	
	private long pk_department;
	private String department_name;
	private Blob department_desc;
	
	public long getPk_department() {
		return pk_department;
	}
	public void setPk_department(long pk_department) {
		this.pk_department = pk_department;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Blob getDepartment_desc() {
		return department_desc;
	}
	public void setDepartment_desc(Blob department_desc) {
		this.department_desc = department_desc;
	}

}
