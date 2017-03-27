package com.wgjev.weibus.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wgjev.weibus.dao.SiteInfoMapper;
import com.wgjev.weibus.dao.json.BeaconJsonMapper;
import com.wgjev.weibus.dao.json.PileJsonMapper;
import com.wgjev.weibus.dao.json.SiteHasCarsAndParksJsonMapper;
import com.wgjev.weibus.dao.json.SiteJsonMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.SiteInfo;
import com.wgjev.weibus.entity.json.BeaconJson;
import com.wgjev.weibus.entity.json.PileJson;
import com.wgjev.weibus.entity.json.SiteJson;
import com.wgjev.weibus.service.SiteService;
import com.wgjev.weibus.util.SaveImgUtil;

@Service
public class SiteServiceImpl implements SiteService{
	
	@Resource
	private SiteInfoMapper siteInfoMapper;
	
	
	@Resource
	private SiteHasCarsAndParksJsonMapper siteHasCarsAndParksJsonMapper;
	
	@Resource
	private SiteJsonMapper siteJsonMapper;
	
	@Resource
	private PileJsonMapper pileJsonMapper;
	
	@Resource
	private BeaconJsonMapper beaconJsonMapper;
	
	/**
	 * 根据公司ID加载站点信息
	 */
	public BusResult findSiteByCompany(Integer companyID) {
		BusResult result = new BusResult();
		List<SiteJson> list;
		if (companyID == 0) {
			list = siteJsonMapper.loadAllSiteJson();
		}else {
			list = siteJsonMapper.loadAllSiteJsonByCompanyID(companyID);
		}
		for (SiteJson siteJson : list) {
			List<PileJson> piles = pileJsonMapper.findPileBySiteID(siteJson.getSiteID());
			List<BeaconJson> beacons = beaconJsonMapper.loadBeaconBySiteID(siteJson.getSiteID());
			siteJson.setBeacons(beacons);
			siteJson.setPiles(piles);
		}
		
		result.setStatus(0);
		result.setData(list);
		
		return result;
	}

	
	/**
	 * 新增站点信息
	 */
	public BusResult addSite(Integer operatorID, String siteName, String siteCode, 
			String zcode, String siteAddress, 
			Double longitude, Double latitude, Double siteRadius, Integer siteManID,
			String siteMan, String startTime, String endTime,Integer pileStatus, 
			Integer status, Integer miniParkingCount, Integer parkingCount, 
			String remark, Integer companyID, MultipartFile file) {
		BusResult result = new BusResult();
		SiteInfo siteInfo = new SiteInfo();
		
		if (siteName != null) {
			siteInfo.setSitename(siteName);
		}
		if (siteCode != null) {
			siteInfo.setSitecode(siteCode);
		}
		if (zcode != null) {
			siteInfo.setZcode(zcode);
		}
		if (siteAddress != null) {
			siteInfo.setSiteaddress(siteAddress);
		}
		if (longitude != null) {
			siteInfo.setLongitude(new BigDecimal(longitude));
		}
		if (latitude != null) {
			siteInfo.setLatitude(new BigDecimal(latitude));
		}
		if (siteRadius != null) {
			siteInfo.setSiteradius(new BigDecimal(siteRadius));
		}
		if (siteManID != null) {
			siteInfo.setSitemanid(siteManID);
		}
		if (siteMan != null) {
			siteInfo.setSiteman(siteMan);
		}
		if (startTime != null) {
			siteInfo.setStarttime(startTime);
		}
		if (endTime != null) {
			siteInfo.setEndtime(endTime);
		}
		if (pileStatus != null) {
			siteInfo.setPilestatus(pileStatus);
		}
		if (status != null) {
			siteInfo.setStatus(status);
		}
		if (miniParkingCount != null) {
			siteInfo.setMiniparkingcount(miniParkingCount);
		}
		if (parkingCount != null) {
			siteInfo.setParkingcount(parkingCount);
		}
		if (remark != null) {
			siteInfo.setRemark(remark);
		}
		if (companyID != null) {
			siteInfo.setCompanyid(companyID);
		}
		siteInfo.setCreatetime(new Date());
		if (file!= null) {
			if (!file.isEmpty()) {
				//获取文件类型
				String contentType=file.getContentType();
				//获取文件后缀名称
				String imageName=contentType.substring(contentType.indexOf("/")+1);
//				System.out.println(imageName);
				try {
					String path = SaveImgUtil.save("site", file);
					siteInfo.setSitepicicon(path);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		siteInfoMapper.insertSelective(siteInfo);
		result.setStatus(0);
		return result;
	}

	/**
	 * 修改站点信息
	 */
	public BusResult changeSiteInfo(Integer operatorID, Integer siteID, String siteName, String siteCode, 
			String zcode, String siteAddress, 
			Double longitude, Double latitude, Double siteRadius, Integer siteManID,
			String siteMan, String startTime, String endTime,Integer pileStatus, 
			Integer status, Integer miniParkingCount, Integer parkingCount, 
			String remark, Integer companyID, MultipartFile file) {
		BusResult result = new BusResult();
		
		SiteInfo siteInfo = new SiteInfo();
		if (siteID != null) {
			siteInfo.setSiteid(siteID);
		}
		if (siteName != null) {
			siteInfo.setSitename(siteName);
		}
		if (siteCode != null) {
			siteInfo.setSitecode(siteCode);
		}
		if (zcode != null) {
			siteInfo.setZcode(zcode);
		}
		if (siteAddress != null) {
			siteInfo.setSiteaddress(siteAddress);
		}
		if (longitude != null) {
			siteInfo.setLongitude(new BigDecimal(longitude));
		}
		if (latitude != null) {
			siteInfo.setLatitude(new BigDecimal(latitude));
		}
		if (siteRadius != null) {
			siteInfo.setSiteradius(new BigDecimal(siteRadius));
		}
		if (siteManID != null) {
			siteInfo.setSitemanid(siteManID);
		}
		if (siteMan != null) {
			siteInfo.setSiteman(siteMan);
		}
		if (startTime != null) {
			siteInfo.setStarttime(startTime);
		}
		if (endTime != null) {
			siteInfo.setEndtime(endTime);
		}
		if (pileStatus != null) {
			siteInfo.setPilestatus(pileStatus);
		}
		if (status != null) {
			siteInfo.setStatus(status);
		}
		if (miniParkingCount != null) {
			siteInfo.setMiniparkingcount(miniParkingCount);
		}
		if (parkingCount != null) {
			siteInfo.setParkingcount(parkingCount);
		}
		if (remark != null) {
			siteInfo.setRemark(remark);
		}
		if (companyID != null) {
			siteInfo.setCompanyid(companyID);
		}
		
		if (file != null) {
			if (!file.isEmpty()) {
				//获取文件类型
				String contentType=file.getContentType();
				//获取文件后缀名称
				String imageName=contentType.substring(contentType.indexOf("/")+1);
//				System.out.println(imageName);
				try {
					String path = SaveImgUtil.save("site", file);
					siteInfo.setSitepicicon(path);
					siteInfoMapper.updateByPrimaryKeySelective(siteInfo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				result.setStatus(0);
			}
		}
		
		siteInfoMapper.updateByPrimaryKeySelective(siteInfo);
		
		result.setStatus(0);
		return result;
	}
	
	/**
	 * 修改站点状态
	 */
	public BusResult changeSiteStatus(Integer siteID, Integer status) {
		BusResult result = new BusResult();
		SiteInfo siteInfo = new SiteInfo();
		siteInfo.setSiteid(siteID);
		siteInfo.setStatus(status);
		siteInfoMapper.updateByPrimaryKeySelective(siteInfo);
		
		result.setStatus(0);
		return result;
	}

	/**
	 * 上传站点图片
	 */
	public BusResult uploadSitePic(Integer siteID, Integer operatorID, MultipartFile file) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		SiteInfo site = siteInfoMapper.selectByPrimaryKey(siteID);
		if (site == null) {
			//站点不存在
			result.setStatus(101);
			return result;
		}
		
		
		if (!file.isEmpty()) {
			//获取文件类型
			String contentType=file.getContentType();
			//获取文件后缀名称
			String imageName=contentType.substring(contentType.indexOf("/")+1);
			System.out.println(imageName);
			try {
				String path = SaveImgUtil.save("site", file);
				SiteInfo siteInfo = new SiteInfo();
				siteInfo.setSiteid(siteID);
				siteInfo.setSitepicicon(path);
				siteInfoMapper.updateByPrimaryKeySelective(siteInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			result.setStatus(0);
		}else {
			//上传文件为空
			result.setStatus(102);
		}
		
		return result;
	}

}
