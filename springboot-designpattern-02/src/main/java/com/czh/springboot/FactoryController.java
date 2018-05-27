package com.czh.springboot;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;

import javax.xml.transform.TransformerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: FactoryController.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月27日
 * @version 1.0
 */
@RestController
public class FactoryController {

	@RequestMapping("factory01")
	public void test1(){
		Calendar calendar =Calendar.getInstance();
		System.out.println(calendar);
		
		NumberFormat.getInstance();
		TransformerFactory.newInstance();
//		Class.forName("").newInstance();
	}
	
	public static void main(String[] args){
		Calendar calendar =Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar.getTime());
		
		
	}
}
