package com.change.file;

import java.io.Serializable;

/**
 * User: changejava
 * Date: 13-9-8
 * Time: 下午10:11
 */
public class Address implements Serializable {
    String street;
    String country;

    public Address(String street, String country) {
        this.street = street;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
