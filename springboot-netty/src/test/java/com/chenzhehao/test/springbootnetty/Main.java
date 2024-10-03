package com.chenzhehao.test.springbootnetty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        fun1();
//        fun2();
//        String v1 = "10010000";
//        String v2 = "1001110";
//        System.out.println(Integer.toHexString(Integer.parseInt(v1, 2)));
//        System.out.println(Integer.toHexString(Integer.parseInt(v2, 2)));

        try {
//        String str = "(sub 2 3)";
//        String str = "(sub (mul 2 4) (div 9 3))";
            String str = "(sub (mul (add 2 (sub 5 1)) 4) (div 9 3))";
            System.out.println(suan(str, 0));
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static String suan(String strAll, int index){
        String str1 = strAll.substring(index + 1);
        if (str1.contains("(")) {
            String newStrAll = suan(strAll, index +1+ str1.indexOf("("));
            int indexYou = newStrAll.indexOf(")");
            String caozuo = newStrAll.substring(index+1, index+4);
            String odd = newStrAll.substring(index+5, indexYou);
            String s1 = odd.substring(0, odd.indexOf(" "));
            String s2 = odd.substring(odd.indexOf(" ")+1);
            Integer val = caozuo(caozuo, s1, s2);
            return newStrAll.substring(0,index) + val.toString() + newStrAll.substring(indexYou + 1);
        } else {
            int indexYou = str1.indexOf(")");
            String caozuo = str1.substring(0, 3);
            String odd = str1.substring(4, indexYou);
            String s1 = odd.substring(0, odd.indexOf(" "));
            String s2 = odd.substring(odd.indexOf(" ")+1);
            Integer val = caozuo(caozuo, s1, s2);
            return strAll.substring(0,index) + val.toString() + str1.substring(indexYou + 1);
        }
    }

    public static int caozuo(String caozuo, String s1, String s2) {
        s1 = s1.replace(" ","");
        s2 = s2.replace(" ","");
        int r = 0;
        switch (caozuo) {
            case "add":r =Integer.valueOf(s1) +Integer.valueOf(s2);break;
            case "sub":r =Integer.valueOf(s1) -Integer.valueOf(s2);break;
            case "mul":r =Integer.valueOf(s1) *Integer.valueOf(s2);break;
            case "div":r =Integer.valueOf(s1) /Integer.valueOf(s2);break;
        }
        return r;
    }


    public static void fun2() {
        //a:3,b:5,c:2@a:1,b:2
        //a:2,b:3,c:2
//        String str = "A:1,a:1,b:5,c:2@a:1,b:2";
        String str = "a:1,b:5,c:2@";

        String[] split = str.split("@");
        if (split.length <= 1) {
            System.out.println(str.replace("@", ""));
            return;
        }
        if ("".equals(split[1]) || split[1] == null) {
            System.out.println(split[0]);
            return;
        }

        String str1 = split[0];
        String str2 = split[1];

        String[] split1 = str1.split(",");
        String[] split2 = str2.split(",");

        List<String> list = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int j = 0; j < split1.length; j++) {
            map1.put(split1[j].split(":")[0], Integer.parseInt(split1[j].split(":")[1]));
            list.add(split1[j].split(":")[0]);
        }
        for (int j = 0; j < split2.length; j++) {
            map2.put(split2[j].split(":")[0], Integer.parseInt(split2[j].split(":")[1]));
        }
        for (String s : map2.keySet()) {
            if (map1.containsKey(s)) {
                map1.put(s, map1.get(s) - map2.get(s));
            }
        }

        String result = "";
        for (int j = 0; j < list.size(); j++) {
            if (map1.get(list.get(j)) > 0) {
                result += list.get(j) + ":" + map1.get(list.get(j)) + ",";
            }
        }
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        System.out.println(result);

    }


    public static void fun1() {

        int a = 10000;//E807
        //将a转化为二进制字符串
        String b = Integer.toBinaryString(a);
        System.out.println(b);

        //从有向左7位遍历
        String result = "";
        for (int j = b.length(); j > 0; j -= 7) {
            String odd = "";
            boolean nextFlag = false;
            if ((j - 7) < 0) {
                odd = b.substring(0, j);
            } else {
                odd = b.substring(j - 7, j);
            }
            if (j - 7 > 0) {
                nextFlag = true;
            }
            if (nextFlag) {
                odd = "1" + odd;
            } else {
                odd = odd;
            }
            //将odd转化为16进制
            int c = Integer.parseInt(odd, 2);
            if (c < 16) {
                result += "0" + Integer.toHexString(c);
            } else {
                result += Integer.toHexString(c);
            }
        }
        System.out.println(result.toUpperCase());
    }
}
