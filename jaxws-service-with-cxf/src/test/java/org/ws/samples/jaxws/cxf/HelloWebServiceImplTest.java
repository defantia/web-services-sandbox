package org.ws.samples.jaxws.cxf;

import static org.fest.assertions.Assertions.assertThat;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Simple JUnit test of HelloWebService.
 */
public class HelloWebServiceImplTest {

	private static String ADDRESS = "http://localhost:9090/unittest";

    /**
     * Start and expose webservice in the unit test
     * @throws Exception
     */
    @BeforeClass
	public static void startServer() throws Exception {
		HelloWebServiceImpl server = new HelloWebServiceImpl();
		Endpoint.publish(ADDRESS, server);
	}

    /**
     * Create a client using CXF
     * @return webservice client
     */
	private HelloWebService createCXFClient() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloWebService.class);
		factory.setAddress(ADDRESS);
		return (HelloWebService) factory.create();
	}

	@Test
	public void testHello() throws Exception {
		// given
		HelloWebService client = createCXFClient();

		// when
		String out = client.hello("Jean");

		// then
		assertThat(out).isNotNull().isEqualTo("Hello Jean");
	}
}
