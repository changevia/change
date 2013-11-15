package com.change.jmx;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * User: changejava
 * Date: 13-8-25
 * Time: 上午10:37
 */
public class BaseClient {

    public static void main(String[] args) throws IOException, MalformedObjectNameException, InstanceNotFoundException {

        String serviceURL = "service:jmx:rmi:///jndi/rmi://:9999/jmxrmi";
        JMXServiceURL url = new JMXServiceURL(serviceURL);
        JMXConnector connect = JMXConnectorFactory.connect(url);

        ClientListener listener = new ClientListener();
        MBeanServerConnection mbsc = connect.getMBeanServerConnection();
        waitForEnterPressed();

        String[] domains = mbsc.getDomains();
        Arrays.sort(domains);
        for (String domain : domains) {
            echo("domain = " +  domain);
        }
        waitForEnterPressed();
        echo(mbsc.getDefaultDomain());
        echo(mbsc.getMBeanCount());

        Set<ObjectName> names = new TreeSet<ObjectName>
                (mbsc.queryNames(null, null));

        for (ObjectName name : names) {
            echo("\t ObjectName  = " +  name);
        }

        waitForEnterPressed();

        ObjectName helloMbean = new ObjectName(Constants.JMX_DOMAIN+":name="+Constants.JMX_INTERFACES_EMSDN +",number=1");

        HelloMBean helloProxy = JMX.newMXBeanProxy(mbsc, helloMbean, HelloMBean.class, true);
        mbsc.addNotificationListener(helloMbean,listener,null,null);

        echo("\nCacheSize = " + helloProxy.getCacheSize());
        helloProxy.setCacheSize(11);

        waitForEnterPressed();
        sheep(2000);

        echo("\nCacheSize = " + helloProxy.getCacheSize());

        helloProxy.sayHello();

        connect.close();
    }

    private static void sheep(int longMillis) {
        try {
            Thread.sleep(longMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitForEnterPressed() {
        try {
            echo("\nPress <Enter> to continue...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void echo (Object objStr){
        System.out.println(objStr);
    }

    public static class ClientListener implements NotificationListener{

        @Override
        public void handleNotification(Notification notification, Object handback) {
            echo(notification.getClass().getName());
            echo(notification.getSource());
            echo(notification);
            if(notification!=null && notification instanceof AttributeChangeNotification){
                AttributeChangeNotification acn = (AttributeChangeNotification) notification;
                echo(acn.getAttributeName());
                echo(acn.getAttributeType());
                echo(acn.getNewValue());
                echo(acn.getOldValue());
            }
        }
    }
}
