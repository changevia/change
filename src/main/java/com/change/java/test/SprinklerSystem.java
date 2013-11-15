package com.change.java.test;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-8-19
 * Time: 上午12:58
 */
public class SprinklerSystem {
    private String value1,value2;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SprinklerSystem{");
        sb.append("value1='").append(value1).append('\'');
        sb.append(", value2='").append(value2).append('\'');
        sb.append(", source=").append(source);
        sb.append(", i=").append(i);
        sb.append(", f=").append(f);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        print(sprinklers);
    }
}

class WaterSource {
    private String s;
    WaterSource() {
        System.out.println("Water Source Construtor!");
        s = "Construtor";
    }
    @Override
    public String toString() {  return s;}
}