package com.change.java.test;
import static com.change.java.util.Print.*;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午8:52
 */
public class VarArgs {

    public static void main(String[] args) {
        printArray(new Object[]{new Float(1),new Float(2),new Float(0)});
        printArray(new Object[]{"one","two","three"});
        printArray(new Object[]{new A(),new A(),new A()});
    }
}

class A{}