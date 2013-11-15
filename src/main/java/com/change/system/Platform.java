package com.change.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-10-26
 * Time: 下午6:52
 */
public class Platform {

    static {
        InputStream is = Platform.class.getResourceAsStream("config.properties");
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(is);
            properties.list(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            properties.clear();
        }
    }

    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        print(os);

        if (isWindows(os)) {
            System.out.println(" This is Window");
        } else if (isLinux(os)) {
            System.out.println(" This is isLinux");
        } else if (isUnix(os)) {
            System.out.println(" This is isUnix");
        } else if (isMac(os)) {
            System.out.println(" This is isMac");
        } else if (isSolaris(os)) {
            System.out.println(" This is isSolaris");
        }


    }

    private static boolean isSolaris(String os) {
        return (os.indexOf("sunos") >= 0);
    }


    private static boolean isMac(String os) {
        return (os.indexOf("mac") >= 0);
    }

    private static boolean isUnix(String os) {
        return isLinux(os);
    }

    private static boolean isLinux(String os) {
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0);
    }

    private static boolean isWindows(String os) {
        return os.indexOf("win") >= 0;
    }


}
