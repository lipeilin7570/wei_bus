package com.wgjev.weibus.service;

import com.wgjev.weibus.entity.BusResult;


public interface IllService {
	
	/**
	 * 违章信息录入
	 * @param operatorID
	 * @param carNo
	 * @param illegalTime
	 * @param description
	 * @param address
	 * @param collectionUnit
	 * @param points
	 * @param fine
	 * @param remark
	 * @param loginIP
	 * @return
	 */
	public BusResult AddIllegal(Integer operatorID, Integer leaseID, String illegalTime, 
			String description, String address, String collectionUnit, Integer points, double fine, 
			String remark, String loginIP);
	
	/**
	 * 故障信息登记
	 * @param operatorID
	 * @param userID
	 * @param leaseID
	 * @param carID
	 * @param faultTime
	 * @param faultBrief
	 * @param userFault
	 * @param cancelFee
	 * @param couponFee
	 * @param addInFault
	 * @param payBail
	 * @param bailFee
	 * @param remark
	 * @param loginIP
	 * @return
	 */
	public BusResult addFault(Integer operatorID, Integer userID, Integer leaseID,
			Integer carID, String faultTime, String faultBrief, Integer userFault, 
			Integer cancelFee, double couponFee, Integer addInFault, Integer payBail,
			double bailFee, String remark, String loginIP);
	
	/**
	 * 查询有违章的订单
	 * @param operatorID
	 * @param undeal
	 * @param overDate
	 * @param loginIP
	 * @return
	 */
	public BusResult queryIllegalLease(Integer operatorID, Integer undeal, Integer overDate, String loginIP);
	
	/**
	 * 按订单查询违章
	 * @param operatorID
	 * @param leaseID
	 * @param loginIP
	 * @return
	 */
	public BusResult quertLeaseIllegal(Integer operatorID, Integer leaseID, String loginIP);
	
	/**
	 * 违章审核
	 * @param operatorID
	 * @param illegalID
	 * @param auditStatus
	 * @param failReason
	 * @param loginIP
	 * @return
	 */
	public BusResult auditIllegal(Integer operatorID, Integer illegalID, Integer auditStatus, String failReason, String loginIP);
	
	/**
	 * 违章未处理扣除保证金
	 * @param operatorID
	 * @param leaseID
	 * @param deductBail
	 * @param deductRemark
	 * @param addPenalty
	 * @param penaltyReason
	 * @param loginIP
	 * @return
	 */
	public BusResult undealIllegal(Integer operatorID, Integer leaseID, double deductBail, String deductRemark, 
			Integer addPenalty, String penaltyReason, String loginIP);
	
	/**
	 * 查询有故障的订单
	 * @param operatorID
	 * @param days
	 * @param faultStatus
	 * @param leaseID
	 * @param carNo
	 * @return
	 */
	public BusResult queryFault(Integer operatorID, Integer days, 
			Integer faultStatus, Integer leaseID, String carNo, String loginIP);
	
	/**
	 * 因故障结束订单
	 * @param operatorID
	 * @param leaseID
	 * @param cancelFee
	 * @param couponFee
	 * @param addInFault
	 * @param payBail
	 * @param bailFee
	 * @param remark
	 * @param loginIP
	 * @return
	 */
	public BusResult finishLeaseByFault(Integer operatorID, Integer leaseID, Integer cancelFee, 
			double couponFee, Integer addInFault, Integer payBail, double bailFee, String remark, String loginIP);
	
	/**
	 * 故障维修完毕
	 * @param operatorID
	 * @param faultID
	 * @param repairTime
	 * @param repairDetail
	 * @param repairFee
	 * @param userPayFee
	 * @param remark
	 * @param loginIP
	 * @return
	 */
	public BusResult faultRepaired(Integer operatorID, Integer faultID, String repairTime, String repairDetail,
			double repairFee, double userPayFee, String remark, String loginIP);
	
	/**
	 * 故障到期客户仍不支付费用处理
	 * @param operatorID
	 * @param faultID
	 * @param addPenalty
	 * @param penaltyReason
	 * @param loginIP
	 * @return
	 */
	public BusResult faultUnPay(Integer operatorID, Integer faultID, Integer addPenalty, 
			String penaltyReason, String loginIP);
	
	/**
	 * 事故登记
	 * @param operatorID
	 * @param userID
	 * @param leaseID
	 * @param carID
	 * @param acctTime
	 * @param acctBrief
	 * @param remark
	 * @param loginIP
	 * @return
	 */
	public BusResult addAccident(Integer operatorID, Integer userID, Integer leaseID, 
			Integer carID, String acctTime, String acctBrief, String remark, String loginIP);
	
	
	
}
