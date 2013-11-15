package com.change.java.test;

import java.util.Arrays;
import java.util.Random;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午8:32
 */
public class ArrayClassObj {
    public static void main(String[] args) {
        Random random = new Random(47);
        Integer[] a = new Integer[random.nextInt(30)];

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(500);
        }

        print("array length is = " + a.length);
        print(Arrays.toString(a));
    }
}
