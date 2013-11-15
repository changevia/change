package com.change.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * User: changejava
 * Date: 13-10-10
 * Time: 下午11:32
 */
public class TimeOutManual {


    public static void main(String[] arg) {

        Socket socket = new Socket();

        try {
            socket.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov",13));
            socket.setSoTimeout(10000);

            Scanner in = new Scanner(socket.getInputStream());
            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
