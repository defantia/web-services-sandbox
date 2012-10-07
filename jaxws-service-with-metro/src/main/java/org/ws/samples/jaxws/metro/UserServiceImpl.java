package org.ws.samples.jaxws.metro;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.ws.samples.jaxws.metro.model.User;

@WebService(endpointInterface = "org.ws.samples.jaxws.metro.UserService", serviceName = "UserWS")
public class UserServiceImpl implements UserService {

	@Override
	public User getUserByLogin(final String login) {
		User user = new User();
		user.setLogin(login);
		user.setFirstName("John");
		user.setLastName("SMITH");
		return user;
	}

	@Override
	public List<User> getUsers() {
		User user1 = new User();
		user1.setLogin("bwilis");
		user1.setFirstName("Bruce");
		user1.setLastName("WILLIS");

		User user2 = new User();
		user1.setLogin("jmalkovich");
		user2.setFirstName("John");
		user2.setLastName("MALKOVICH");

		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);

		return users;
	}

}
