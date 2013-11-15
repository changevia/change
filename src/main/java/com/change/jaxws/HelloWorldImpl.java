package com.change.jaxws;

import javax.jws.WebService;

/**
 * User: changejava
 * Date: 13-8-19
 * Time: 下午3:58
 */
@WebService(endpointInterface = "com.change.jaxws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS "+  name;
    }
}
