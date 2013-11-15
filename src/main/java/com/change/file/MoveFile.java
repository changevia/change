package com.change.file;

import java.io.File;
import java.io.FileNotFoundException;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-7
 * Time: 下午1:43
 */
public class MoveFile {

    public static void main(String[] args) {
       MoveFile runner = new MoveFile();
       runner.move("d:/filetest/output.xml","d:/filetest/dest/1.xml","");
//        runner.move("","","");
    }
    private void move(String sourceFile,String destFile,String rename){
        if (isBlank(sourceFile) || isBlank(destFile))
            throw new RuntimeException("Source or Destination is not null");


        File source = new File(sourceFile);
        File dest = new File(destFile);

        if(!source.exists())
            throw new RuntimeException("md!!Source is not found!!!");
        if(dest.isDirectory()) return;

        if(!isBlank(rename)){  // if given rename use it ,not use orginal file name
            File tempFile = new File(new StringBuffer(dest.getAbsolutePath()+
                                File.separator + rename).toString());
            executeRename(source, tempFile);
            return;
        }
        executeRename(source,dest);

    }

    private void executeRename(File source, File tempFile) {
        if(source.renameTo(tempFile)){
            print("sourceFile: " + source + ",move to another destination File:"+ tempFile);
        } else {
            print("md!!! MOVE: " + source + " Failed!!!");
        }
    }

    public static boolean isBlank(String str){
        return null==str || "".equals(str.trim());
    }
}
