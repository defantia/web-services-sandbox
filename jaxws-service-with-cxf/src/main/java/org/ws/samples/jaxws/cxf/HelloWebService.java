package org.ws.samples.jaxws.cxf;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWebService {

	@WebMethod
	String hello(final String name);
}