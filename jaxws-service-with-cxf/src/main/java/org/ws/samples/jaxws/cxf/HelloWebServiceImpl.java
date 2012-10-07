package org.ws.samples.jaxws.cxf;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService(endpointInterface = "org.ws.samples.jaxws.cxf.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

	@Override
	public String hello(String name) {
		return "Hello " + name;
	}
}