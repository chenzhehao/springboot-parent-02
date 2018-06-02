package com.czh.springboot.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: HeapOOM.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月29日
 * @version 1.0
 */
public class HeapOOM {

	public static void main(String[] args) {

//		List<HeapOOM> list = new ArrayList<HeapOOM>();
//		while(true){
//			list.add(new HeapOOM());
//		}
		
		String a = new StringBuffer("计算机").append("软件").toString();
		System.out.println(a.intern() == a);
		
		String b = new StringBuffer("ja").append("va").toString();
		System.out.println(b.intern() == b);
		
		String b1 = new StringBuffer("ja").append("va").toString();
		System.out.println(b1.intern() == b1);
		System.out.println(b.intern() == b1.intern());
		
		String c = new String("计算机");
		System.out.println(c.intern() == c);
		
	}
}
