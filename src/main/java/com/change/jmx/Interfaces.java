package com.change.jmx;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: changejava
 * Date: 13-8-25
 * Time: 下午9:48
 */
public class Interfaces {

    private MBeanServer mBeanServer;
    private HtmlAdaptorServer htmlAdaptor;
    private JMXServiceURL serviceURL = null;
    private String nodeName = null;
    private List interfaces = new ArrayList();

    public void createHttpAdaptor() {
        htmlAdaptor = new HtmlAdaptorServer();
        ObjectName htmlAdaptorON = null;

        try {
            htmlAdaptorON = new ObjectName("HttpAdaptor:name=HtmlAdatpor");
            mBeanServer.registerMBean(htmlAdaptor, htmlAdaptorON);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        }

        htmlAdaptor.setPort(Constants.JMX_HTTP_PORT);

        Constants.echo("Start HtmlAdaptor Port On..." + htmlAdaptor.getPort());
        htmlAdaptor.start();
    }

    public void addManagedInterface(Object ifc, String emsdn) {
        try {
            ObjectName objectName = new ObjectName(Constants.JMX_DOMAIN + ":name=" + emsdn);
            mBeanServer.registerMBean(ifc, objectName);
            interfaces.add(ifc);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }

    public void createJMXConnectServer() {
        Runnable r = new Runnable() {
            @Override
            public void run() {

                try {
                    serviceURL = new JMXServiceURL(Constants.JMXMP_PROTOCAL, Constants.getHostName(),
                            Constants.SYSTEM_PROPERTY_JMXMP_PORT);
                    JMXConnectorServer server = JMXConnectorServerFactory.
                            newJMXConnectorServer(serviceURL, null, mBeanServer);

                    Constants.echo(serviceURL);
                    server.start();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        new Thread(r).start();
    }

    public void start() {
//        mBeanServer = MBeanServerFactory.createMBeanServer(Constants.JMX_DOMAIN);
        mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ArrayList<MBeanServer> servers = MBeanServerFactory.findMBeanServer(null);
        for (MBeanServer server : servers) {
            Constants.echo("Found MBeanServer with default domain :" + server.getDefaultDomain());
        }
        nodeName = Constants.getHostName();
        Constants.echo(nodeName);
        createJMXConnectServer();
        createHttpAdaptor();
        addManagedInterface(new Hello(), Constants.JMX_INTERFACES_EMSDN);

        try {
            bind(Constants.JMX_DOMAIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bind(String domainName) throws Exception {
        JSSupportMBean jsSupport = new JSSupport();
        ObjectName ifcON = new ObjectName(domainName + ":name=JSSupport");
        for (MBeanServer server : MBeanServerFactory.findMBeanServer(null)) {
           if(server.getDefaultDomain().equals(domainName)){
               server.registerMBean(jsSupport,ifcON);
           }
        }

    }

    public static class InterfaceStart implements Runnable {

        private Interfaces interfaces = null;

        public InterfaceStart(Interfaces interfaces) {
            this.interfaces = interfaces;
        }

        @Override
        public void run() {
            interfaces.start();
        }
    }

    public static void main(String[] args) {

        Interfaces interfaces = new Interfaces();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 200, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        pool.execute(new InterfaceStart(interfaces));
    }
}
