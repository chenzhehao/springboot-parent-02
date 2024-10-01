package com.chenzhehao.test.springbootnetty.test;

import java.util.Scanner;

public class QiShuiBoot {

    /**
     * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
     * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
     * 数据范围：输入的正整数满足 1≤n≤100 1≤n≤100 
     * <p>
     * 注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。 
     * 时间限制：C/C++ 1秒，其他语言2秒
     * 空间限制：C/C++ 32M，其他语言64M
     * 输入描述：
     * 输入文件最多包含 10 组测试数据，每个数据占一行，仅包含一个正整数 n（ 1<=n<=100 ），表示小张手上的空汽水瓶数。n=0 表示输入结束，你的程序不应当处理这一行。
     * 输出描述：
     * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
     * 示例1
     * 输入例子：
     * 3
     * 10
     * 81
     * 0
     * 输出例子：
     * 1
     * 5
     * 40
     * 例子说明：
     * 样例 1 解释：用三个空瓶换一瓶汽水，剩一个空瓶无法继续交换
     * 样例 2 解释：用九个空瓶换三瓶汽水，剩四个空瓶再用三个空瓶换一瓶汽水，剩两个空瓶，向老板借一个空瓶再用三个空瓶换一瓶汽水喝完得一个空瓶还给老板
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int[] param = new int[10];
            int i = 0;
            while (in.hasNext()) {
                param[i] = in.nextInt();
                if (param[i] == 0) {
                    break;
                }
                i++;
            }
            for (int j = 0; j < i; j++) {
                int n = param[j];
                int r = 0;
                while (true) {
                    if (n >= 3) {
                        r++;
                        n = n - 3;
                        n++;
                    } else {
                        if (n == 2) {
                            r++;
                            break;
                        } else {
                            break;
                        }

                    }
                }
                System.out.println(r);
            }
        }
    }
}
