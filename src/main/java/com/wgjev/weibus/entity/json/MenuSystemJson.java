package com.wgjev.weibus.entity.json;

public class MenuSystemJson {
	private Integer menuID;
	private String menuName;
	private Integer menuLev;
	private Integer menuParent;
	private String menuImg;
	private String address;
	public Integer getMenuID() {
		return menuID;
	}
	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getMenuLev() {
		return menuLev;
	}
	public void setMenuLev(Integer menuLev) {
		this.menuLev = menuLev;
	}
	public Integer getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(Integer menuParent) {
		this.menuParent = menuParent;
	}
	public String getMenuImg() {
		return menuImg;
	}
	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
