package com.wgjev.weibus.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class BusUtil {
	
	/**
	 * 服务器接口IP、端口号
	 */
//	public static String SERVICE_IP = "http://115.236.53.93:8080/";
//	public static String SERVICE_IP = "http://61.130.145.175:9080/";
	public static String SERVICE_IP = "http://106.14.37.228:10080/";
	
	/**
	 * 请求接口的IP、端口号
	 */
//	public static String BASE_IP = "http://115.236.53.93:8090/";
	public static String BASE_IP = "http://106.14.37.228:8090/";
	
	public static String md5(String msg) throws NoSuchAlgorithmException{
		// 利用md5加密msg
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] input = msg.getBytes();
		byte[] output = md.digest(input); // 将字节信息进行处理
		// 将md5处理的output结果转成字符串
		String result = Base64.encodeBase64String(output);
		return result;
	}
	// 随机生成一个UUID
	public static String createId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/**
	 * yyyy-MM-dd转Date
	 * @param dateStr
	 * @return
	 */
	public static Date stringToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss转Date
	 * @param dateStr
	 * @return
	 */
	public static Date stringToDateTime(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * HH:mm:ss转Date
	 * @param dateStr
	 * @return
	 */
	public static Date stringToTime(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Date转yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);

		return str;
	}

	/**
	 * Date转yyyyMMdd
	 * @param date
	 * @return
	 */
	public static String dateToLongStr(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(date);

		return str;
	}
	
	
	/**
	 * Date转yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String dayToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);

		return str;
	}
		
		
}
