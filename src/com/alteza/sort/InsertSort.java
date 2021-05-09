package com.alteza.sort;

/**
 * 插入排序
 *
 * @author Alteza
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 11, 22, 3};
        insertSort(arr);
        System.out.println(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //定义带插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;

            //给insertVal找到插入的位置
            //此时
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出循环，说明此时插入的位置找到
            arr[insertIndex + 1] = insertVal;
        }
    }

}
