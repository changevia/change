package com.change.jmx;

/**
 * User: changejava
 * Date: 13-8-23
 * Time: 下午4:23
 */
public interface HelloMBean {

    public void sayHello();
    public int add(int x, int y);

    public String getName();

    public int getCacheSize();
    public void setCacheSize(int size);
}
