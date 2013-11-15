package com.change.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import static com.change.java.util.Print.print;



/**
 * User: changejava
 * Date: 13-10-26
 * Time: 下午6:08
 */
public class TestEncode {


    public static void main(String[] args) {
        String url = "<![CDATA[ <IMG SRC=\" &#14; javascript:document.vulnerable=true;\"> ]]>";
//        String url = "http://localhost:4848/common/index.jsf";

        String enc = "UTF-8";
        try {
            String encode = URLEncoder.encode(url, enc);

            print(encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            String decode = URLDecoder.decode(url, enc);
            print(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
