package com.change.file;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static com.change.java.util.Print.print;


/**
 * User: changejava
 * Date: 13-10-30
 * Time: 下午1:07
 */
public class ImageTest {

    private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;

    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File("D:/image/1.jpg"));
        int type  = originalImage.getType() ==0 ?BufferedImage.TYPE_INT_ARGB:originalImage.getType();
        byte b = 1;
        BufferedImage resizeImageJpg = resizeImage(originalImage, type);

        ImageIO.write(resizeImageJpg,"jpg",new File("d:/image/1_jpg.jpg"));

        BufferedImage resizeImagePng = resizeImage(originalImage, type);

        ImageIO.write(resizeImagePng,"png",new File("d:/image/1_png.png"));

        BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type);
        ImageIO.write(resizeImageHintJpg,"png",new File("d:/image/1_pnghint.png"));


//        JFrame frame = new JFrame("Test");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(new Dimension(500,450));
//
//        JButton button = new JButton(new ImageIcon(bi));
//        frame.add(button);
//        frame.setVisible(true);
//
////        ImageIO.write(bi,"png",new File("D:/image/1_bak.jpg"));
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ImageIO.write(bi,"jpg",bos);
//        byte[] bytes = bos.toByteArray();
//        print(Arrays.toString(bytes));
//        bos.close();
//
//        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//        BufferedImage image = ImageIO.read(bis);




    }

    private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        return resizedImage;
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
        BufferedImage bufferedImage = new BufferedImage(IMG_WIDTH,IMG_HEIGHT,type);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.drawImage(originalImage,0,0,IMG_WIDTH,IMG_HEIGHT,null);
        graphics.dispose();
        return bufferedImage;
    }
}
