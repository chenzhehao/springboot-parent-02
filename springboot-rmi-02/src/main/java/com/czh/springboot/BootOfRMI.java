package com.czh.springboot;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czh.springboot.rmi.impl.IRMITest;
import com.czh.springboot.rmi.impl.RMITestImpl;

/**
 * @Title: BootOfRocketMq.java
 * @Description: Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月24日
 * @version 1.0
 */
@SpringBootApplication
@RestController
public class BootOfRMI {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootOfRMI.class, args);
		
		try {
			IRMITest rmiTest = new RMITestImpl();
			LocateRegistry.createRegistry(1099); 
			java.rmi.Naming.rebind("rmi://localrmi:1099/rmiTest", rmiTest);
			System.out.print("Ready");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/")
	public Object RMIboot() {
		return "success";
	}
}
