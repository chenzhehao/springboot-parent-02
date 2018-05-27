package com.czh.springboot;

import java.rmi.Naming;

import com.czh.springboot.rmi.impl.IRMITest;

/**
 * @Title: RMIController.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月27日
 * @version 1.0
 */
public class RMIClient {

	public static void main(String[] args) {
		try {
			IRMITest rmiTest = (IRMITest) Naming.lookup("rmi://localrmi:1099/rmiTest");
			System.out.println(rmiTest.test01());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
