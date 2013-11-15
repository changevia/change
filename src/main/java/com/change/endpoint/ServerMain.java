package com.change.endpoint;

import com.change.jaxws.HelloWorldImpl;

import javax.xml.ws.Endpoint;

/**
 * User: changejava
 * Date: 13-8-19
 * Time: 下午3:59
 */
public class ServerMain {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
    }
}
