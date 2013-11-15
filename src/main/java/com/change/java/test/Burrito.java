package com.change.java.test;

/**
 * User: changejava
 * Date: 13-8-18
 * Time: 下午3:47
 */
public class Burrito {
    private Spiciness spiciness;

    public Burrito(Spiciness spiciness) {
        this.spiciness = spiciness;
    }

    public void describe() {
        System.out.println(" the burrito is ");
        switch (spiciness) {
            case NOT:
                System.out.println("not spicy at all");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little hot");
                break;
            case FLAMING:
            default:
                System.out.println("may be to hot");
                break;
        }
    }


    public static void main(String[] args) {
        Burrito
            plain = new Burrito(Spiciness.NOT),
            greenChile = new Burrito(Spiciness.MEDIUM),
            jalapeno = new Burrito(Spiciness.HOT);

        plain.describe();
        greenChile.describe();
        jalapeno.describe();
    }
}
