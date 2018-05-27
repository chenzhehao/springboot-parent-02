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
public class BusinessService02 implements BusinessInterface3 {

	@Override
	public Object test301() {
		return "02-301";
	}

	@Override
	public Object test302() {
		return "02-302";
	}

}
