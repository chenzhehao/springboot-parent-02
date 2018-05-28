package com.czh.springboot.base.chainofresponsibility;

/**
 * @Title: Manager.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月28日
 * @version 1.0
 */
public abstract class Manager {

	public String name;
	public Manager superior;

	public Manager getSuperior() {
		return superior;
	}

	public void setSuperior(Manager superior) {
		this.superior = superior;
	}

	public Manager(String name) {
		this.name = name;
	}

	public abstract String apply(Request request);
}
