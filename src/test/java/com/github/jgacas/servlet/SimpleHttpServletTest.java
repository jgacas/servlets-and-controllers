package com.github.jgacas.servlet;

import static org.junit.Assert.*;

import org.eclipse.jetty.http.HttpTester;
import org.eclipse.jetty.servlet.ServletTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.jgacas.servlet.SimpleHttpServlet;

public class SimpleHttpServletTest {

	private ServletTester tester;
	
	@Before
	public void setUp() throws Exception {
		tester = new ServletTester();
		tester.setContextPath("/");
		tester.addServlet(SimpleHttpServlet.class, "/servlet/request");
		tester.start();
	}

	@After
	public void tearDown() throws Exception {
		tester.stop();
	}

	@Test
	public void shouldReturnCorrectHeading() throws Exception {
		HttpTester.Request request = new HttpTester.Request();
		request.setMethod("GET");
		request.setURI("/servlet/request");
		
		HttpTester.Response response = HttpTester.parseResponse(tester.getResponses(request.generate()));
		assertEquals(200, response.getStatus());
		assertTrue(response.getContent().contains("<h1>Servlet In Depth</h1>"));
	}

}
