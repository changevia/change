package com.change;

import javax.jnlp.BasicService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * User: changejava
 * Date: 13-10-21
 * Time: 下午9:33
 */
public class TestJNLP {

    static BasicService basicService;

    public static void main(String[] arg) {

        JFrame frame = new JFrame("Change java Jnlp UnOfficial Guide");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container contentPane = frame.getContentPane();

        JLabel label = new JLabel();
        String message  ="change java Hello World ";
        label.setText(message);
        contentPane.add(label,BorderLayout.CENTER);

        try {
            basicService = (BasicService)
                    ServiceManager.lookup("javax.jnlp.BasicService");
        } catch (UnavailableServiceException e) {
            System.err.println("look up failed!!" + e.getMessage());
        }

        JButton button = new JButton("http://www.mkyong.com");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = new URL(e.getActionCommand());
                    basicService.showDocument(url);
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        contentPane.add(button,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.pack();
    }
}
