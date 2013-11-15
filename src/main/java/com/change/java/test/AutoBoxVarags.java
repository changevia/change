package com.change.java.test;

import static com.change.java.util.Print.print;
import static com.change.java.util.Print.printArray1;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午9:50
 */
public class AutoBoxVarags {
    static void f(Integer... args) {
        printArray1(args);
    }

    public static void main(String[] args) {
        f(new Integer[]{199,19,9});
        f();
        f(1,3,1);
    }
}
