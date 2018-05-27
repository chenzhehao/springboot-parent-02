package com.czh.springboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Title: ProxyForBusiness.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月25日
 * @version 1.0
 */
public class JDKProxyForBusiness<T> implements InvocationHandler {

	private T t;

//	public ProxyForBusiness(T t) {
//		this.t = t;
//	}

	public Object getInstance(T t) {
		this.t = t;
		return Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println(t + "proxy method before");
		result = method.invoke(t, args);
		System.out.println(t + "proxy method end");
		return result;
	}

}
