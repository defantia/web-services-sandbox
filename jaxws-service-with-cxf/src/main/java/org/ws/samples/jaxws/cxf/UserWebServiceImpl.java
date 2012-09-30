package org.ws.samples.jaxws.cxf;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import org.ws.samples.jaxws.cxf.model.User;
import org.ws.samples.jaxws.cxf.service.UserService;

@WebService(endpointInterface = "org.ws.samples.jaxws.cxf.UserWebService", serviceName = "UserWS")
public class UserWebServiceImpl implements UserWebService {

	@Inject
	private UserService userService;

	@Override
	public User getUserByLogin(final String login) {
		return userService.getUserByLogin(login);
	}

	@Override
	public List<User> getUsers() {
		return userService.getUsers();
	}
}
