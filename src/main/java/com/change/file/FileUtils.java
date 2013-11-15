package com.change.file;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-7
 * Time: 下午2:21
 */
public class FileUtils {

    public static int TYPE_NPUT_STREAM = 0;
    public static int TYPE_ERROR_STREAM = 1;
    public static int type = 0;
    private static File fileLastModified;

    public static void getFileCreationDate(File file) throws IOException {
        exists(file);

        String cmdStr = "cmd /c dir " + file.getAbsoluteFile();
        print("excute command Str: " + cmdStr);
        Process exec = Runtime.getRuntime().exec(cmdStr);

        ReadCMDProcess readProcess = new ReadCMDProcess(exec, exec.getInputStream(), TYPE_NPUT_STREAM);
        readProcess.start();
    }

    public static void exists(File file) {
        if (!file.exists())
            throw new RuntimeException("md!! file is not exist");
    }

    public static void exists(String file) {
        exists(new File(file));
    }

    public static void main(String[] args) throws IOException {
//        FileUtils.getFileCreationDate(new File("D:\\filetest\\dest\\1.xml"));
//        FileUtils.getFileLastModified(new File("D:\\filetest\\dest\\1.xml"));
        FileUtils.setFileLastModified(new File("D:\\filetest\\dest\\1.xml"));
        print(FileUtils.setFileReadOnly(new File("D:\\filetest\\dest\\1.xml")));
        print(FileUtils.getFileWriteStatus(new File("D:\\filetest\\dest\\1.xml")));
        print(FileUtils.setFileWrite(new File("D:\\filetest\\dest\\1.xml")));
        print(FileUtils.getFileWriteStatus(new File("D:\\filetest\\dest\\1.xml")));
        print(FileUtils.getFileLength(new File("D:\\filetest\\dest\\1.xml")));
        print(FileUtils.getFileAbsolutePath(new File("D:\\filetest\\dest\\1.xml")));
        print(FileUtils.getFilePath(new File("D:\\filetest\\dest\\1.xml")));

        print(FileUtils.hidden(new File("D:\\filetest\\dest\\1.xml")));


    }

    private static String getFilePath(File file) {
        exists(file);
        return file.getAbsolutePath().substring(0,file.getAbsolutePath().lastIndexOf(File.separator));
    }

    public static boolean hidden(File file){
      exists(file);
      return file.isHidden();
    }
    private static String getFileAbsolutePath(File file) throws IOException {
        exists(file);
        return file.getAbsolutePath();
    }

    private static String getFileLength(File file) {
        exists(file);
        return file.length()/1024 + "KB";
    }

    public static void setFileLastModified(File file) {
        exists(file);
        String newModified = "2013-09-11 15:46:00";
        file.setLastModified(parse(newModified));
    }

    private static long parse(String newModified) {
        try {
            return sdf.parse(newModified).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean setFileReadOnly(File file) {
        exists(file);
        return file.setReadOnly();
    }

    public static boolean getFileWriteStatus(File file) {
        exists(file);
        return file.canWrite();
    }
    public static boolean setFileWrite(File file) {
        exists(file);
        return file.setWritable(true);
    }

    private static class ReadCMDProcess extends Thread {
        private final Process exec;
        private final InputStream inputStream;
        private final int type;

        public ReadCMDProcess(Process exec, InputStream inputStream, int type) {
            this.exec = exec;
            this.inputStream = inputStream;
            this.type = type;
        }

        @Override
        public void run() {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String line = "";
            StringBuffer totalStrBuffer = new StringBuffer();
            try {
                while ((line = br.readLine()) != null) {
                    totalStrBuffer.append(line + "\n");
                }
//                print(totalStrBuffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringTokenizer tokenizer = new StringTokenizer(totalStrBuffer.toString(), "\n");
            print(totalStrBuffer);
            Object[] elements = new Object[tokenizer.countTokens()];
            int index = 0;
            while (tokenizer.hasMoreTokens()) {
                String tempToken = tokenizer.nextToken();
                elements[index] = tempToken;
                if (index++ == 3) {
                    StringTokenizer st = new StringTokenizer(tempToken);
                    String date = st.nextToken();
                    String time = st.nextToken();
                    print("create Date :" + date);
                    print("create time :" + time);
                } else {
                    print(tempToken);
                }
            }
            print(Arrays.toString(elements));
        }
    }

    public static void getFileLastModified(File file) {
        exists(file);

        long millis = file.lastModified();
        print(format(millis));
    }

    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static String format(long millis) {
        return sdf.format(millis);
    }
}
