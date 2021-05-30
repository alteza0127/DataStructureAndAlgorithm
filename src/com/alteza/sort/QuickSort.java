package com.alteza.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 是对冒泡排序的一种改进:通过一趟排序将摇排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对着两部分
 * 数据进行快速排序，整个排序过程可以递归进行
 *
 * @author Alteza
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 79, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            //在中值的左边一直找，找到大于中值的就退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在中值的右边一直找，找到小于等于，退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r 说明中值的左右两边的值，已经全部是小于
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r -= 1;
            }
            //
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }
        //左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //右递归
        if (left > r) {
            quickSort(arr, l, right);
        }
    }

}
