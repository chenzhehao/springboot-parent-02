package com.czh.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czh.springboot.proxy.BusinessInterface;
import com.czh.springboot.proxy.BusinessInterface2;
import com.czh.springboot.proxy.BusinessInterface3;
import com.czh.springboot.proxy.BusinessService01;
import com.czh.springboot.proxy.BusinessService02;
import com.czh.springboot.proxy.CGLibProxyForBusiness;
import com.czh.springboot.proxy.JDKProxyForBusiness;

/**
 * @Title: ProxyController.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月25日
 * @version 1.0
 */
@RestController
public class ProxyController {

	/**
	 * 
	 * @Title: test
	 * @Description: JDK动态代理测试
	 * @return
	 */
	@RequestMapping("/proxy01")
	public Object test() {
		/*
		 * BusinessService01 implements BusinessInterface,BusinessInterface2
		 * BusinessService02 implements BusinessInterface3 可以访问到所有实现的接口的函数
		 * JDK代理只能对接口，应为生产代理类本身已经继承了Proxy类
		 */
		JDKProxyForBusiness<BusinessService01> proxy1 = new JDKProxyForBusiness<BusinessService01>();
		JDKProxyForBusiness<BusinessService02> proxy2 = new JDKProxyForBusiness<BusinessService02>();
		BusinessInterface b1 = (BusinessInterface) proxy1.getInstance(new BusinessService01());
		BusinessInterface3 b2 = (BusinessInterface3) proxy2.getInstance(new BusinessService02());
		b1.test01();
		b1.test02();
		b2.test301();
		b2.test302();
		BusinessInterface2 b11 = (BusinessInterface2) b1;
		b11.test201();
		b11.test202();
		return "proxy01";
	}

	/**
	 * 
	 * @Title: test2 
	 * @Description: CGLib动态代理
	 * @return
	 */
	@RequestMapping("/proxy02")
	public Object test2() {
		/*
		 * 虽然可以传入对象，但是还是使用的class重新创建，所以传入的参数获取不到
		 * 只能先使用默认构造器生成代理类，然后再将参数传入
		 */
		CGLibProxyForBusiness proxy = new CGLibProxyForBusiness();
		BusinessService01 b1 = (BusinessService01) proxy.getInstance(new BusinessService01("1234"));
		BusinessService01 b2 = (BusinessService01) proxy.getInstance(BusinessService01.class);
		System.out.println(b1.getA());//参数获取不到，反射重新创建类
		System.out.println(b2.getA());
		b1.test01();
		b1.test02();
		b1.test201();
		b1.test202();
		return "sucess";
	}
}
