package com.change.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * User: changejava
 * Date: 13-12-7
 * Time: 下午9:55
 */
public class Main extends JFrame {

    JCheckBox checkBox = new JCheckBox("md!!",false);


    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Checked?" + checkBox.isSelected());
            }
        });
        getContentPane().add(checkBox);
        setSize(new Dimension(100,100));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}
