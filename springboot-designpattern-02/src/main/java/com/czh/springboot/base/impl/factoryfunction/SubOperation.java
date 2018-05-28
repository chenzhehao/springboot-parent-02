package com.czh.springboot.base.impl.factoryfunction;

import com.czh.springboot.base.factoryfunction.Operation;

/**
 * @Title: AddOperation.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月28日
 * @version 1.0
 */
public class SubOperation extends Operation {

	@Override
	public double getResault() {
		return getOperationA() - getOperationB();
	}

}
