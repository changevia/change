package com.change.java.test;

import java.util.Arrays;
import java.util.Random;

import static com.change.java.util.Print.*;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午8:25
 */
public class ArrayNew {
    public static void main(String[] args) {
        int a[];
        Random random = new Random(47);
        a = new int[random.nextInt(20)];
        print("length of array = " + a.length);
        print(Arrays.toString(a));
    }
}
