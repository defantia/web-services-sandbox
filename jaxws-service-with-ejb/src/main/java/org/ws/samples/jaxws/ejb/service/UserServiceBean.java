package org.ws.samples.jaxws.ejb.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import org.ws.samples.jaxws.ejb.model.User;

@Stateless
@WebService(serviceName = "UserService", portName = "UserServicePort", endpointInterface = "org.ws.samples.jaxws.ejb.service.UserService", targetNamespace = "http://service.ejb.jaxws.samples.ws.org")
public class UserServiceBean implements UserService {

	@Override
	public User getUserByName(String name) {
		User user = new User();
		user.setName(name);
		user.setSurname("John");

		return user;
	}

	@Override
	public List<User> getUsers() {
		User user1 = new User();
		user1.setName("WILLIS");
		user1.setSurname("Bruce");

		User user2 = new User();
		user2.setName("MALKOVICH");
		user2.setSurname("John");

		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);

		return users;
	}

}
