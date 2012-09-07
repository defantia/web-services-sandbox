package org.ws.samples.jaxws.cxf;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface UserService {

	@WebMethod(operationName = "getUserByName")
	@WebResult(name = "getUserResult")
	User getUserByName(@WebParam(name = "userName") String name);

	@WebMethod(operationName = "getUsers")
	@WebResult(name = "getUsersResult")
	List<User> getUsers();
}
