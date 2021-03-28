package com.alteza.recursion;

/**
 * @author Alteza
 */
public class Queue8 {

    /**
     * 定义一个max共有多少个皇后
     * 定义一个数组，存放皇后所在的位置
     */
    int max = 8;
    int[] array = new int[max];

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
    }

    /**
     * 放置第N个皇后
     */
    private void check(int n) {
        //n=8
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
            //如果冲突 继续执行array[n] = i
        }
    }

    /**
     * 查看当放置N个时，就去检测该是否和前面已经拜访的冲突
     * true 不冲突
     * false 冲突
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //判断第N个是否和前面的皇后是否在同一列
            //判断第N个是否和前面的皇后是否在同一斜线
            //该题：同一斜线为对角线，斜率为1 判断两点是否在同一对角线上
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    /**
     * 写一个方法，将皇后的位置输出
     */
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
