package com.change;

import com.javadb.ws.example.client.ExampleServiceService;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
* User: changejava
* Date: 13-8-7
* Time: 下午5:00
*/
public class ClientMain {

    public static void main(String[] args) {

        ExampleServiceService service  =new ExampleServiceService();

        service.setHandlerResolver(new HandlerResolver() {
            @Override
            public List<Handler> getHandlerChain(PortInfo portInfo) {
                ArrayList<Handler> handlers = new ArrayList<Handler>();
                handlers.add(new SOAPHandler() {
                    @Override
                    public Set<QName> getHeaders() {
                        System.out.println("1111");
                        return null;
                    }

                    @Override
                    public boolean handleMessage(MessageContext context) {
                        System.out.println("1111");
                        return false;
                    }

                    @Override
                    public boolean handleFault(MessageContext context) {
                        System.out.println("1111");
                        return false;
                    }

                    @Override
                    public void close(MessageContext context) {
                        System.out.println("1111");
                    }
                });
                System.out.println("Get Handler Chain");
                return handlers;
            }
        });
        com.javadb.ws.example.client.ExampleService portType = service.getExampleServicePort();
        int add = portType.add(1, 1);
        System.out.println(add);
    }
}
