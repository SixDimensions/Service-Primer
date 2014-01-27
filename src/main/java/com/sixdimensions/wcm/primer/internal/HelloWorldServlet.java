package com.sixdimensions.wcm.primer.internal;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import com.sixdimensions.wcm.primer.HelloWorldService;

@SlingServlet(paths = { "/bin/hello" }, methods = { "GET" }, name = "com.sixdimensions.wcm.primer.internal.HelloWorldServlet")
public class HelloWorldServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -7038325607842954458L;

	@Reference
	private HelloWorldService helloWorldService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.sling.api.servlets.SlingSafeMethodsServlet#doGet(org.apache
	 * .sling.api.SlingHttpServletRequest,
	 * org.apache.sling.api.SlingHttpServletResponse)
	 */
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		response.getWriter().write(helloWorldService.sayHello());
	}
}
