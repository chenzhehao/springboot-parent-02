package com.chenzhehao.test.springbootnetty;


import com.alibaba.fastjson.JSON;

public class TestClass {

    public static void main(String[] a) {
        int[] array = new int[]{8, 3, 3, 3, 2, 1, 5, 63, 3};
        System.out.println(JSON.toJSON(maoPaoSeq(array)));

        array = new int[]{8, 3, 3, 3, 2, 1, 5, 63, 3};
        System.out.println(JSON.toJSON(chooseSeq(array)));

        array = new int[]{8, 3, 3, 3, 2, 1, 5, 63, 3};
        System.out.println(JSON.toJSON(insertSeq(array)));
    }

    /**
     * 冒泡排序
     *
     * @param p
     * @return
     */
    public static int[] maoPaoSeq(int[] p) {
        int odd = 0;
        for (int j = 0; j < p.length; j++) {
            for (int i = 1; i < (p.length - j); i++) {
                if (p[i - 1] > p[i]) {
                    odd = p[i - 1];
                    p[i - 1] = p[i];
                    p[i] = odd;
                } else {
                    odd = p[i];
                }
            }
        }
        return p;
    }

    /**
     * 选择排序--每次找出最小值所在的seq，然后和起始位置进行值互换
     *
     * @param p
     * @return
     */
    public static int[] chooseSeq(int[] p) {
        int minSeq;
        int odd;
        for (int i = 0; i < p.length; i++) {
            minSeq = i;
            for (int j = i + 1; j < p.length; j++) {
                if (p[j] < p[minSeq]) {
                    minSeq = j;
                }
            }
            if (minSeq != i) {
                odd = p[i];
                p[i] = p[minSeq];
                p[minSeq] = odd;
            }
        }

        return p;
    }

    /**
     * 插入排序--从头开始，按照其实一个有顺序，然后一次然后将值插入到前面已拍好顺序的队列中
     *
     * @param p
     * @return
     */
    public static int[] insertSeq(int[] p) {
        int odd;
        for (int i = 1; i < p.length; i++) {
            for (int j = i; j > 0; j--) {
                if (p[j - 1] > p[j]) {
                    odd = p[j - 1];
                    p[j - 1] = p[j];
                    p[j] = odd;
                } else {
                    break;
                }
            }
        }
        return p;
    }
}
