package com.change.socket;


import com.change.java.util.Print;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * User: changejava
 * Date: 13-10-11
 * Time: 上午12:11
 */
public class EchoServer {


    public static void main(String[] arg) {

        ServerSocket s = null;
        Socket incoming = null;
        try {
            s = new ServerSocket(8189);
            incoming = s.accept();

            Scanner scanner = new Scanner(incoming.getInputStream());
            PrintWriter writer = new PrintWriter(incoming.getOutputStream(), true);

            writer.println("Hello,Type EXIT to quit ");
            boolean done = false;

            while (!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.println("Echo:" + line);
                if (null != line && "EXIT".equals(line.trim().toUpperCase()))
                    done = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (incoming != null) {
                try {
                    incoming.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
