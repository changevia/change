package com.change.java.test;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午7:26
 */
public class IceStream {

    public static void main(String[] args) {
//       Sundae sundae = new Sundae();
        Sundae sundae = Sundae.makeASundae();
    }


}
class Sundae{
    private Sundae(){}

    static Sundae makeASundae(){
        return new Sundae();
    }
}