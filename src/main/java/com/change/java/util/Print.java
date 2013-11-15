package com.change.java.util;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午8:28
 */
public class Print {

    public static void print(Object str){
        System.out.println(str);
    }
    public static void printf(String format,Object str){
        System.out.printf(format,str);
    }

    public static void printArray(Object []obj){
        for (Object o : obj) {
            System.out.print( o + " ");
        }
        System.out.println();
    }

    public static void printArray1(Object... obj){
        for (Object o : obj) {
            System.out.print( o + " ");
        }
        System.out.println();
    }
}
