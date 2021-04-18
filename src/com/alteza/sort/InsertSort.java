package com.alteza.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //定义待插入的数
            int insertVal = arr[i + 1];
            //arr[1]前面的数的下标
            int insertIndex = i + 1 - 1;
            //当待插入数小于第一个数时才进行交换,然后与下一个数比较，同时保证insertIndex不越界
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当待出入数大于前一个数 这时不需要和前面已经排过的数进行比较，因为前面的数已经拍好序号，最后一位就是最大的
            arr[insertIndex + 1] = insertVal;
            System.out.println("第" + i + "轮：" + Arrays.toString(arr));
        }

    }

}
