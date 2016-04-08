package com.fenghui.commons.logging;


import java.util.Map;

import org.slf4j.MDC;

/**
 * A wrapper around the logger's {@link MDC} which provides support for:
 * <ol>
 * <li>Supports setting up request meta-data for the main thread.</li>
 * <li>Supports forwarding the meta-data to the worker threads</li>
 * <li>Supports cleaning up the MDC on each thread as it completes (to avoid spill-over or memory leaks).</li>
 * </ol>
 * <p>
 */
public final class LoggingContext
{
	/**
	 * Private Default Constructor.
	 */
	private LoggingContext()
	{
	}

	/**
	 * Adds MDCKey entry.
	 * 
	 * @param key
	 *            - MDC key.
	 * @param value
	 *            - MDC key value.
	 */
	public static void put(MDCKey key, String value)
	{
		if (key == null) throw new NullPointerException("key");
		if (value == null)
		{
			remove(key);
			return;
		}
		MDC.put(key.toString(), value);
	}

	/**
	 * Removes MDCKey entry matching with key value.
	 * 
	 * @param key
	 *            - MDC key.
	 */
	public static void remove(MDCKey key)
	{
		if (key == null) throw new NullPointerException("key");
		MDC.remove(key.toString());
	}

	/**
	 * Clears entire key entries from MDC.
	 */
	public static void clear()
	{
		MDC.clear();
	}

	/**
	 * Sets the local context on a worker thread before it begins.
	 * <p>
	 * 
	 * @param localContext
	 *            the local MDC context from the parent thread.
	 */
	public static void set(Map<String, String> localContext)
	{
		if (localContext == null) throw new NullPointerException("localContext");
		clear();
		for (Map.Entry<String, String> entry : localContext.entrySet())
		{
			MDC.put(entry.getKey(), entry.getValue());
		}
	}
}
