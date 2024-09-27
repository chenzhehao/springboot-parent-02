package com.chenzhehao.test.springbootnetty;


import com.alibaba.fastjson.JSON;

public class TestClass {

    public static void main(String[] a) {
        System.out.println(JSON.toJSON(maoPaoSeq(new int[]{8,3,3,3,2,1,5,63,3}))
        );
    }

    /**
     * 冒泡排序
     * @param p
     * @return
     */
    public static int[] maoPaoSeq(int[] p){
        int odd = 0;
        for (int j = 0; j < p.length; j++) {
            for (int i = 1; i < (p.length - j); i++) {
                if (p[i-1] > p[i]) {
                    odd = p[i-1];
                    p[i-1] = p[i];
                    p[i] = odd;
                } else {
                    odd = p[i];
                }
            }
        }
        return p;
    }
}
