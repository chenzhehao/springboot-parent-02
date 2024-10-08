package com.chenzhehao.test.springbootnetty;


import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class SortSeq {

    public static void main(String[] a) {
        Integer[] odd = new Integer[]{8, 3, 3, 3, 2, 1, 5, 63, 3, 0, 55, 2};
//        Integer[] odd = new Integer[]{8, 3, 3, 3, 2, 1, 5, 63, 3, 0, 2};
//        Integer[] odd = new Integer[]{8, 0, 2};
//        Integer[] odd = new Integer[]{8, 2};
//        Integer[] odd = new Integer[]{8};
        Integer[] array = new Integer[odd.length];

        array = Arrays.asList(odd).toArray(array);
        System.out.println("冒泡排序：" + JSON.toJSON(array));
        System.out.println(JSON.toJSON(maoPaoSeq(array)));

        array = Arrays.asList(odd).toArray(array);
        System.out.println("选择排序：" + JSON.toJSON(array));
        System.out.println(JSON.toJSON(chooseSeq(array)));

        array = Arrays.asList(odd).toArray(array);
        System.out.println("插入排序：" + JSON.toJSON(array));
        System.out.println(JSON.toJSON(insertSeq(array)));

        array = Arrays.asList(odd).toArray(array);
        System.out.println("归并排序：" + JSON.toJSON(array));
        guiBingRecursion(array, 0, array.length);
        System.out.println(JSON.toJSON(array));

        array = Arrays.asList(odd).toArray(array);
        System.out.println("快速排序：" + JSON.toJSON(array));
        quickSeq(array, 0, array.length);
        System.out.println(JSON.toJSON(array));

        array = Arrays.asList(odd).toArray(array);
        System.out.println("堆--排序：" + JSON.toJSON(array));
        heapSeq(array, array.length);
        System.out.println(JSON.toJSON(array));

        array = Arrays.asList(odd).toArray(array);
        System.out.println("希尔排序：" + JSON.toJSON(array));
        shellSeq(array);
        System.out.println(JSON.toJSON(array));

        array = Arrays.asList(odd).toArray(array);
        System.out.println("桶--排序：" + JSON.toJSON(array));
        bucketSeq(array);
        System.out.println(JSON.toJSON(array));

    }

    public static void comparator() {
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, (v1, v2)->{
            if (v1.compareTo(v2) > 0) {
                return 1;
            } else if (v1.compareTo(v2) < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.compareTo(o2) > 0) {
                    return 1;
                } else if (o1.compareTo(o2) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        list.sort((v1, v2)->{
            if (v1.compareTo(v2) > 0) {
                return 1;
            } else if (v1.compareTo(v2) < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        list = list.stream().filter(v -> v > 0).collect(Collectors.toList());

    }

    /**
     * 桶排序
     * @param p
     */
    public static void bucketSeq(Integer[] p){
        int bucketNum = 5;
        Integer max = p[0],min = p[0];
        for (int i = 1; i < p.length; i++) {
            if (p[i] > max) {
                max = p[i];
            }
            if (p[i] < min) {
                min = p[i];
            }
        }

        List<List<Integer>> bucketList =new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }
        Integer skip = (max-min)/bucketNum + 1;
        for (int i = 0; i < p.length; i++) {
            bucketList.get((p[i]-min)/skip).add(p[i]);
        }

        int j = 0;
        for (int i = 0; i < bucketList.size(); i++) {
            Integer[] array = new Integer[bucketList.get(i).size()];
            array = bucketList.get(i).toArray(array);
            shellSeq(array);
            for (int k = 0; k < array.length; k++) {
                p[j] = array[k];
                j++;
            }
        }

    }

    /**
     * 希尔排序--插入排序的改版
     *
     * @param p
     */
    public static void shellSeq(Integer[] p) {
        for (int i = p.length / 2; i >= 1; i = i / 2) {
            shellSeqSkip(p, 0, i);
        }
    }

    public static void shellSeqSkip(Integer[] p, int begin, int skip) {
        for (int i = begin + skip; i < p.length; i += skip) {
            for (int j = i; j >= skip; j -= skip) {
                if (p[j - skip] > p[j]) {
                    swap(p, j - skip, j);
                }
            }
        }
    }


    /**
     * 堆排序
     *
     * @param p
     * @param pLen
     */
    public static void heapSeq(Integer[] p, int pLen) {
        int i;
        for (i = (pLen - 1) / 2; i >= 0; --i)
            shiftHeap(p, pLen, i);  // 建立初始堆
        for (i = pLen - 1; i > 0; --i) {
            swap(p, 0, i);    //交换首尾元素，第i次排序完成
            shiftHeap(p, i, 0);   // 重构堆（i记录了上次发生交换的结点）
        }
    }

    //堆化:构建大顶堆
    public static void shiftHeap(Integer[] p, int heapSize, int k) {
        while (2 * k + 1 < heapSize) {  // 在 k节点的所有子元素中执行一下步骤
            int i = 2 * k + 1;  // i为k的左孩子
            if (i + 1 < heapSize && (p[i + 1] > p[i]))  // 如果其右孩子在需排序的长度范围内，且左孩子小于右孩子
                i += 1; //该节点遍历结束，
            if (p[k] >= p[i])   //当k结点大于该节点终止循环
                break;
            swap(p, k, i);    //不符合堆定义，交换元素位置
            k = i;  //更新节点交换后的位置
        }
    }

    public static void swap(Integer[] p, int i, int j) {
        int t = p[i];    // 这里交换整个data而非排序字段
        p[i] = p[j];
        p[j] = t;
    }


    /**
     * 快速排序
     *
     * @param p
     * @param begin
     * @param end
     */
    public static void quickSeq(Integer[] p, int begin, int end) {
        if (begin < end) {
            int base = getBaseIndex(p, begin, end);
            quickSeq(p, begin, base);
            quickSeq(p, base + 1, end);
        }
    }

    public static int getBaseIndex(Integer[] p, int begin, int end) {
        int base = begin;
        int index = base + 1;
        for (int i = begin; i < end; i++) {
            if (p[i] < p[base]) {
                int odd = p[i];
                p[i] = p[index];
                p[index] = odd;
                index++;
            }
        }

        int odd = p[base];
        p[base] = p[index - 1];
        p[index - 1] = odd;
        return index - 1;
    }


    /**
     * 冒泡排序
     *
     * @param p
     * @return
     */
    public static Integer[] maoPaoSeq(Integer[] p) {
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
    public static Integer[] chooseSeq(Integer[] p) {
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
    public static Integer[] insertSeq(Integer[] p) {
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

    /**
     * 归并排序--分治法
     *
     * @param p
     * @param begin
     * @param end
     */
    public static void guiBingRecursion(Integer[] p, int begin, int end) {
        if (begin == end || (begin + 1) == end) {
            return;
        }
        int middle = (begin + end) / 2;
        guiBingRecursion(p, begin, middle);
        guiBingRecursion(p, middle, end);
        //排序
        int odd;
        for (int i = middle; i < end; i++) {
            for (int j = i; j > begin; j--) {
                if (p[j - 1] > p[j]) {
                    odd = p[j - 1];
                    p[j - 1] = p[j];
                    p[j] = odd;
                } else if (i - 1 == j) {
                    break;
                }
            }
        }
    }


}
