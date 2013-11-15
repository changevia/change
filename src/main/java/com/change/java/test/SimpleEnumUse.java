package com.change.java.test;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午3:43
 */
public class SimpleEnumUse {
    public static void main(String[] args) {
        Spiciness not = Spiciness.NOT;
        System.out.println(not);


        for (Spiciness spiciness : Spiciness.values()) {
            System.out.println(spiciness.ordinal() + ">>>" + spiciness.toString());
        }
    }
}
