package com.czh.springboot;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: BootOfRocketMq.java Description: Copyright: Copyright (c) 2018
 * Company: www.chenzhehao.com
 * 
 * @author chenzhehao
 * @date 2018年5月24日
 * @version 1.0
 */


//@EnableFeignClients(basePackages = "com.pica.cloud")
@SpringBootApplication(scanBasePackages = "com.czh.springboot")
//@EnableDiscoveryClient
//@EnableSwagger2
//@MapperScan("com.pica.cloud.campaign.ncov.server.mapper")
@RestController
@EnableCaching
public class BootOfJVM {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootOfJVM.class, args);
	}
	
	@RequestMapping("/")
	public Object jvmboot(){
		StringBuffer s = new StringBuffer();
		Random random = new Random();
		int time = random.nextInt(10000);
		s.append(new byte[1000*time]);
		for (int i = 0; i < time; i++) {
			s.append(i+"");
			s.append("asdfasdfasd");
			A a1 = new A(s.toString());
			A a2 = new A(s.toString());
			A a3 = new A(s.toString());
			A a4 = new A(s.toString());
//			System.out.println(a1);
//			System.out.println(a2);
//			System.out.println(a3);
//			System.out.println(a4);
		}
		try {
			Thread.sleep(random.nextInt(5000));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "success jvm";
	}
	class A{
		String name;
		public A(String name){
			this.name = name;
		}
	}
}
