package com.czh.springboot.test;

import org.junit.Test;

import com.czh.springboot.base.factoryfunction.IFactory;
import com.czh.springboot.base.factoryfunction.Operation;
import com.czh.springboot.base.impl.factoryfunction.AddFactory;
import com.czh.springboot.base.impl.factoryfunction.SubFactory;

/**  
* @Title: FactoryFunctionJunit.java 
* @Description:   
* @Copyright: Copyright (c) 2018
* @Company: www.chenzhehao.com 
* @author chenzhehao  
* @date 2018年5月28日  
* @version 1.0  
*/
public class FactoryFunctionJunit {

	@Test
	public void test01(){
		IFactory addFactory = new AddFactory();
		IFactory subFactory = new SubFactory();
		Operation add = addFactory.getOperation();
		Operation sub = subFactory.getOperation();
		add.setOperationA(123);
		add.setOperationB(456);
		sub.setOperationA(123);
		sub.setOperationB(456);
		System.out.println(add.getResault());
		System.out.println(sub.getResault());
		
	}
}
