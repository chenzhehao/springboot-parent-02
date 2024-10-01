package com.chenzhehao.test.springbootnetty.test;

import java.util.Scanner;

public class ExchangeNum {

    /**
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。 
     *
     * 数据范围：保证结果在 1≤n≤231−1 1≤n≤231−1
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int v = 0;
            int j = 1;
            for(int i =s.length();i>2;i--) {
                String s1 = s.substring(i-1,i);
                switch (s1){
                    case "A": s1 = "10";break;
                    case "B": s1 = "11";break;
                    case "C": s1 = "12";break;
                    case "D": s1 = "13";break;
                    case "E": s1 = "14";break;
                    case "F": s1 = "15";break;
                    default:break;
                }
                v+= (Integer.valueOf(s1)*j);
                j *=16;
            }
            System.out.println(v);
        }
    }
}
