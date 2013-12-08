package com.change.file;

import java.io.*;

import static com.change.file.FileUtils.exists;
import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-7
 * Time: 下午4:13
 */
public class LineNumberReaderExample {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\filetest\\dest\\1.xml");
        exists(file);
        print(LineNumberReaderExample.getFileLineCount(new FileInputStream(file)));



    }

    public static long getFileLineCount(InputStream in) {
        for (;;) {
            LineNumberReader lnr = new LineNumberReader(new InputStreamReader(in));
            int numberCount = 0;
            String line = "";
            try {
                while ((line = lnr.readLine()) != null) {
                    numberCount++;
                }
                print(line);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    lnr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            return numberCount;
        }
    }
}
