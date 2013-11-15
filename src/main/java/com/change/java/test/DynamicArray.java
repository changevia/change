package com.change.java.test;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午8:47
 */
public class DynamicArray {

    public static void main(String[] args) {
        Other.main(new String[]{"fiddle","de","dum"});
    }
}

class Other {
    public static void main(String[] args) {
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i] + " ");
//        }
        for (String arg : args) {
            System.out.println(arg + " ");
        }
    }
}
