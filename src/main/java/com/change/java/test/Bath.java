package com.change.java.test;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-8-19
 * Time: 上午1:06
 */
public class Bath {
    private String
            s1 = "Happy",
            s2 = "Happy",
            s3, s4;
    private Soap castille;
    private int i;
    private float toy;
    {   i =47;  }
    public Bath() {
        castille = new Soap();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bath{");
        if(s4==null)
           s4 ="joy";
        sb.append("s1='").append(s1).append('\'');
        sb.append(", s2='").append(s2).append('\'');
        sb.append(", s3='").append(s3).append('\'');
        sb.append(", s4='").append(s4).append('\'');
        sb.append(", castille=").append(castille);
        sb.append(", i=").append(i);
        sb.append(", toy=").append(toy);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Bath bath = new Bath();
        print(bath);
    }
}

class Soap {
    private String s;

    Soap() {
        System.out.println("Soap Construtor!");
        s = "Construtor";
    }

    @Override
    public String toString() {
        return s;
    }
}