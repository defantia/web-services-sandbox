package org.ws.samples.jaxws.cxf.service;

import java.util.List;

import org.ws.samples.jaxws.cxf.model.User;

public interface UserService {

	User getUserByName(String name);

	List<User> getUsers();
}
