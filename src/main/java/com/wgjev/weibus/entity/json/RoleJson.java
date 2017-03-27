package com.wgjev.weibus.entity.json;

import java.util.Date;
import java.util.List;

import com.wgjev.weibus.util.BusUtil;

public class RoleJson {
	private Integer roleID;
	private String roleNo;
	private String roleName;
	private String menuList;
	private Integer status;
	private String createTime;
	private String updateTime;
	private Integer updateCounts;
	private String remark;
	private List<MenuSystemJson> menus;
	
	public List<MenuSystemJson> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuSystemJson> menus) {
		this.menus = menus;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMenuList() {
		return menuList;
	}
	public void setMenuList(String menuList) {
		this.menuList = menuList;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = BusUtil.dateToString(createTime);
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = BusUtil.dateToString(updateTime);
	}
	public Integer getUpdateCounts() {
		return updateCounts;
	}
	public void setUpdateCounts(Integer updateCounts) {
		this.updateCounts = updateCounts;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
