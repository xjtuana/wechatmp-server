package org.ana.wcmp.context.vo;

public class BuildingContextVO {
	
	private long building_id;
	private String building_name;
	private String building_desc;
	private Long building_group_id;
	private Long building_area_id;
	
	public long getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(long building_id) {
		this.building_id = building_id;
	}
	public String getBuilding_name() {
		return building_name;
	}
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	public String getBuilding_desc() {
		return building_desc;
	}
	public void setBuilding_desc(String building_desc) {
		this.building_desc = building_desc;
	}
	public Long getBuilding_group_id() {
		return building_group_id;
	}
	public void setBuilding_group_id(Long building_group_id) {
		this.building_group_id = building_group_id;
	}
	public Long getBuilding_area_id() {
		return building_area_id;
	}
	public void setBuilding_area_id(Long building_area_id) {
		this.building_area_id = building_area_id;
	}

}
