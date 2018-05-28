package com.czh.springboot.base.impl.factoryfunction;

import com.czh.springboot.base.factoryfunction.IFactory;
import com.czh.springboot.base.factoryfunction.Operation;

/**  
* @Title: AddFactory.java 
* @Description:   
* @Copyright: Copyright (c) 2018
* @Company: www.chenzhehao.com 
* @author chenzhehao  
* @date 2018年5月28日  
* @version 1.0  
*/
public class SubFactory implements IFactory{

	public Operation getOperation(){
		return new SubOperation();
	}
}
