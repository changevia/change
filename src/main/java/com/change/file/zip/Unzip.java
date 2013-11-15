package com.change.file.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.change.file.FileOperation.release;
import static com.change.file.FileUtils.exists;
import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-9
 * Time: 上午9:35
 */
public class Unzip {


    public static void main(String[] args) {
        Unzip unzip = new Unzip();
        unzip.unzip("D:\\filetest\\dest\\all.zip", "d:\\filetest\\dest\\zip\\");
    }

    public void unzip(String zipFile, String outputFolder) {
        exists(zipFile);
        File outFile = mkdirs(outputFolder);
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            FileOutputStream fos = null;
            try {
                ZipEntry tempEntry = null;
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((tempEntry = zis.getNextEntry()) != null) {
                    print(new File(tempEntry.getName()).getAbsoluteFile());
                    File newFile = new File(outFile + File.separator + tempEntry.getName());
                    new File(newFile.getParent()).mkdirs();
                    fos = new FileOutputStream(newFile);
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                    zis.closeEntry();
                    release(fos);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                release(zis);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private File mkdirs(String file) {
        if(!file.endsWith(File.separator)) file +=File.separator;
        File outFile = new File(file);
        if(!outFile.exists()) outFile.mkdirs();
        return outFile;
    }
}
