package org.ws.samples.jaxws.metro;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.ws.samples.jaxws.metro.model.User;

@WebService
public interface UserService {

	@WebMethod(operationName = "getUserByLogin")
	@WebResult(name = "getUserResult")
	User getUserByLogin(@WebParam(name = "userLogin") final String login);

	@WebMethod(operationName = "getUsers")
	@WebResult(name = "getUsersResult")
	List<User> getUsers();
}
