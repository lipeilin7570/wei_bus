package com.wgjev.weibus.controller.site;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.SiteExcelService;

@Controller
@RequestMapping("/site")
public class AddSiteInfoFromExcelController {
	
	@Resource
	private SiteExcelService siteExcelService;
	
	@RequestMapping("/importSite.do")
	@ResponseBody
	public BusResult execute(Integer operatorID, Integer companyID, @RequestParam(value="uploadFile")MultipartFile mFile, 
			HttpServletRequest request, HttpServletResponse response){
		
		String rootPath = request.getSession().getServletContext().getRealPath(File.separator);
		String loginIP = request.getRemoteHost();
		BusResult result = siteExcelService.importFile(operatorID, companyID, mFile, rootPath, loginIP);
		
		return result;
	}
	
}
