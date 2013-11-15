package com.javadb.ws.example;

import javax.jws.HandlerChain;
import javax.jws.WebService;

/**
 * User: changejava
 * Date: 13-8-7
 * Time: 下午4:49
 */
@WebService()
@HandlerChain(file = "com/javadb/ws/example/handlers.xml")
public class ExampleService {

//    @Resource
//    private WebServiceContext context;

    public int add (int a,int b){
//        System.out.println(context);
        return a+b;
    }
}
