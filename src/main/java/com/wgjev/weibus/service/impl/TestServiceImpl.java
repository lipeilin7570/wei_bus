package com.wgjev.weibus.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.wgjev.weibus.entity.BusResult;
import com.wgjev.weibus.service.TestService;
import com.wgjev.weibus.util.HttpRequester;
import com.wgjev.weibus.util.HttpRespons;

@Service
public class TestServiceImpl implements TestService {
	
	public BusResult test() {
		BusResult result = new BusResult();
		HttpRequester requester = new HttpRequester();
		
		HttpRespons respons;
		try {
			respons = requester.sendPost("http://115.236.53.93:8080/weiBus_app/info/loadChinaZcodes.do");
			System.out.println(respons.getContent());
			
			System.out.println(respons.getContentEncoding());
			
			
			
			result.setStatus(0);
			result.setData(respons.getContent());
			
			
		} catch (IOException e) {
			result.setData(1);
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		TestServiceImpl testServiceImpl = new TestServiceImpl();
		testServiceImpl.test();
	}
	
}
