package com.change.socket;

/**
 * User: changejava
 * Date: 13-11-15
 * Time: 下午2:50
 */
public class MainMethod {


    public static void main(String[] arg) throws InterruptedException {
        for (; ; ) {
            System.out.println("=======================");
            Thread.sleep(5000L);
            System.out.println("=======================");

            System.out.println();
            addHotSwapMethod();
        }
    }

    private static void addHotSwapMethod() {
        System.out.println("addHotSwapMethod!!");
    }
}
