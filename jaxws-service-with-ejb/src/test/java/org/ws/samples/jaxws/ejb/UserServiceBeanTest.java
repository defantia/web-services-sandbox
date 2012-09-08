package org.ws.samples.jaxws.ejb;

import static org.fest.assertions.Assertions.assertThat;

import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceBeanTest {

	private static UserService userService;

	@BeforeClass
	public static void setUpClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.openejb.client.LocalInitialContextFactory");
		properties.setProperty("openejb.embedded.remotable", "true");

		new InitialContext(properties);

		Service service = Service
				.create(new URL(
						"http://127.0.0.1:4204/jaxws-service-with-ejb/UserServiceBean?wsdl"),
						new QName("http://ejb.jaxws.samples.ws.org",
								"UserService"));
		userService = service.getPort(UserService.class);
	}

	@Test
	public void testGetUserByName() throws Exception {
		// given
		String userName = "GOSLING";

		// when
		User user = userService.getUserByName(userName);

		// then
		assertThat(user).isNotNull();
		assertThat(user.getName()).isEqualTo(userName);
	}

	@Test
	public void testGetUsers() throws Exception {
		// given

		// when
		List<User> users = userService.getUsers();

		// then
		assertThat(users).isNotNull().hasSize(2);
	}

}
