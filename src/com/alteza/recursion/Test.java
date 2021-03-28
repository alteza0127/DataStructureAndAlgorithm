package com.alteza.recursion;

/**
 * 递归测试
 * 程序执行到一个方法，就会开辟于一个独立的空间
 *
 * @author Alteza
 */
public class Test {

    public static void main(String[] args) {
        test(4);
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

}
