package com.change.jmx;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * User: changejava
 * Date: 13-8-25
 * Time: 下午6:38
 */
public class Constants {

    public static final String JMX_DOMAIN = "nmsifc";
    public static final String JMXMP_PROTOCAL = "jmxmp";
    public static final int SYSTEM_PROPERTY_JMXMP_PORT = 20001;
    public static final int JMX_HTTP_PORT = 20000;
    public static final String JMX_INTERFACES_EMSDN = "change";

    public static String getHostName() {
        String host = null;
        if (host == null)
            try {
                host = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        if (host != null)
            return host;
        return "localhost";
    }


    public static void echo(Object objStr) {
        System.out.println(objStr);
    }
}
