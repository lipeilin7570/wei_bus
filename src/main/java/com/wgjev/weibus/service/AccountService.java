package com.wgjev.weibus.service;

import com.wgjev.weibus.entity.BusResult;

public interface AccountService {
	
	/**
	 * 加载提现申请信息
	 * @return
	 */
	public BusResult loadExtract();
	
	/**
	 * 查询交易记录
	 * @param operatorID
	 * @param beginTime
	 * @param endTime
	 * @param userID
	 * @param dealType
	 * @param tradeType
	 * @param tradeAccount
	 * @param loginIP
	 * @return
	 */
	public BusResult queryDeals(Integer operatorID, String beginTime, String endTime,
			Integer userID, Integer dealType, Integer tradeType, Integer tradeAccount, 
			String loginIP);
	
	/**
	 * 查询账户余额列表
	 * @param operatorID
	 * @param order
	 * @param loginIP
	 * @return
	 */
	public BusResult queryBalances(Integer operatorID, Integer order, String loginIP);
	
	
	/**
	 * 审核提现
	 * @param operatorID
	 * @param extractID
	 * @param auditStatus
	 * @param failReason
	 * @param loginIP
	 * @return
	 */
	public BusResult auditExtract(Integer operatorID, Integer extractID, 
			Integer auditStatus, String failReason, String loginIP);
	
	
	
}
