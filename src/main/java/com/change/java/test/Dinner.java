package com.change.java.test;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午7:30
 */
public class Dinner {
    public static void main(String[] args) {
        Cookie cookie = new Cookie();
        cookie.bite();
    }
}



class Pie{
    void f(){
        System.out.println("Pie f()");
    }
}

class Cake{
    public static void main(String[] args) {
       Pie pie = new Pie();
       pie.f();
    }
}