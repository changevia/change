package com.change.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * User: changejava
 * Date: 13-12-7
 * Time: 下午6:37
 */
public class CheckBoxTest {


    public static void main(String[] args) {

        JFrame frame = new JFrame("Iconzing Test");
        frame.setUndecorated(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JCheckBox checkBox = new JCheckBox("Stuffed Crust");

        ChangeListener cl = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                AbstractButton ab = (AbstractButton) e.getSource();
                showActivity(ab,"ChangeListener");
            }
        };
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                AbstractButton source = (AbstractButton) e.getSource();
                showActivity(source,"addItemListener");
            }
        });
        checkBox.addChangeListener(cl);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf(" %s ", e.getSource().toString());
            }
        });
        frame.getContentPane().add(checkBox);
        frame.setSize(new Dimension(100,200));
        frame.setVisible(true);
    }

    public static void showActivity(AbstractButton ab,String flag) {
        ButtonModel bm = ab.getModel();
        boolean armed = bm.isArmed();
        boolean isSelected = bm.isSelected();
        boolean pressed = bm.isPressed();
        System.out.println(flag +" " + armed + "/" + pressed + "/" +
                isSelected);
    }
}
