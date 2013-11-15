package com.change.file;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import static com.change.file.FileUtils.exists;
import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-8
 * Time: 下午10:23
 */
public class DeSerializer {
    public static void main(String[] args) {

        DeSerializer deSerializer = new DeSerializer();
        deSerializer.deSerializer();
    }

    private void deSerializer() {
        try {
            File file = new File("d://filetest/dest/serialize.gz");
            exists(file);
            FileInputStream fis = new FileInputStream(file);
            GZIPInputStream zis = new GZIPInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(zis);
            Object dest = ois.readObject();
            if(dest!=null){
                if(dest instanceof Address){
                    Address address = (Address) dest;
                    print(address);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
