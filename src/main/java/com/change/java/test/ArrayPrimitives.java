package com.change.java.test;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午8:21
 */
public class ArrayPrimitives {


    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, -1, -8,};
        int[] a2;
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a2[i] + 1;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }

        for (int i = 0; i < a2.length; i++) {
            System.out.println(a2[i]);
        }
    }
}
