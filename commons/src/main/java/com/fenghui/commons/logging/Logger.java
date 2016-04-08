package com.fenghui.commons.logging;

import org.slf4j.LoggerFactory;

/**
 * Provides single access to SLF4J Logger.
 */
public final class Logger
{
	/**
	 * Private Default Constructor.
	 */
	private Logger()
	{
	}

	/**
	 * Gets the Logger instance.
	 * 
	 * @param c
	 *            Class passed for logger
	 * @return Logger Instance.
	 */
	public static org.slf4j.Logger getLogger(@SuppressWarnings("rawtypes") Class c)
	{
		return LoggerFactory.getLogger(c);
	}

	/**
	 * Gets the Logger instance.
	 * 
	 * @param name
	 *            Name of the logger.
	 * 
	 * @return Logger Instance.
	 */
	public static org.slf4j.Logger getLogger(String name)
	{
		return LoggerFactory.getLogger(name);
	}

	/**
	 * Logs any object passed as Info.
	 * 
	 * @param o
	 *            Object passed.
	 * @param clazz
	 *            Class reference.
	 */
	@SuppressWarnings("rawtypes")
	public static void log(Object o, Class clazz)
	{
		org.slf4j.Logger logger = LoggerFactory.getLogger(clazz);
		logger.info(o.toString());
	}
}
