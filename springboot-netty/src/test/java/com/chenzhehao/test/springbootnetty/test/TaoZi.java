package com.chenzhehao.test.springbootnetty.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaoZi {

    public static void main(String[] a) {
        TaoZi taoZi = new TaoZi();
        //桃子
        int[] p = {30, 11, 23, 4, 20};
        int h = 4;
        System.out.println(getSept(p, h));

        //房子
        p = new int[]{-1, 2, 4, 9, 6};
        h = 8;
        System.out.println(JSON.toJSONString(getHomeStep(p, h)));

        //分班
        splitClass("1/N 2/Y 3/N 4/N");

        int[][] points = {{1, 1}, {1, 2}, {2, 1}, {2, 2}, {3, 3}, {4, 4}};
//        int[][] points = {{0, 0}, {1, 2}, {3, 1}, {2, -1}};
//        int[][] points = {{0, 0}, {1, 1}, {0, 1}, {1, 0}, {2, 0}, {2, 2}, {0, 2}};
//        System.out.println("可以组合的正方形数量： " + countSquares(points));
        System.out.println("可以组合的正方形数量： " + getNumZ(points));

//        getNumStoneCommon(new int[]{9,3,5,1,7,1,0});
        getNumStoneCommon(new int[]{0, 1, 1, 1, 1, 1, 1, 9, 8, 7, 10});


        taoZi.getThreeTreeHign(new int[]{5000, 2000, 5000, 8000, 1800, 7500, 4500, 1400, 8100});
        taoZi.getThreeTreeHign(new int[]{5000, 4000, 3000});


//        minglingStr("password__a12345678_timeout_100", 1);
        minglingStr("aaa_password_\"a12_45678\"_timeout__100_\"\"_", 2);
    }


    public static void minglingStr(String str, Integer index) {
        //使用_拆分字符串str
        List<String> strList = new ArrayList<>();
        String odd = "";
        boolean flag = false;//判断是否“”的命令字
        for (int i = 0; i < str.length(); i++) {
            if (!flag && str.charAt(i) == '_') {
                if (!odd.isEmpty()) {
                    strList.add(odd);
                    odd = "";
                }
            } else if (str.charAt(i) == '"') {
                if (!flag) {
                    flag = true;
                    odd += str.charAt(i);
                } else {
                    flag = false;
                    odd += str.charAt(i);
                    strList.add(odd);
                    odd = "";
                }
            } else {
                odd += str.charAt(i);
            }
        }
        System.out.println("拆分后的字符串：" + JSON.toJSONString(strList));
        if ((strList.size() - 1) < index) {
            System.out.println("ERROR");
        } else {
            String r = "";
            for (int j = 0; j < strList.size(); j++) {
                if (j != index) {
                    r += strList.get(j) + "_";
                } else {
                    r += "******_";
                }
            }
            r = r.substring(0, r.length() - 1);
            System.out.println(r);
        }
    }

    class ThreeTree {
        int val;
        ThreeTree left;
        ThreeTree right;
        ThreeTree middle;

        public ThreeTree(int val) {
            this.val = val;
        }
    }

    public void getThreeTreeHign(int[] p) {
        ThreeTree root = new ThreeTree(p[0]);
        for (int i = 1; i < p.length; i++) {
            zuZhuang(root, p[i]);
        }
        System.out.println("最大深度：" + getHigh(root));
    }

    public int getHigh(ThreeTree root) {
        //获取三叉树root的最大深度
        if (root == null) {
            return 0;
        } else {
            int left = getHigh(root.left);
            int right = getHigh(root.right);
            int middle = getHigh(root.middle);
            return Math.max(left, Math.max(right, middle)) + 1;
        }
    }

    public void zuZhuang(ThreeTree temp, int val) {
        if (val > temp.val + 500) {
            if (temp.right == null) {
                temp.right = new ThreeTree(val);
            } else {
                zuZhuang(temp.right, val);
            }
        } else if (val < temp.val - 500) {
            if (temp.left == null) {
                temp.left = new ThreeTree(val);
            } else {
                zuZhuang(temp.left, val);
            }
        } else {
            if (temp.middle == null) {
                temp.middle = new ThreeTree(val);
            } else {
                zuZhuang(temp.middle, val);
            }
        }
    }


    public static void getNumStoneCommon(int[] p) {
        int total = 0;
        for (int i = 0; i < p.length; i++) {
            total += p[i];
        }
        if (total % 2 != 0) {
            System.out.println("-1");
            return;
        }
        System.out.println("total:" + total);

        List<List> listList = new ArrayList<>();
        for (int j = 0; j < p.length; j++) {
            List<Integer> list = new ArrayList<>();
            getNumStone(p, j, 0, total, list);

            if (list.size() > p.length / 2) {
                List<Integer> list1 = new ArrayList<>();
                for (int i = 0; i < p.length; i++) {
                    if (!list.contains(i)) {
                        list1.add(i);
                    }
                }
                list = list1;
            }
            listList.add(list);
        }

        List<Integer> list = new ArrayList<>();
        for (List listOdd : listList) {
            if (listOdd.size() > 0 && (list.size() > listOdd.size() || list.size() == 0)) {
                list = listOdd;
            }
        }

        int total1 = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.print(p[list.get(i)] + " ");
            total1 += p[list.get(i)];
        }
        System.out.println();
        System.out.println(total1);
    }

    public static boolean getNumStone(int[] p, int n, int totalNow, int total, List<Integer> list) {
        for (int i = n; i < p.length; i++) {
            if (total / 2 > (totalNow + p[i])) {
                boolean flag = getNumStone(p, i + 1, totalNow + p[i], total, list);
                if (flag) {
                    list.add(i);
                    return true;
                }
            } else if (total / 2 == (totalNow + p[i])) {
                list.add(i);
                return true;
            }
        }
        return false;
    }


    public static int countSquares(int[][] points) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int count = 0;

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            if (!map.containsKey(x)) {
                map.put(x, new HashMap<>());
            }
            map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
        }

        for (int x1 : map.keySet()) {
            for (int y1 : map.get(x1).keySet()) {
                for (int x2 : map.keySet()) {
                    for (int y2 : map.get(x2).keySet()) {
                        if (Math.abs(x1 - x2) == Math.abs(y1 - y2) && x1 != x2 && y1 != y2) {
                            count += map.get(x1).get(y1) * map.get(x2).get(y2);
                        }
                    }
                }
            }
        }

        return count / 4; // 因为每个正方形会被计算四次，所以要除以4
    }

    public static int getNumZ(int[][] p) {
        if (p.length < 4) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                Double length = Math.pow(Double.valueOf(Math.abs(p[i][0] - p[j][0])), 2d)
                        + Math.pow(Double.valueOf(Math.abs(p[i][1] - p[j][1])), 2d);
                for (int k = i + 1; k < p.length; k++) {
                    Double length1 = Math.pow(Double.valueOf(Math.abs(p[i][0] - p[k][0])), 2d)
                            + Math.pow(Double.valueOf(Math.abs(p[i][1] - p[k][1])), 2d);
                    if (length.equals(length1)) {
                        for (int m = i + 1; m < p.length; m++) {
                            Double length2 = Math.pow(Double.valueOf(Math.abs(p[i][0] - p[m][0])), 2d)
                                    + Math.pow(Double.valueOf(Math.abs(p[i][1] - p[m][1])), 2d);
                            if (length2.equals(2 * length1)) {
                                Double length3 = Math.pow(Double.valueOf(Math.abs(p[j][0] - p[m][0])), 2d)
                                        + Math.pow(Double.valueOf(Math.abs(p[j][1] - p[m][1])), 2d);
                                Double length4 = Math.pow(Double.valueOf(Math.abs(p[k][0] - p[m][0])), 2d)
                                        + Math.pow(Double.valueOf(Math.abs(p[k][1] - p[m][1])), 2d);
                                Double length5 = Math.pow(Double.valueOf(Math.abs(p[j][0] - p[k][0])), 2d)
                                        + Math.pow(Double.valueOf(Math.abs(p[j][1] - p[k][1])), 2d);
                                if (length3.equals(length4) && length3.equals(length1) && length5.equals(length2)) {
                                    num++;
                                }
                            }
                        }
                    }

                }

            }
        }

        return num / 2;
    }

    public static void splitClass(String s) {
        String[] p = s.split(" ");
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        int index = 1;
        for (int i = 0; i < p.length; i++) {
            if (i == 0) {
                list1.add(p[i].substring(0, 1));
            } else {
                String[] odd = p[i].split("/");
                if (odd[1].equals("Y")) {
                    if (index == 1) {
                        list1.add(odd[0]);
                    } else {
                        list2.add(odd[0]);
                    }
                } else {
                    if (index == 1) {
                        index = 2;
                        list2.add(odd[0]);
                    } else {
                        index = 1;
                        list1.add(odd[0]);
                    }
                }
            }
        }

        System.out.println(list1);
        System.out.println(list2);
    }

    public static int[] getHomeStep(int[] p, int h) {
        if (h == 0) {
            return null;
        }
        int one = -1;
        int two = -1;
        int totalStep = -1;
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = i; j < p.length; j++) {
                int total = p[i] + p[j];
                if (total > 0 && total % h == 0) {
                    if (totalStep == -1 || total < totalStep) {
                        one = i;
                        two = j;
                        totalStep = total;
                    }
                }
            }
        }
        return new int[]{p[one], p[two]};
    }


    public static int getSept(int[] p, int h) {
        if (h < p.length) {
            return 0;
        }
        int max = 0;//最大值
        for (int i : p) {
            if (i > max) {
                max = i;
            }
        }

        for (int i = 1; i <= max; i++) {
            int kOdd = 0;
            for (int j = 0; j < p.length; j++) {
                int v = p[j] / i;
                v = p[j] % i > 0 ? v + 1 : v;
                kOdd += v;
            }
            if (kOdd <= h) {
                return i;
            }
        }

        return 0;
    }
}
