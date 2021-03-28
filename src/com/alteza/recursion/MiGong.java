package com.alteza.recursion;

/**
 * 迷宫问题
 *
 * @author Alteza
 */
public class MiGong {

    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println("结果：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 1、mao表示为地图
     * 2、i，j表示从那个位置开始
     * 3、终点为map[6][5]
     * 4、0、表示没有走 1、表示墙  2、表示可以走 3、表示已经走过，但走不通
     * 5、下-》右-》上-》左
     *
     * @param map 地图
     * @param i   从按个位置开始找
     * @param j
     * @return 如果找到 返回true
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            //没有走过
            if (map[i][j] == 0) {
                //假定可以走
                map[i][j] = 2;
                //向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                }
                //向右走
                else if (setWay(map, i, j + 1)) {
                    return true;
                }
                //向上走
                else if (setWay(map, i - 1, j)) {
                    return true;
                }
                //向左走
                else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //map[i][j] != 0  肯恩三个hi1，2，3
                return false;
            }
        }
    }

}
