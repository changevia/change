package com.change.file;

import java.io.*;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-5
 * Time: 下午1:23
 */
public class CopyFile {

    public static void main(String[] args) throws IOException {

        String sourceFile = "D:\\test\\output.xml";
        String destFile = "D:\\test\\desoutput.xml";

        FileInputStream in = new FileInputStream(sourceFile);
        FileOutputStream out = new FileOutputStream(destFile);
        int length = 0;
        byte[] buffer = new byte[1024];

        while ((length = in.read(buffer)) > -1) {
            out.write(buffer, 0, length);
        }

        in.close();
        out.close();


        File file = new File(destFile);
        File newFile = new File("D:\\test\\desoutputrenameto.xml");
        if (file.renameTo(newFile)) {
            System.out.println(newFile);
        } else {
            System.err.println("Rename File" + file + "  fail!!!");
        }

        File createFile = new File("d:\\test" + File.separator + "create.bak");
        if (createFile.createNewFile()) {
            System.out.println("createNewFile " + createFile + " success!");
        } else {
            System.err.println("createNewFile File " + createFile + "  fail!!!");
        }

        File folder = new File("d:/test");


        print(folder.getAbsoluteFile());

    }


}
