package com.change.java.test;

import static com.change.java.util.Print.*;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午9:06
 */
public class OptionalTrailingArguments {

    static void f(int required, String... trailing) {
        print("required : " + required);
        printArray(trailing);
    }

    public static void main(String[] args) {
        f(1);
        f(1,"one","three");
        f(1,"one","three","two");
    }
}
