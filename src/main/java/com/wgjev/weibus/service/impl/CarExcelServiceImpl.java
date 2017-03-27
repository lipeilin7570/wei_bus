package com.wgjev.weibus.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wgjev.weibus.dao.CarInfoMapper;
import com.wgjev.weibus.dao.ModelDetailInfoMapper;
import com.wgjev.weibus.dao.OperatorSysMapper;
import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.entity.CarInfo;
import com.wgjev.weibus.entity.ModelDetailInfo;
import com.wgjev.weibus.entity.OperatorSys;
import com.wgjev.weibus.service.CarExcelService;
import com.wgjev.weibus.util.BusUtil;

@Service
public class CarExcelServiceImpl implements CarExcelService {
	
	@Resource
	private CarInfoMapper carInfoMapper;
	
	@Resource
	private ModelDetailInfoMapper modelDetailInfoMapper;
	
	@Resource
	private OperatorSysMapper operatorSysMapper;
	
	/**
	 * 批量导入车辆信息
	 */
	@SuppressWarnings("unchecked")
	public BusResult importFile(Integer operatorID, Integer companyID, MultipartFile mFile, String rootPath, String loginIP) {
		// TODO Auto-generated method stub
		BusResult result = new BusResult();
		
		OperatorSys operatorSys = operatorSysMapper.selectByPrimaryKey(operatorID);
		List<CarInfo> carList = new ArrayList<CarInfo>();
		String errorRow = "";
		String fileName = mFile.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		String ym = new SimpleDateFormat("yyyy-MM").format(new Date());
		String filePath = "uploadFile/" + ym + fileName;
		
		try {
			File file = new File(rootPath + filePath);
			if (file.exists()) {
				file.delete();
				file.mkdirs();
			} else {
				file.mkdirs();
			}
			mFile.transferTo(file);

			if ("xls".equals(suffix) || "XLS".equals(suffix)) {
				Map<String, Object> map = importXls(file, companyID);
				carList = (List<CarInfo>) map.get("carList");
				errorRow = (String) map.get("errorRow");
				for (CarInfo carInfo : carList) {
					carInfo.setCreatetime(new Date());
					carInfo.setCompanyid(companyID);
					carInfo.setCreatemanid(operatorID);
					carInfo.setCreateman(operatorSys.getSysusename());
					carInfoMapper.insertSelective(carInfo);
				}
			} else if ("xlsx".equals(suffix) || "XLSX".equals(suffix)) {
				Map<String, Object> map = importXlsx(file, companyID);
				carList = (List<CarInfo>) map.get("carList");
				errorRow = (String) map.get("errorRow");
				for (CarInfo carInfo : carList) {
					carInfo.setCreatetime(new Date());
					carInfo.setCreatemanid(operatorID);
					carInfo.setCompanyid(companyID);
					carInfo.setCreateman(operatorSys.getSysusename());
					carInfoMapper.insertSelective(carInfo);
				}
			}
			result.setStatus(0);
			result.setData(carList.size());
			result.setMsg(errorRow);
		} catch (Exception e) {
			result.setStatus(1);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Xls文件
	 * @param file
	 * @param companyID
	 * @return
	 */
	private Map<String, Object> importXls(File file, Integer companyID) {
		List<CarInfo> carList = new ArrayList<CarInfo>();
		String errorRow="";
		InputStream is = null;
		HSSFWorkbook hWorkbook = null;
		
		try {
			is = new FileInputStream(file);
			hWorkbook = new HSSFWorkbook(is);
			HSSFSheet hSheet = hWorkbook.getSheetAt(0);
			
			if (null != hSheet) {
				for (int i = 11; i < hSheet.getPhysicalNumberOfRows(); i++) {
					CarInfo carInfo = new CarInfo();
					HSSFRow xRow = hSheet.getRow(i);
					try {
						//车牌号
						carInfo.setCarno(xRow.getCell(1).toString());
						//车辆模型
						String modelName = xRow.getCell(2).toString().toUpperCase();
						Map<String, Object> params = new HashMap<String, Object>();
						params.put("companyID", companyID);
						params.put("modelName", modelName);
						ModelDetailInfo modelDetailInfo = modelDetailInfoMapper.findModelDetailByModelNameAndCompanyID(params);
						if (modelDetailInfo == null) {
							if (i==hSheet.getPhysicalNumberOfRows()-1) {
								errorRow=errorRow+(i-10);
							}else {
								errorRow=errorRow+(i-10)+"、";
							}
							continue;
						}
						carInfo.setCarmodelid(modelDetailInfo.getCarmodelid());
						carInfo.setModeldetailid(modelDetailInfo.getModeldetailid());
						//
						carInfo.setCarvin(xRow.getCell(3).toString());
						carInfo.setCarcolor(new Double(xRow.getCell(4).toString()).intValue());
						carInfo.setPeople(new Double(xRow.getCell(5).toString()).intValue());
						carInfo.setCarstatus(new Double(xRow.getCell(6).toString()).intValue());
						carInfo.setTerminalno(xRow.getCell(7).toString());
						carInfo.setSimno(xRow.getCell(8).toString());
						carInfo.setBluetoothno(xRow.getCell(9).toString());
						carInfo.setNameplatetime(BusUtil.stringToDate(xRow.getCell(10).toString()));
						carInfo.setRegistrationtime(BusUtil.stringToDate(xRow.getCell(11).toString()));
						carInfo.setMachineno(xRow.getCell(12).toString());
						carInfo.setBatterycode(xRow.getCell(13).toString());
						carInfo.setCharginggun(new Double(xRow.getCell(14).toString()).intValue());
						carInfo.setExtinguisher(new Double(xRow.getCell(15).toString()).intValue());
						carInfo.setTools(new Double(xRow.getCell(16).toString()).intValue());
						carInfo.setSign(new Double(xRow.getCell(17).toString()).intValue());
						carInfo.setSparetire(new Double(xRow.getCell(18).toString()).intValue());
						
					} catch (Exception e) {
						// TODO: handle exception
						if (i==hSheet.getPhysicalNumberOfRows()-1) {
							errorRow=errorRow+(i-10);
						}else {
							errorRow=errorRow+(i-10)+"、";
						}
						continue;
					}
					carList.add(carInfo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (null != hWorkbook) {
				try {
					hWorkbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("carList", carList);
		map.put("errorRow", errorRow);
		
		return map;
	}

	/**
	 * Xlsx文件
	 */
	private Map<String, Object> importXlsx(File file, Integer companyID) {
		List<CarInfo> carList = new ArrayList<CarInfo>();
		String errorRow="";
		InputStream is = null;
		XSSFWorkbook xWorkbook = null;
		try {
			is = new FileInputStream(file);
			xWorkbook = new XSSFWorkbook(is);
			XSSFSheet xSheet = xWorkbook.getSheetAt(0);

			if (null != xSheet) {
				for (int i = 11; i < xSheet.getPhysicalNumberOfRows(); i++) {
					CarInfo carInfo = new CarInfo();
					XSSFRow xRow = xSheet.getRow(i);

					try {
						//车牌号
						carInfo.setCarno(xRow.getCell(1).toString());
						//车辆模型
						String modelName = xRow.getCell(2).toString().toUpperCase();
						Map<String, Object> params = new HashMap<String, Object>();
						params.put("companyID", companyID);
						params.put("modelName", modelName);
						ModelDetailInfo modelDetailInfo = modelDetailInfoMapper.findModelDetailByModelNameAndCompanyID(params);
						if (modelDetailInfo == null) {
							if (i==xSheet.getPhysicalNumberOfRows()-1) {
								errorRow=errorRow+(i-10);
							}else {
								errorRow=errorRow+(i-10)+"、";
							}
							continue;
						}
						carInfo.setCarmodelid(modelDetailInfo.getCarmodelid());
						carInfo.setModeldetailid(modelDetailInfo.getModeldetailid());
						//
						carInfo.setCarvin(xRow.getCell(3).toString());
						carInfo.setCarcolor(new Double(xRow.getCell(4).toString()).intValue());
						carInfo.setPeople(new Double(xRow.getCell(5).toString()).intValue());
						carInfo.setCarstatus(new Double(xRow.getCell(6).toString()).intValue());
						carInfo.setTerminalno(xRow.getCell(7).toString());
						carInfo.setSimno(xRow.getCell(8).toString());
						carInfo.setBluetoothno(xRow.getCell(9).toString());
						carInfo.setNameplatetime(BusUtil.stringToDate(xRow.getCell(10).toString()));
						carInfo.setRegistrationtime(BusUtil.stringToDate(xRow.getCell(11).toString()));
						carInfo.setMachineno(xRow.getCell(12).toString());
						carInfo.setBatterycode(xRow.getCell(13).toString());
						carInfo.setCharginggun(new Double(xRow.getCell(14).toString()).intValue());
						carInfo.setExtinguisher(new Double(xRow.getCell(15).toString()).intValue());
						carInfo.setTools(new Double(xRow.getCell(16).toString()).intValue());
						carInfo.setSign(new Double(xRow.getCell(17).toString()).intValue());
						carInfo.setSparetire(new Double(xRow.getCell(18).toString()).intValue());
						
					} catch (Exception e) {
						// TODO: handle exception
						if (i==xSheet.getPhysicalNumberOfRows()-1) {
							errorRow=errorRow+(i-10);
						}else {
							errorRow=errorRow+(i-10)+"、";
						}
						continue;
					}
					
					carList.add(carInfo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (null != xWorkbook) {
				try {
					xWorkbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("carList", carList);
		map.put("errorRow", errorRow);
		
		return map;
	}
	

}
