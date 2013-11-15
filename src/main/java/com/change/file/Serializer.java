package com.change.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

import static com.change.file.FileOperation.release;

/**
 * User: changejava
 * Date: 13-9-8
 * Time: 下午10:12
 */
public class Serializer {
    public static void main(String[] args) {
        Serializer serializer = new Serializer();
        serializer.serializeAddress("change1","China");
    }

    private void serializeAddress(String street, String country) {
        Address address = new Address(street, country);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        GZIPOutputStream gos = null;
        try {
            fos = new FileOutputStream("d:/filetest/dest/serialize.gz");
            gos = new GZIPOutputStream(fos);
            oos = new ObjectOutputStream(gos);
            oos.writeObject(address);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            release(gos);
            release(fos);
            release(oos);
        }
    }
}
