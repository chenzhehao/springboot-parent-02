package com.czh.springboot.rmi.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Title: IRMITest.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月27日
 * @version 1.0
 */
public interface IRMITest extends Remote {

	public String test01() throws RemoteException;;
}
