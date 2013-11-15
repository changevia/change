package com.change.file.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static com.change.file.FileOperation.release;
import static com.change.file.FileUtils.exists;
import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-8
 * Time: 下午10:33
 */
public class Zip {

     //Read a file “D:\filetest\dest\*” and compress it into a zip file – “D:\filetest\dest\1.zip“.
    public static void main(String[] args) {
//       makeFileToZip( new File("d://filetest//dest//1.xml"),new File("d://filetest//dest//1.zip"));
        makeDirectory2Zip(new File("D:\\filetest\\dest"), new File("d://filetest//dest//all.zip"), false);
    }
    public static void makeDirectory2Zip(File directory,File destZipFile,boolean deleted) {
        exists(directory);
//        exists(destZipFile);

        if (!directory.isDirectory()) return;

        File[] files = directory.listFiles();
        byte[] buffer = new byte[1024];

        ZipOutputStream zos = null;
        FileInputStream fis = null;
        try {
            zos = new ZipOutputStream(new FileOutputStream(destZipFile));
            for (File file : files) {
                try {
                    fis = new FileInputStream(file);
                    int len = 0;
                    ZipEntry entry = new ZipEntry(file.getName());
                    entry.setTime(System.currentTimeMillis());
                    zos.putNextEntry(entry);
                    print(new File(file.getName()).getAbsoluteFile());
                    while ((len = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                    zos.closeEntry();
                    zos.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            release(zos);
            release(fis);
        }
    }
    public static void makeFileToZip(File sourceFile,File destZipFile){
        ZipOutputStream zos = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destZipFile);

            zos = new ZipOutputStream(fos);
            zos.putNextEntry(new ZipEntry("1.xml"));

            int len = 0;
            byte[] buffer = new byte[1024];

            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            release(zos);
            release(fos);
            release(fis);
        }
    }
}
