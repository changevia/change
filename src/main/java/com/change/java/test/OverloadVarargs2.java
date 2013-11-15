package com.change.java.test;

import static com.change.java.util.Print.printArray1;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午10:02
 */
public class OverloadVarargs2 {

    static void f(Character... args) {
        printArray1(args);
    }

    static void f(float i, Character... args) {
        printArray1(args);
    }

    public static void main(String[] args) {
//        f('1', 'a', 'c');
    }

}
