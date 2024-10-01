package com.chenzhehao.test.springbootnetty.test;

import java.util.Scanner;

public class RandomNum {

    /**
     * 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。 
     * 数据范围： 1≤n≤1000 1≤n≤1000  ，输入的数字大小满足 1≤val≤500 1≤val≤500 
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case

            int num = in.nextInt();
            int[] p = new int[num];
            for (int i = 0; i < num; i++) {
                p[i] = in.nextInt();
            }
            //排序
            for (int i = 0; i < num; i++) {
                for (int j = 1; j < num - i; j++) {
                    if (p[j - 1] > p[j]) {
                        int odd = p[j];
                        p[j] = p[j - 1];
                        p[j - 1] = odd;
                    }
                }
            }

            int now = p[0];
            System.out.println(now);
            for (int i = 1; i < num; i++) {
                if (p[i] != now) {
                    now = p[i];
                    System.out.println(now);

                }

            }

        }
    }
}
