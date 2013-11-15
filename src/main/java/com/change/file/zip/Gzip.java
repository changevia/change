package com.change.file.zip;

import java.io.*;
import java.util.zip.GZIPOutputStream;

import static com.change.file.FileOperation.release;
import static com.change.file.FileUtils.exists;

/**
 * User: changejava
 * Date: 13-9-9
 * Time: 上午11:18
 */
public class Gzip {

    public static void main(String[] args) {
        Gzip gzip = new Gzip();
        gzip.gzip("D:\\filetest\\dest\\2.xml", "D:\\filetest\\dest\\1.gz");
    }


    public void gzip(String  file, String dest) {
        exists(file);
        FileInputStream fis = null;
        GZIPOutputStream gos = null;
        try {
            fis = new FileInputStream(new File(file));
            gos = new GZIPOutputStream(new FileOutputStream(new File(dest)));
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) > 0) {
                gos.write(buffer, 0, len);
            }
            gos.flush();
            gos.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            release(fis);
            release(gos);
        }
    }
}
