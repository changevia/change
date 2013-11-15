package com.change.java.test;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-8-19
 * Time: 上午1:22
 */
class Cleanser {
    private String s = Cleanser.class.getSimpleName();

    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }

    @Override
    public String toString() { return s; }

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.dilute(); cleanser.apply(); cleanser.scrub();
        print(cleanser);
    }
}

public class Detergent extends Cleanser {

    public void scrub() {
      append(" Detergent scrub() ");
      super.scrub();
    }
    public void foam() { append(" foam()") ;}

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Test base class ::");
        Cleanser.main(args);
    }
}
