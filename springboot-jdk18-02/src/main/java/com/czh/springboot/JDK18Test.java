package com.czh.springboot;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.springframework.cglib.core.internal.Function;

/**
 * @Title: JDK18Test.java
 * @Description:
 * @Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月27日
 * @version 1.0
 */
public class JDK18Test {

	class CollectionsTest {
		int degree;

		public int getDegree() {
			return degree;
		}

		public void setDegree(int degree) {
			this.degree = degree;
		}
	}

	@Test
	public void test1() {
		// List<Integer> list = new ArrayList<Integer>(10);
		List<Integer> list = Arrays.asList(1, 2, 5, 3, 8,4);
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(list);
		List<Integer> list1 = Arrays.asList(1, 2, 5, 3, 8,4);
		//JDK1.8 Lambda 表达式
		Collections.sort(list1, (a,b)->a.compareTo(b));
		System.out.println(list1);
		
		//JDK1.8 Lambda 表达式
		Thread thread1 = new Thread(()-> System.out.println("lambda test"));
		thread1.start();
		
	}

}
