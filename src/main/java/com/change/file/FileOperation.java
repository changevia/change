package com.change.file;

import java.io.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

import static com.change.file.FileUtils.exists;
import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-9-7
 * Time: 下午4:36
 */
public class FileOperation {


    public static void main(String[] args) {
//        StringBuffer  sb = new StringBuffer("你好");
//        sb.append("\n"+"时间煮雨");
//        sb.append("\n"+"郁可唯");
//        File test = new File("d:/filetest/dest/2.xml");
////
////        FileOperation.writeFileUTF8(test,sb);
////        FileOperation.readFileUTF8(test);
//
//        FileOperation.readFileContentToJavaVarible(test);
////        FileOperation.getAvailableCharset();
//        print((int)'\n');
//
//        print(FileOperation.generateFileCheckSum(test));
//        print(FileOperation.checkFilecheckSum(test));
//
//        byte []  buffer =FileOperation.readFileContentToByte(test);
//        print(buffer);
//
//        FileOperation.writeFileFromByte(buffer);
//        test2();
//        getStringFromInputStream();
//        diskSpackDetail(new File("c:/"));
          createTempFile();
    }

    private static void createTempFile() {
        try {
            File temp = File.createTempFile("change", ".temp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void diskSpackDetail(File file) {
        exists(file);
        long totalSpace = file.getTotalSpace();
        long freeSpace = file.getFreeSpace();
        long usableSpace = file.getUsableSpace();

        String endStr = "mb";
        print("totalSpace Size :"+totalSpace/Math.pow(1024,2) + endStr);
        print("freeSpace Size :" +freeSpace/Math.pow(1024,2) + endStr);
        print("usableSpace Size :"+usableSpace/Math.pow(1024,2) +  endStr);
    }

    private static void getStringFromInputStream() {
        String str = "Hello World\n111111";

        InputStream is = new ByteArrayInputStream(str.getBytes());

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            File dest = new File("D://filetest/dest/temp.txt");
            if(!dest.exists()) dest.createNewFile();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest)));

            String line = "";
            try {
                while ((line=br.readLine())!=null){
                    print(line);
                    bw.write(line);
                }
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                release(br);
                release(bw);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void release(Writer writer) {
        try {
            if(writer!=null){
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        String str = "Hello World";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
        String line = "";
        try {
            while ((line=br.readLine())!=null){
               print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            release(br);
        }
    }

    private static void release(Reader br) {
        try {
            if(br!=null){
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFileFromByte(byte[] buffer) {
        File file = new File("d:/filetest/dest/change.txt");
        FileOutputStream fos = null;
        if (!file.exists()) try {
            file.createNewFile();
            fos = new FileOutputStream(file);
            fos.write(buffer);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            release(fos);
        }

    }

    public static void release(OutputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void release(InputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static byte[] readFileContentToByte(File test) {
        exists(test);
        FileInputStream fis = null;
        byte[] buffer = new byte[0];
        try {
            fis = new FileInputStream(test);
            buffer = new byte[(int) test.length()];
            fis.read(buffer);

            for (int i = 0; i < buffer.length; i++) {
                print((char) buffer[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }

    private static String checkFilecheckSum(File file) {
        exists(file);

        try {
            CheckedInputStream cis = new CheckedInputStream(new FileInputStream(file),new CRC32());
            byte[] buffer = new byte[1024];
            int reads = 0;
            while ((reads=cis.read(buffer))>=0){
            }
            long checksum = cis.getChecksum().getValue();
            print(checksum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String generateFileCheckSum(File test) {
        exists(test);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream fis = new FileInputStream(test);
            int  reads = 0;
            byte [] buffer = new byte[1024];
            while ((reads=fis.read(buffer))!=-1){
                md.update(buffer,0,reads);
            }

            byte[] mdBytes = md.digest();
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < mdBytes.length; i++) {
                sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            print(test.getAbsoluteFile()+" Digest(in hex format)::" + sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void readFileContentToJavaVarible(File test) {
        String varible = "";
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(test));
            byte[] avails = new byte[dataInputStream.available()];
            dataInputStream.readFully(avails);
            varible = new String(avails,0,avails.length);
            print(varible);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void getDefaultCharSet(){
        Charset charset = Charset.defaultCharset();
        print(charset);
    }
    private static void getAvailableCharset() {

        SortedMap<String,Charset> availSets = Charset.availableCharsets();
        for (String s : availSets.keySet()) {
            print(availSets.get(s));
        }
    }

    private static void readFileUTF8(File test) {
        BufferedReader br = null;
        exists(test);
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(test), defaultCharSet));
            String line ="";
            while ((line=br.readLine())!=null){
                print(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static Charset defaultCharSet = Charset.forName("UTF-8");
    public static void writeFileUTF8(File file, StringBuffer str){
        if(!file.exists()){
            try {
                if (file.createNewFile()){
                    BufferedWriter bw = null;
                    try {
                        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),defaultCharSet));
                        bw.write(str.toString());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if(bw!=null) try {
                            bw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            file.delete();
        }
    }
}
