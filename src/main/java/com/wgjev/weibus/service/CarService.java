package com.wgjev.weibus.service;


import org.springframework.web.multipart.MultipartFile;

import com.wgjev.weibus.entity.BusResult;

public interface CarService {
	
	/**
	 * 加载所有车辆信息
	 */
	public BusResult loadCars(Integer companyID);
	
	/**
	 * 查看车辆详细信息
	 * @param carID
	 * @return
	 */
	public BusResult findCarByCarID(Integer carID);
	
	/**
	 * 添加车辆信息
	 * @param operatorID
	 * @param carNo
	 * @param carBrand
	 * @param carModel
	 * @param carColor
	 * @param carVin
	 * @param people
	 * @param terminalNo
	 * @param SIMNo
	 * @param bluetoothNo
	 * @param createManID
	 * @param remark
	 * @param nameplateTime
	 * @param registrationTime
	 * @param machineNo
	 * @param batteryCode
	 * @param chargingGun
	 * @param extinguisher
	 * @param tools
	 * @param sign
	 * @param spareTire
	 * @param carLicense
	 * @param carIcon
	 * @return
	 */
	public BusResult addCarInfo(Integer operatorID, String carNo, Integer carBrand, Integer carModel, 
			Integer carColor, String carVin, Integer people, 
			String terminalNo, String SIMNo, String bluetoothNo, 
			String remark, Integer companyID, String nameplateTime, String registrationTime, 
			String machineNo, String batteryCode, Integer chargingGun, Integer extinguisher, 
			Integer tools, Integer sign, Integer spareTire, MultipartFile carLicense, 
			MultipartFile carIcon);
	
	/**
	 * 修改车辆信息
	 * @param operatorID
	 * @param carID
	 * @param carNo
	 * @param carBrand
	 * @param carModel
	 * @param carColor
	 * @param carVin
	 * @param terminalNo
	 * @param SIMNo
	 * @param bluetoothNo
	 * @param updateManID
	 * @param remark
	 * @param nameplateTime
	 * @param registrationTime
	 * @param machineNo
	 * @param batteryCode
	 * @param chargingGun
	 * @param extinguisher
	 * @param tools
	 * @param sign
	 * @param spareTire
	 * @param carLicense
	 * @param carIcon
	 * @return
	 */
	public BusResult changeCarInfo(Integer operatorID, Integer carID, String carNo, Integer carBrand, String carModel, 
			Integer carColor, String carVin, 
			String terminalNo, String SIMNo, String bluetoothNo,
			String remark, String nameplateTime, String registrationTime, 
			String machineNo, String batteryCode, Integer chargingGun, Integer extinguisher, 
			Integer tools, Integer sign, Integer spareTire, Integer carStatus, MultipartFile carLicense, 
			MultipartFile carIcon);
	
	/**
	 * 修改车辆状态
	 * @param carID
	 * @param carStatus
	 * @return
	 */
	public BusResult changeCarStatus(Integer carID, Integer carStatus);
	
	
	/**
	 * 加载所有车辆状态
	 * @return
	 */
	public BusResult loadAllCarStatus();
	
	
	/**
	 * 车辆控制
	 * @param carID
	 * @param controlType
	 * @return
	 */
	public BusResult carControl(int operatorID, int carID, int controlType,String loginIP);
	
	/**
	 * 根据公司ID显示车辆模型信息
	 * @param companyID
	 * @return
	 */
	public BusResult showAllCarModelByCompanyID(Integer companyID);
	
}
