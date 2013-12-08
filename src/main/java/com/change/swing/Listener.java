package com.change.swing;

import java.util.EventListener;

/**
 * User: changejava
 * Date: 13-12-7
 * Time: 下午10:04
 */
public interface Listener {
    abstract public EventListener getEvent();
    abstract public Object getSource();
    abstract public void afterSettings();
    abstract public boolean isActivitied();
    abstract public void setActivitied(boolean activitied);
}
