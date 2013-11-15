package com.change.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * User: changejava
 * Date: 13-8-19
 * Time: 下午3:56
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorld {

    @WebMethod String getHelloWorldAsString (String name);
}
