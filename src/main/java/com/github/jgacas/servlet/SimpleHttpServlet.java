package com.github.jgacas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleHttpServlet extends HttpServlet {

	/**
	 * Generated UID.
	 */
	private static final long serialVersionUID = -6459425250920004047L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Servlet In Depth</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
