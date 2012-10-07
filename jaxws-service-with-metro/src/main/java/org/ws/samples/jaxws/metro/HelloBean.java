package org.ws.samples.jaxws.metro;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloBean {

	@WebMethod
	public String hello(String name) {
		return "Hello " + name;
	}
}