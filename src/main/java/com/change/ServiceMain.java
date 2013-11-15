package com.change;

import com.javadb.ws.example.ExampleService;

import javax.xml.ws.Endpoint;

/**
 * User: changejava
 * Date: 13-8-7
 * Time: 下午3:19
 */
public class ServiceMain {

    public static void main(String[] args) {
//        Endpoint.publish("http://localhost:8080/example/exampleService",
//                        new ExampleService());

        int i = -3;
        byte b = (byte) i;
        byte b1 = 1;

        byte b2 = (byte) (b1 + 1);


        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);

        System.out.println(Integer.toBinaryString(7));

        int b3 = 7;

        b3 = b3 >> 3;//右移 除以 2 的N  次方

        System.out.println(b3);

        b3 = b3 << 3;   // 左移乘以 2 的N 次方

        System.out.println(b3);

        b3 = -25;

        System.out.println(b3 >> 3);
        System.out.println(b3 << 3);

        b3 = -10;

        System.out.println(b3 >> 3);
        System.out.println(b3 << 3);

        String s = new String(new byte[]{b2, b2});
        System.out.println(s + "===========");


        byte bt = 10;

        bt = (byte) (bt + 1);
        bt += 1;
        System.out.println(3 >= 5);   //3>5 或者3==5
        System.out.println(5 >= 3);     //5>3 或者5==3
//        if (!true) {
//            return;

        if (true) {
            System.out.println("true" + 1);
            System.out.println("true");
        } else
            System.out.println("test!!!!");

    }
}
