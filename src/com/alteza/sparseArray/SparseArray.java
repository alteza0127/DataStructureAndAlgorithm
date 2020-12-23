package com.alteza.sparseArray;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0表示没有棋子，1表示黑子 2表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将数组 转为稀疏数组
        //1、先遍历二维数组，得到非0的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2、创建对应的稀疏数组
        int spareArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = sum;

        //遍历二维数组，将非0的值存放到数组中
        //用于记录是第几个非0数据
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    spareArr[count][0] = i;
                    spareArr[count][1] = j;
                    spareArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println();
        for (int i = 0; i < spareArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", spareArr[i][0], spareArr[i][1], spareArr[i][2]);
        }
    }

}
