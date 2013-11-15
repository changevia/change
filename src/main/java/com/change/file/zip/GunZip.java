package com.change.file.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import static com.change.file.FileOperation.release;
import static com.change.file.FileUtils.exists;

/**
 * User: changejava
 * Date: 13-9-9
 * Time: 下午3:17
 */
public class GunZip {
    public static void main(String[] args) {
        GunZip gunZip = new GunZip();
        gunZip.gunZip("D:\\filetest\\dest\\1.gz", "D:\\filetest\\dest\\temp\\1.txt");
    }

    private void gunZip(String source, String folder) {
        exists(source);
        File output = new File(folder);
        if (!output.exists()) {
            try {
                output.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos = null;
        GZIPInputStream gis = null;
        try {
            gis = new GZIPInputStream(new FileInputStream(source));
            fos = new FileOutputStream(new File(folder));
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = gis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            release(fos);
            release(gis);
        }
    }
}
