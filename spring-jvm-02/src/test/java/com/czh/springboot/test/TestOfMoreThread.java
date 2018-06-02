package com.czh.springboot.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title: TestOfMoreThread.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月24日
 * @version 1.0
 */
public class TestOfMoreThread {

	int count =0;
	@Test
	public void test1() {
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			pool.execute(new Thread() {
				@Autowired
				public void run() {
					for (int j = 0; j < 10; j++) {
						HttpCommonService.httpRequest();
					}
					count++;
				}
			});
		}

		while(count < 100){
			
		}
	}

	static class HttpCommonService {
		public static void httpRequest() {
			URL url;
			try {
				url = new URL("http://127.0.0.1:8080/jvm/");
				// http协议传输
				HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
				httpUrlConn.setDoOutput(true);
				httpUrlConn.setDoInput(true);
				httpUrlConn.setUseCaches(false);
				httpUrlConn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
				// 设置请求方式（GET/POST）
				httpUrlConn.setRequestMethod("GET");
				httpUrlConn.setConnectTimeout(50000000);
				httpUrlConn.setReadTimeout(50000000);
				httpUrlConn.connect();

				OutputStream outStrm = httpUrlConn.getOutputStream();
				// outStrm.write(serviceData.toJSONString().getBytes("utf-8"));
				outStrm.flush();
				outStrm.close();

				// 将返回的输入流转换成字符串
				InputStream inputStream = httpUrlConn.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				String str = null;
				StringBuilder buffer = new StringBuilder();
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				bufferedReader.close();
				inputStreamReader.close();
				// 释放资源
				inputStream.close();
				inputStream = null;
				httpUrlConn.disconnect();
				System.out.println(buffer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
