package com.change.java.test;

import java.util.Arrays;
import static com.change.java.util.Print.*;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午8:39
 */
public class ArrayInit {

    public static void main(String[] args) {
        Integer []a = {
          new Integer(11),
          new Integer(12),
          3 ,
        };

        Integer []b= {
          new Integer(-1),
          new Integer(10),
          100,
        };

        print(Arrays.toString(a));
        print(Arrays.toString(b));
    }
}
