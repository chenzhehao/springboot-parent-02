package com.czh.springboot.base.impl.chainofresponsibility;

import com.czh.springboot.base.chainofresponsibility.Manager;
import com.czh.springboot.base.chainofresponsibility.Request;

/**
 * @Title: CommonManager.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月28日
 * @version 1.0
 */
public class GeneralManager extends Manager {

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public String apply(Request request) {
		if (request.type == 3) {
			return "success";
		} else if (request.type == 4) {
			return "fail";
		} else{
			return "think";
		}
	}

}
