package com.fenghui.commons.logging;

import static com.fenghui.commons.logging.MDCKey.APP_NAME;
import static com.fenghui.commons.logging.MDCKey.CLIENT_TAG;
import static com.fenghui.commons.logging.MDCKey.GW_REQUEST_TRIPLET;
import static com.fenghui.commons.logging.MDCKey.HOSTNAME;
import static com.fenghui.commons.logging.MDCKey.IP;
import static com.fenghui.commons.logging.MDCKey.REQUEST_ID;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletFilter for setting the logback Mapped Diagnostic Context. This filter sets the values:
 * 
 * requestid - a universally unique id (guid) hostname - the name of this host appname - the name of the webapp corresponding to this
 * filter. The value of appname is retrieved from the filter configuration parameter with key "app_name". Note, if there are more than one
 * webapp in a container, then this filter should be mapped to each corresponding webapp, with an appropriate appname.
 */
public class LogContextFilter implements Filter
{
	private volatile String appName;
	private volatile String hostname;
	protected org.slf4j.Logger logger = Logger.getLogger(LogContextFilter.class);

	/**
	 * Called by web(service) container to indicate to a filter that it is being taken out of service.
	 */
	@Override
	public void destroy()
	{
		LoggingContext.clear();
	}

	/**
	 * Called by the web(service) container each time a request/response pair is passed through the chain due to client request for a
	 * resource at the end of the chain.
	 * 
	 * @param theRequest
	 *            - Service Request Object.
	 * @param theResponse
	 *            - Service Response Object.
	 * @param theChain
	 *            - filter Chain Object.
	 * @throws IOException
	 *             - Exception accessing from Input Stream
	 * @throws ServletException
	 *             - Exception in Filter Servlet.
	 */
	@Override
	public void doFilter(ServletRequest theRequest, ServletResponse theResponse, FilterChain theChain) throws IOException, ServletException
	{
		final String requestId = getUniqueID();
		final String triplet = String.format("%s:%s:%s", hostname, appName, requestId);

		LoggingContext.put(HOSTNAME, hostname);
		LoggingContext.put(REQUEST_ID, requestId);
		LoggingContext.put(APP_NAME, appName);
		LoggingContext.put(GW_REQUEST_TRIPLET, triplet);

		final HttpServletRequest req = (HttpServletRequest) theRequest;
		final HttpServletResponse resp = (HttpServletResponse) theResponse;

		resp.setHeader(GW_REQUEST_TRIPLET.toString(), triplet);

		String tag = req.getParameter("tag");
		if (tag != null)
		{
			LoggingContext.put(CLIENT_TAG, tag);
		}

		final String ip = req.getRemoteAddr() == null ? "?" : req.getRemoteAddr();
		LoggingContext.put(IP, ip);

		try
		{
			theChain.doFilter(theRequest, theResponse);
		}
		catch (ServletException servletException)
		{
			throw servletException;
		}
		finally
		{
			LoggingContext.clear();
		}
	}

	/**
	 * Called by the web(service) container to indicate to a filter that it is being placed into service.
	 * 
	 * Expects the filter parameter "app_name" to be set in the filter parameters.
	 * 
	 * @param theFilterConfig
	 *            - Filter configuration Object.
	 * @throws ServletException
	 *             - Exception in Filter Servlet.
	 */
	@Override
	public void init(FilterConfig theFilterConfig) throws ServletException
	{
		appName = theFilterConfig.getInitParameter(APP_NAME.toString());
		if (appName == null) throw new ServletException(String.format("Filter parameter %s must not be null.", APP_NAME));

		LoggingContext.put(APP_NAME, appName);

		try
		{
			hostname = InetAddress.getLocalHost().getCanonicalHostName();
			assert (hostname != null);
			StringTokenizer st = new StringTokenizer(hostname, ".");
			hostname = st.nextToken();
		}
		catch (UnknownHostException e)
		{
			throw new ServletException(e.getMessage(), e);
		}
		LoggingContext.put(HOSTNAME, hostname);
	}

	/**
	 * Generates universally unique id.
	 */
	private String getUniqueID()
	{
		return UUID.randomUUID().toString();
	}
}
