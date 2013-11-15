package com.ftp;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;

import java.io.File;

/**
 * User: changejava
 * Date: 13-9-4
 * Time: 上午11:18
 */
public class FtpServerMain {
    /**
     * @author ivan.hongyuming
     * // 启动FTP服务器
     * jimmy修改，放弃原有ftp服务器代码，使用apache的ftp服务器
     */
    public void initFtpService() {
        FtpServerFactory serverFactory = new FtpServerFactory();
        ListenerFactory factory = new ListenerFactory();
        factory.setPort(21);
        serverFactory.addListener("default", factory.createListener());
        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
        File file = new File("users.properties");
        userManagerFactory.setFile(file);
        userManagerFactory.setPasswordEncryptor(new ClearTextPasswordEncryptor());
        serverFactory.setUserManager(userManagerFactory.createUserManager());
        // start the server
        FtpServer server = serverFactory.createServer();
        try {
            server.start();
            System.out.println("ftpServer is start");
        } catch (FtpException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FtpServerMain().initFtpService();
    }
}
