package com.change.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * User: changejava
 * Date: 13-10-11
 * Time: 上午12:05
 */
public class InetAddressTest {


    public static final String HOST="time-A.timefreq.bldrdoc.gov";
    public static void main(String[] arg) throws UnknownHostException {
        if (arg.length>0){
            InetAddress[] ias = InetAddress.getAllByName(HOST);
            for (InetAddress ia : ias) {
                System.out.println(ia);
            }
        }  else {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        }
    }
}
