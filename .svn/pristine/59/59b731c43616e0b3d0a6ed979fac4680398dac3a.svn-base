package com.wgjev.weibus.util;

import java.io.*; 
import java.net.*;
import com.wgjev.weibus.entity.BusResult;

public class JsonPostUtil {
	public static BusResult sendPost(String url, String jsonParam){
		BusResult result = new BusResult();
		HttpURLConnection connection = null;
		DataOutputStream out = null;
		BufferedReader reader = null;
		try {
			URL postUrl = new URL(url);
			connection = (HttpURLConnection)postUrl.openConnection();
			connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded;charset=UTF-8");
            
            connection.connect();
            //POST请求
            
            out = new DataOutputStream(
                    connection.getOutputStream());
//            out.writeBytes(jsonParam);
            jsonParam=URLEncoder.encode(jsonParam, "utf-8");
            out.write(jsonParam.getBytes());
//            out.writeUTF(jsonParam);
            out.flush();
            
            //读取响应
            reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            result.setStatus(1);
            result.setData(sb);
			
		} catch (Exception e) {
			result.setStatus(1);
			e.printStackTrace();
		}finally {
			try {
				if (out != null) {
					out.close();
				}
				if (reader != null) {
					reader.close();
				}
				if (connection != null) {
					connection.disconnect();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
