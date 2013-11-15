package com.change.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * User: changejava
 * Date: 13-10-10
 * Time: 下午10:51
 */
public class BaiduHomePage {


    public static void main(String[] arg) {
        Socket capture = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            capture = new Socket("www.baidu.com", 80);
            os = capture.getOutputStream();
            String commandStr = "GET / HTTP/1.0";
            String enterStr ="\r\n";
            os.write(commandStr.getBytes());
            os.write(enterStr.getBytes());
            os.write(enterStr.getBytes());
            os.flush();
            is = capture.getInputStream();
            Scanner line = new Scanner(is);
            while (line.hasNextLine()) {
                String lineStr = line.nextLine();
                System.out.println(lineStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (capture != null) {
                try {
                    capture.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        System.out.println("Test\r\n ....\r.....\n");
        System.out.println("\r..Test\r..");
//        System.out.println("Test\n..");
    }
}
