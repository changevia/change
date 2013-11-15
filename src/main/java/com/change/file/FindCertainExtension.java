package com.change.file;

import java.io.File;
import java.io.FilenameFilter;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-7
 * Time: 下午1:25
 */
public class FindCertainExtension {

    public static final String FILE_DIR ="d:" + File.separator;

    public static final String FILE_EXT =".jpg";

    public static void main(String[] args) {
        FindCertainExtension extension = new FindCertainExtension();
        extension.listFile(FILE_DIR,FILE_EXT);
    }

    public void listFile(String fileDir,String ext){
        if(fileDir==null) return;
        File file = new File(fileDir);
        if(!file.exists()||!file.isDirectory())return;

        FilenameFilter filter = new GenericExtFilter(ext);

        String[] list = file.list(filter);

        if(null == list|| list.length<=0) return;

        for (String filePath : list) {
            String s = new StringBuffer(FILE_DIR + File.separator + filePath).toString();
            print(s);
        }


    }

    public class GenericExtFilter implements FilenameFilter {
        private String ext;

        public GenericExtFilter(String ext) {
            this.ext = ext;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }
}
