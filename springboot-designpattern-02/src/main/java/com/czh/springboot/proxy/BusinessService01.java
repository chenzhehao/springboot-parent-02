package com.czh.springboot.proxy;

/**
 * @Title: BusinessService01.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月25日
 * @version 1.0
 */
public class BusinessService01 implements BusinessInterface, BusinessInterface2 {

	private String a;

	public BusinessService01() {
	}

	public BusinessService01(String a) {
		this.setA(a);
	}

	@Override
	public Object test01() {
		return "01-01";
	}

	@Override
	public Object test02() {
		return "01-02";
	}

	@Override
	public Object test201() {
		return "01-201";
	}

	@Override
	public Object test202() {
		return "01-202";
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

}
