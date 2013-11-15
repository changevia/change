package com.change.file.zip;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-19
 * Time: 下午3:01
 */
public class RecoverComputer {

    public static void main(String[] args) {
        print("I am  recovery ,My god!! ");
        int  j = 0;
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            if(i>900000){
                continue;
            }
            if(i>800000){
                continue;
            }
        }

        print((System.currentTimeMillis()-l));

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            if(i>900000||i>800000){
                continue;
            }
        }

        print((System.currentTimeMillis()-start));
    }
}
