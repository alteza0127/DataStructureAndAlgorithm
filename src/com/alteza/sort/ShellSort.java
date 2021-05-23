package com.alteza.sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
    }

    public static void shellSort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            int temp = 0;
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共5组，每组有2个元素），步长为5
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于步长后的那个元素，说明需要进行交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println(arr);
        }
//        int temp = 0;
//        //shell排序的第一轮排序
//        //第一轮排序 将10个数分成了5组
//        for (int i = 5; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组有2个元素），步长为5
//            for (int j = i - 5; j >= 0; j -= 5) {
//                //如果当前元素大于步长后的那个元素，说明需要进行交换
//                if (arr[j] > arr[j + 5]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //shell排序的第二轮排序
//        //第一轮排序 将10个数分成了5组
//        for (int i = 2; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组有2个元素），步长为5
//            for (int j = i - 2; j >= 0; j -= 2) {
//                //如果当前元素大于步长后的那个元素，说明需要进行交换
//                if (arr[j] > arr[j + 2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //shell排序的第二轮排序
//        //第一轮排序 将10个数分成了5组
//        for (int i = 1; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组有2个元素），步长为5
//            for (int j = i - 1; j >= 0; j -= 1) {
//                //如果当前元素大于步长后的那个元素，说明需要进行交换
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));

    }

}
