package com.czh.springboot.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Title: RMITestImpl.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月27日
 * @version 1.0
 */
public class RMITestImpl extends UnicastRemoteObject implements IRMITest {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9032507351269660866L;

	public RMITestImpl() throws RemoteException {
		super();
	}

	@Override
	public String test01() throws RemoteException {
		return "RMI test01";
	}
	
	public static void main(String[] args) throws Exception {
		try {
			IRMITest rmiTest = new RMITestImpl();
			LocateRegistry.createRegistry(1099); 
			java.rmi.Naming.rebind("rmi://localrmi:1099/rmiTest", rmiTest);
			System.out.print("Ready");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
