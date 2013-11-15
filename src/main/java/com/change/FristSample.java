package com.change;

import java.io.Console;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * User: changejava
 * Date: 13-8-5
 * Time: 上午12:07
 */
public class FristSample {


    public static void main(String[] args) {
        System.out.println("We will not user Hello World !!");
        char c= 'a';
        int a =  c;
        Integer i =128;

        System.out.println(c);
        System.out.println(a);
        System.out.println(i);

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);
        printf(str);
        usePrintWriter(str);
        Console console = System.console();
        if(console!=null){
            String userName = console.readLine();
            char[] password = console.readPassword();

            System.out.println("userName :" + userName + ",password :"  + password);
        }

//        {
//            String str = null;  Error
//        }
        int [] luckNumbers = {1,2,4,67,8,0,0};
        int[] copiedLuckNumbers = Arrays.copyOf(luckNumbers, luckNumbers.length +10);
        printf(copiedLuckNumbers);
    }

    public static void printf(Object ...args){
        Object arrays[] = args;
        int index = 0;
        for (Object array : arrays){
            System.out.printf("arg"+ (index++) +"%s\n" , array);
        }
    }
    private static PrintStream printStream = System.out;
    public static void usePrintWriter(String str){
        printStream.printf("str:%s" , str);
    }
}
