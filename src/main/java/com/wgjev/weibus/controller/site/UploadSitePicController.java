package com.wgjev.weibus.controller.site;




import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.SiteService;


@Controller
@RequestMapping("/site")
public class UploadSitePicController {
	@Resource
	private SiteService siteService;
	
	@RequestMapping("/uploadSitePic.do")
	@ResponseBody
	public BusResult execute(Integer siteID, Integer operatorID, 
			@RequestParam(value="file",required=false) MultipartFile file, 
			HttpServletRequest request){
		
		return siteService.uploadSitePic(siteID, operatorID, file);
	}
	
}

