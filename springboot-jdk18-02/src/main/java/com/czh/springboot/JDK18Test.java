package com.czh.springboot;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

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
		List<Integer> list = Arrays.asList(1, 2, 5, 3, 8, 4);
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(list);
		List<Integer> list1 = Arrays.asList(1, 2, 5, 3, 8, 4);
		// JDK1.8 Lambda 表达式
		Collections.sort(list1, (a, b) -> a.compareTo(b));
		System.out.println(list1);

		// JDK1.8 Lambda 表达式
		Thread thread1 = new Thread(() -> System.out.println("lambda test"));
		thread1.start();

		LinkedList<String> linkedList = new LinkedList<>();
		// linkedList.addFirst(e);
		// linkedList.addLast(e);
		// linkedList.removeFirst();
		// linkedList.removeLast();

	}

	@Test
	public void searchTest() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 12, 10, 11, 19, 18, 17 };
		// a = xuZe(a);
		a = maoPap(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println();
		int begin = 0;
		int end = a.length - 1;
		int value = 7;
		System.out.println(search2(begin, end, a, value));
	}

	// 二分搜索
	public int search2(int begin, int end, int[] a, int value) {
		int mid = (begin + end) / 2;
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] < value) {
			return search2(mid + 1, end, a, value);
		} else {
			return search2(begin, mid - 1, a, value);
		}
	}

	// 冒泡排序
	public int[] maoPap(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}

	// 选择排序
	public int[] xuZe(int[] a) {
		int min_index = 0;
		for (int i = 0; i < a.length - 1; i++) {
			min_index = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min_index] > a[j]){
					min_index = j;
				}
			}
			if (min_index != i) {
				int temp = a[min_index];
				a[min_index] = a[i];
				a[i] = temp;
			}
		}
		System.out.println(a);
		return a;
	}

	// 插入排序
	private static int[] insertSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return arr;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					// TODO:
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					// 接下来是无用功
					break;
				}
			}
		}
		return arr;
	}

	// 快速排序
	public int[] sort(int[] arr, int low, int high) {
		int l = low;
		int h = high;
		int povit = arr[low];

		while (l < h) {
			while (l < h && arr[h] >= povit)
				h--;
			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}

			while (l < h && arr[l] <= povit)
				l++;
			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
		}
		System.out.println(arr);
		System.out.print("l=" + (l + 1) + "h=" + (h + 1) + "povit=" + povit + "\n");
		if (l > low)
			sort(arr, low, l - 1);
		if (h < high)
			sort(arr, l + 1, high);
		return arr;
	}

}
