package org.ws.samples.jaxws.ejb.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.ws.samples.jaxws.ejb.model.User;

public class UserServiceBeanTest {

        private static EJBContainer container;

	private UserService userService;

	@BeforeClass
	public static void startContainer() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("openejb.embedded.remotable", Boolean.TRUE.toString());

                container = EJBContainer.createEJBContainer(properties);
	}

	@Before
	public void setUp() throws Exception {
                URL url = new URL("http://127.0.0.1:4204/jaxws-service-with-ejb/UserServiceBean?wsdl");
                QName serviceQName = new QName("http://service.ejb.jaxws.samples.ws.org", "UserService");

		Service service = Service.create(url, serviceQName);
		userService = service.getPort(UserService.class);
	}

        @AfterClass
        public static void stopContainer() {
                if (container != null) {
                	container.close();
		}
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
