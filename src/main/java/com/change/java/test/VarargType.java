package com.change.java.test;

import static com.change.java.util.Print.*;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午9:10
 */
public class VarargType {

    static void f(Character... args) {
        print(args.getClass());
        print("length = " + args.length);
    }

    static void g(int... args) {
        print(args.getClass());
        print("length = " + args.length);
    }

    public static void main(String[] args) {
        f('1', (char)97);
        f();
        g(1);
        g();
        print("int []" +  new int[0].getClass());
    }
}
