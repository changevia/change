package com.change.jmx;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * User: changejava
 * Date: 13-8-25
 * Time: 下午10:19
 */
public class MockClient {

    public static Object createJmxmpProxy(String emsdn, Class clazz) {
        try {
            JMXServiceURL serviceURL = new JMXServiceURL(Constants.JMXMP_PROTOCAL,Constants.getHostName(),Constants.SYSTEM_PROPERTY_JMXMP_PORT);
            JMXConnector cs = JMXConnectorFactory.connect(serviceURL);
            MBeanServerConnection msc = cs.getMBeanServerConnection();
            ObjectName  objectName = new ObjectName(Constants.JMX_DOMAIN +":name=" + emsdn);
            return JMX.newMBeanProxy(msc,objectName,clazz);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        HelloMBean helloMBean = (HelloMBean) createJmxmpProxy(Constants.JMX_INTERFACES_EMSDN, HelloMBean.class);
        helloMBean.sayHello();
        int add = helloMBean.add(10, 10);
        Constants.echo(add);
    }
}
