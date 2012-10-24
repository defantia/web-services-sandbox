package org.ws.samples.jaxws.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWebService {

	@WebMethod
	String hello(@WebParam(name = "name") final String name);
}