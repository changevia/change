package com.change.jmx;

/**
 * Author: Ronnie.Chen
 * Date: 13-2-20
 * Time: 下午3:18
 * rongrong.chen@alcatel-sbell.com.cn
 */
public interface JSSupportMBean {
    public String executeJS(String js) throws Exception;
    public String executeJSFile(String filePath) throws Exception;
    public String executeJSFunction(String js, String functionName) throws Exception ;
    public String executeJSFile(String filePath, String functionName) throws Exception ;
}
