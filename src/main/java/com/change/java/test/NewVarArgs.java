package com.change.java.test;

import com.change.java.util.Print;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午8:58
 */
public class NewVarArgs {

    public static void main(String[] args) {
        Print.printArray1(new Float(-1), new Float(-34), 2);
        Print.printArray1(1, 4, 4);
        Print.printArray1(new A(), new A(), new A());
        Print.printArray1((Object[]) new Integer[]{1, -1, 1000});
        Print.printArray1();
    }
}
