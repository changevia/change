package com.change.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.EventListener;

import static com.change.swing.CheckBoxTest.showActivity;

/**
 * User: changejava
 * Date: 13-12-7
 * Time: 下午10:03
 */
public class MyChangeListener implements ChangeListener, Listener {

    Object item = null;
    @Override
    public void stateChanged(ChangeEvent e) {
        stackTrace(e);
    }

    private void stackTrace(ChangeEvent e) {
        this.item  =  e.getSource();
        Object source = e.getSource();
        if (source instanceof AbstractButton) {
            AbstractButton ab = (AbstractButton) source;
            showActivity(ab, "MyChangeListener");
        }
    }

    @Override
    public EventListener getEvent() {
        return null;
    }

    @Override
    public Object getSource() {
        return item;
    }

    @Override
    public void afterSettings() {
         if(item!=null && activitied){

         }
    }

    @Override
    public boolean isActivitied() {
        return activitied;
    }

    @Override
    public void setActivitied(boolean activitied) {
        this.activitied =activitied;
    }

    boolean activitied = false;
}
