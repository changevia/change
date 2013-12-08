package com.change.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: changejava
 * Date: 13-12-7
 * Time: 下午10:00
 */
public class SelectedCheckBox {


    public static void main(String[] args) {
        JFrame main = new JFrame("Select Box");

        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(new Dimension(100,100));

        ActionListener actionListener =new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton source = (AbstractButton) e.getSource();
                ButtonModel model = source.getModel();
                boolean selected = model.isSelected();
                String newLabel = selected ?"A":"B";
                source.setText(newLabel);
            }
        };


    }

}
