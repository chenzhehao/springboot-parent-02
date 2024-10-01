package com.chenzhehao.test.springbootnetty;


import java.util.Scanner;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class SudoKuTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            boolean exist = true;
            int num = 0;
            while (exist) {
                num++;
                if (num >=1000) {
                    break;
                }
                exist = false;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (arr[i][j] == 0) {
                            exist = true;
                            Map<Integer, Integer> mapShu9 = check(arr, i, j, 0);
                            Set<Integer> shuSet = inNum(arr, i, j, 0, mapShu9);
                            Map<Integer, Integer> mapheng9 = check(arr, i, j, 1);
                            Set<Integer> hengSet = inNum(arr, i, j, 1, mapheng9);
                            Map<Integer, Integer> mapzhong9 = check(arr, i, j, 2);
                            Set<Integer> zhongSet = inNum(arr, i, j, 2, mapzhong9);
                            Set<Integer> baseSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                            baseSet.retainAll(shuSet);
                            baseSet.retainAll(hengSet);
                            baseSet.retainAll(zhongSet);
                            if (baseSet.size() == 1) {
                                for (Integer integer : baseSet) {
                                    arr[i][j] = integer;
                                }
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    public static Set<Integer> inNum(int[][] arr, int i, int j, int type,
                                     Map<Integer, Integer> map) {
        Set<Integer> baseSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Map<Integer, Integer> mapOdd = new HashMap<>();
        mapOdd.putAll(map);
        Map<Integer, Integer> mapR = new HashMap<>();
        for (Integer integer : mapOdd.keySet()) {
            baseSet.remove(mapOdd.get(integer));
            if (mapOdd.get(integer) == 0) {
                mapR.put(integer, mapOdd.get(integer));
            }
        }
        int index = -1;
        int value = 0;
        if (baseSet.size() == 1) {
            for (Integer integer : mapR.keySet()) {
                index = integer;
            }
            for (Integer integer : baseSet) {
                value = integer;
            }
        }
        if (index >= 0) {
            if (type == 0) {
                arr[index][j] = value;
            } else if (type == 1) {
                arr[i][index] = value;
            } else if (type == 2) {
                int ia = i / 3;
                int ja = j / 3;
                if (index < 3) {
                    arr[ia *3 + 0][ja * 3 + index % 3] = value;
                } else if (index < 6) {
                    arr[ia *3 + 1][ja * 3 + index % 3] = value;
                } else {
                    arr[ia *3 + 2][ja * 3 + index % 3] = value;
                }
            }
            return new HashSet<>();
        } else {
            return baseSet;
        }
    }

    //type 0行 1列
    public static Map<Integer, Integer> check(int[][] arr, int i, int j, int type) {
        Map<Integer, Integer> map = new HashMap<>();
        if (type == 0) {
            for (int k = 0; k < 9; k++) {
                map.put(k, arr[k][j]);
            }
        } else if (type == 1) {
            for (int k = 0; k < 9; k++) {
                map.put(k, arr[i][k]);
            }
        } else if (type == 2) {
            int ia = i / 3;
            int ja = j / 3;
            int index = 0;
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    map.put(index, arr[ia * 3 + k][ja * 3 + l]);
                    index++;
                }
            }
        }
        return map;
    }
}