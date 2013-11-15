package com.change.jmx;

import javax.management.*;

/**
 * User: changejava
 * Date: 13-8-23
 * Time: 下午4:24
 */
public class Hello extends NotificationBroadcasterSupport implements HelloMBean {


    public Hello() {
    }

    public void sayHello() {
        System.out.println("hello, world");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public String getName() {
        return this.name;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] notifTypes = new String[]{AttributeChangeNotification.ATTRIBUTE_CHANGE};
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        Descriptor descriptor = null;
        MBeanNotificationInfo info = new MBeanNotificationInfo(notifTypes, name, description, descriptor);
        return new MBeanNotificationInfo[]{info};
    }


    public synchronized void setCacheSize(int size) {
        int oldSize = size;
        this.cacheSize = size;
        System.out.println("Cache size now " + this.cacheSize);
        fireSendNotification("setCacheSize", "cacheSize", "int", oldSize, this.cacheSize);
    }

    public synchronized void fireSendNotification(String msg, String attributeName, String attributeType, Object oldValue, Object newValue) {
        Notification notification = new AttributeChangeNotification(this, sequenceNumber++,
                System.currentTimeMillis(), msg, attributeName, attributeType, oldValue, newValue);
        sendNotification(notification);
    }

    private final String name = "Reginald";
    private int cacheSize = DEFAULT_CACHE_SIZE;
    private static final int
            DEFAULT_CACHE_SIZE = 200;
    private long sequenceNumber = 1;


    class MessageNotificationListener implements NotificationListener{

        @Override
        public void handleNotification(Notification notification, Object handback) {

        }
    }
}
