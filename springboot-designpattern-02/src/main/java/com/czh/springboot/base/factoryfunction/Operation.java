package com.czh.springboot.base.factoryfunction;

/**
 * @Title: IOperation.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月28日
 * @version 1.0
 */
public abstract class Operation {

	private double operationA;
	private double operationB;

	public abstract double getResault();

	public double getOperationA() {
		return operationA;
	}

	public void setOperationA(double operationA) {
		this.operationA = operationA;
	}

	public double getOperationB() {
		return operationB;
	}

	public void setOperationB(double operationB) {
		this.operationB = operationB;
	}
}
