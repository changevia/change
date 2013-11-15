package com.change.java.test;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午8:16
 */
public class ChocolateChip extends Cookie {

    public ChocolateChip() {
        System.out.println("ChocolateChip Construtor");
    }

    public void chmop() {
         bite();
    }

    public static void main(String[] args) {
        ChocolateChip choco = new ChocolateChip();
        choco.chmop();
    }
}
