package com.change.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * User: changejava
 * Date: 13-10-10
 * Time: 下午10:44
 */
public class TimeCheckerSocketTest {


    public static void main(String[] arg) {
        Socket capture = null;
        try {
            capture = new Socket("time-A.timefreq.bldrdoc.gov", 13);
            InputStream is = capture.getInputStream();
            Scanner line = new Scanner(is);
            while (line.hasNextLine()) {
                String lineStr = line.nextLine();
                System.out.println(lineStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (capture != null) {
                try {
                    capture.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
