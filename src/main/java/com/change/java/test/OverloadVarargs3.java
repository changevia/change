package com.change.java.test;

import static com.change.java.util.Print.printArray1;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午10:02
 */
public class OverloadVarargs3 {

    static void f(int i,Character... args) {
        printArray1(args);
    }

    static void f(float i, Character... args) {
        printArray1(args);
    }

    public static void main(String[] args) {
        f(1,'1', 'a', 'c');
        //OverloadVarargs2.java:21: 对 f 的引用不明确，com.change.java.test.OverloadVarargs2 中的 方法
        // f(java.lang.Character...)
        // 和 com.change.java.test.OverloadVarargs2 中的 方法 f(float,java.lang.Character...) 都匹配
    }

}
