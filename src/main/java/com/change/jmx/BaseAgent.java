package com.change.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * User: changejava
 * Date: 13-8-23
 * Time: 下午4:28
 */
public class BaseAgent {


    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        System.out.println("\n\tCREATE, REGISTER a new Hello Standard_MBean:");

        HelloMBean mbean = new Hello();
        ObjectName hello_name  = new ObjectName(Constants.JMX_DOMAIN+":name=" +Constants.JMX_INTERFACES_EMSDN +",number=1");
        System.out.println("\tOBJECT NAME = " + hello_name);

        mBeanServer.registerMBean(mbean,hello_name);

        Thread.sleep(Long.MAX_VALUE);


    }
}
