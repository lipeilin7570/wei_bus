package com.wgjev.weibus.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Service;

import com.wgjev.weibus.dao.CheckOrderMapper;
import com.wgjev.weibus.dao.OperatorSysMapper;
import com.wgjev.weibus.dao.UserDataRentalMapper;
import com.wgjev.weibus.dao.UserRentalMapper;
import com.wgjev.weibus.dao.UsercheckRentalMapper;
import com.wgjev.weibus.dao.json.UserJsonMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.OperatorSys;
import com.wgjev.weibus.entity.UserRental;
import com.wgjev.weibus.entity.UsercheckRental;
import com.wgjev.weibus.entity.json.UserInfoJson;
import com.wgjev.weibus.service.UserService;
import com.wgjev.weibus.util.BusUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRentalMapper userRentalMapper;
	
	@Resource
	private UserDataRentalMapper userDataRentalMapper;
	
	@Resource
	private UserJsonMapper userJsonMapper;
	
	@Resource
	private UsercheckRentalMapper userCheckRentalMapper;
	
	@Resource
	private OperatorSysMapper operatorSysMapper;
	
	/**
	 * 加载所有用户信息
	 */
	public BusResult loadUsers() {
		BusResult result = new BusResult();
		List<UserInfoJson> list = userJsonMapper.loadAllUserInfoJson();
		
		result.setStatus(0);
		result.setData(list);
		return result;
	}
	
	/**
	 * 查看用户认证资料
	 * @param userID
	 * @return
	 */
	public BusResult showUserDataByUserId(Integer userID) {
		BusResult result = new BusResult();
		
		UserInfoJson userInfoJson = userJsonMapper.findUserInfoJsonByUserId(userID);
		if (userInfoJson.getHeaderImg() != null) {
			userInfoJson.setHeaderImg(BusUtil.SERVICE_IP+userInfoJson.getHeaderImg());
		}
		if (userInfoJson.getIdPicA() != null) {
			userInfoJson.setIdPicA(BusUtil.SERVICE_IP+userInfoJson.getIdPicA());
		}
		if (userInfoJson.getIdPicB() != null) {
			userInfoJson.setIdPicB(BusUtil.SERVICE_IP+userInfoJson.getIdPicB());
		}
		if (userInfoJson.getLiPicA() != null) {
			userInfoJson.setLiPicA(BusUtil.SERVICE_IP+userInfoJson.getLiPicA());
		}
		if (userInfoJson.getLiPicB() != null) {
			userInfoJson.setLiPicB(BusUtil.SERVICE_IP+userInfoJson.getLiPicB());
		}
		
		result.setStatus(0);
		result.setData(userInfoJson);
		
		return result;
	}
	
	/**
	 * 设置用户认证状态
	 * @param userID
	 * @param authentication
	 * @return
	 */
	public BusResult changUserAuthentication(Integer operatorID, Integer userID, Integer authentication, String reason) {
		BusResult result = new BusResult();
		OperatorSys operatorSys = operatorSysMapper.selectByPrimaryKey(operatorID);
		
		
		UserRental userRental = new UserRental();
		userRental.setRentaluserid(userID);
		userRental.setAuthentication(authentication);
		if (authentication == 2) {
			userRental.setApprovetime(new Date());
		}
		userRentalMapper.updateByPrimaryKeySelective(userRental);
		
		UsercheckRental usercheckRental = new UsercheckRental();
		if (authentication == 2) {
			usercheckRental.setStatus(1);//审核成功
		}else if (authentication == 3) {
			usercheckRental.setStatus(2);//审核失败
		}
		
		usercheckRental.setRentaluserid(userID);
		usercheckRental.setCreatetime(new Date());
		usercheckRental.setRentalusername(userRental.getRentalusername());
		usercheckRental.setRemark(reason);
		usercheckRental.setSysoperatorid(operatorID);
		usercheckRental.setSysoperatorname(operatorSys.getSysusename());
		userCheckRentalMapper.insertSelective(usercheckRental);
		
		result.setStatus(0);
		return result;
	}
	
	/**
	 * 修改用户状态
	 * @param userID
	 * @param status
	 * @return
	 */
	public BusResult changeUserStatus(Integer userID, Integer status) {
		BusResult result = new BusResult();
		UserRental userRental = new UserRental();
		userRental.setRentaluserid(userID);
		userRental.setStatus(status);
		
		userRentalMapper.updateByPrimaryKeySelective(userRental);
		result.setStatus(0);
		return result;
	}

}
