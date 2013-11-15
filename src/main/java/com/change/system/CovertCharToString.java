package com.change.system;

import static com.change.java.util.Print.print;
import static com.change.java.util.Print.printf;

/**
 * User: changejava
 * Date: 13-10-26
 * Time: 下午9:46
 */
public class CovertCharToString {


    public static void main(String[] args) {

        String website ="http://www.baidu.com";
        char c = website.charAt(11);
        print(c);

        String s = Character.toString(c);
        if("b".equals(s))
            printf("%s\n", "match " + s);


        byte b = 65;
        printf("%s\n",Byte.toString(b));
    }

}
