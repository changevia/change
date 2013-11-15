package com.change.jmx;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * User: changejava
 * Date: 13-8-25
 * Time: 下午8:09
 */
public class JmxHttpAdaptors {
    private MBeanServer  domain;
    private int port =8092;
    private String host ="localhost";

    public JmxHttpAdaptors(MBeanServer domain){
       this.domain =domain;
    }

    public void start() {
        ObjectName serverName = null;
        HtmlAdaptorServer adaptor = null;
        try {
            serverName = new ObjectName("Http:name=HttpAdaptor");
            adaptor = new HtmlAdaptorServer();
            domain.registerMBean(adaptor, serverName);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        }
        try {
            domain.setAttribute(serverName, new Attribute("Port", new Integer(port)));
        } catch (InstanceNotFoundException e) {
            e.printStackTrace();
        } catch (AttributeNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidAttributeValueException e) {
            e.printStackTrace();
        } catch (MBeanException e) {
            e.printStackTrace();
        } catch (ReflectionException e) {
            e.printStackTrace();
        }
        adaptor.setPort(port);
        System.out.println("Starting the HtmlAdaptor....on port:"+adaptor.getPort());
        adaptor.start();
    }

    public void registerManagerBean(Object interfaces,ObjectName objectName){
        try {
            getDomain().registerMBean(interfaces,objectName);
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException, MalformedObjectNameException {
        MBeanServer domain = ManagementFactory.getPlatformMBeanServer();
        JmxHttpAdaptors adaptors = new JmxHttpAdaptors(domain);

        HelloMBean  mock  = new Hello();
        //(Constants.JMX_DOMAIN+":name=Hello,number=1
        adaptors.registerManagerBean(mock,new ObjectName("nmsifc:name=change,number=1"));
        adaptors.start();
//        Thread.sleep(Long.MAX_VALUE);
    }

    public MBeanServer getDomain() {
        return domain;
    }

    public void setDomain(MBeanServer domain) {
        this.domain = domain;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
