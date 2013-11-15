package com.change.java.test;

import static com.change.java.util.Print.printArray1;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午10:02
 */
public class OverloadVarargs {

    static void f(Integer... args) {
        printArray1(args);
    }

    static void f(Character... args) {
        printArray1(args);
    }

    static void f(Long... args) {
        printArray1(args);
    }

    public static void main(String[] args) {
        f('1','a','c');
        f(1,4,5);
        f(1l,3l,5l);
    }

}
