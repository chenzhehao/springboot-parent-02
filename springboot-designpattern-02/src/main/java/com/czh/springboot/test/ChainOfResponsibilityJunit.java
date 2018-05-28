package com.czh.springboot.test;

import org.junit.Test;

import com.czh.springboot.base.chainofresponsibility.Manager;
import com.czh.springboot.base.chainofresponsibility.Request;
import com.czh.springboot.base.impl.chainofresponsibility.CommonManager;
import com.czh.springboot.base.impl.chainofresponsibility.GeneralManager;
import com.czh.springboot.base.impl.chainofresponsibility.MajorManager;

/**
 * @Title: ChainOfResponsibility.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月28日
 * @version 1.0
 */
public class ChainOfResponsibilityJunit {

	@Test
	public void test1() {
		Manager common = new CommonManager("经理");
		Manager major = new MajorManager("总监");
		Manager general = new GeneralManager("总经理");
		common.setSuperior(major);
		major.setSuperior(general);

		Request request = new Request();
		request.setInfo("1214");
		request.setType(6);
		request.setUser("陈哲浩");
		String result = common.apply(request);
		System.out.println(result);
	}
}
