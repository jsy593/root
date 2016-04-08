package com.fenghui.restapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Application;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class RestAppServlet extends ServletContainer
{
	private static final long serialVersionUID = 1L;

	public RestAppServlet()
	{
	}

	public RestAppServlet(Class<? extends Application> appClass)
	{
		super(appClass);
	}

	public RestAppServlet(Application app)
	{
		super(app);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("I can do something before the service body.");

		super.service(request, response);
	}
}
