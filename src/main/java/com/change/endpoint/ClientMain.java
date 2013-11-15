package com.change.endpoint;

import com.change.jaxws.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

import static com.change.java.util.Print.print;

/**
 * User: changejava
 * Date: 13-8-19
 * Time: 下午4:00
 */
public class ClientMain {

    public static void main(String[] args) throws MalformedURLException {

        URL  url = new URL("http://localhost:8888/ws/hello?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qName = new QName("http://jaxws.change.com/","HelloWorldImplService");
        Service service = Service.create(url, qName);
        HelloWorld port = service.getPort(HelloWorld.class);

        print(port.getHelloWorldAsString("Change"));


    }
}
