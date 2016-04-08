package com.fenghui.commons.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.fenghui.commons.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Common utils.
 */
public final class Utils
{
	public static final String DATE_FORMAT_NOW = "yyyy/MM/dd HH:mm:ss";
	public static final String ZULU_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String ZULU_PATTERN_EXT = "yyyy-MM-dd'T'HH:mm:ss.sssssss'Z'";
	public static final String SIMPLE_DATE_PATTERN = "yyyy-MM-dd";
	public static final String SIMPLE_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final SimpleDateFormat UTC = new SimpleDateFormat(ZULU_PATTERN);
	public static final String NULL_STRING = "\u0000";
	public static final String EMPTY_STRING = "";
	private static final Long ONE_THOUSAND = 1000L;
	private static final String TIME_DELIMITER = "T";
	private static final String ZULU_DELIMITER = "Z";

	private static final Gson gsonSimpleDate = new GsonBuilder().setDateFormat(SIMPLE_DATE_PATTERN).create();

	private static final ObjectMapper mapper = new ObjectMapper();

	private static final String TRUE = "true";

	private static org.slf4j.Logger logger = Logger.getLogger(Utils.class);

	/**
	 * 型为“2013-12-06”的String转换为Date类型
	 * 
	 * @param str
	 * @return Date类型
	 * @throws ParseException
	 */
	public static Date getSimpleDatePatternFromString(String str) throws ParseException
	{
		SimpleDateFormat sim = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
		Date date = sim.parse(str);
		return date;
	}

	/**
	 * Converts a <code>Date</code> object into a string in 'Zulu' format.
	 * 
	 * @param d
	 *            A <code>Date</code> object to be converted into a string in
	 *            'Zulu' format
	 * @return A string representing the date contained in the passed
	 *         <code>Date</code> object in 'Zulu' format (e.g.
	 *         yyyy-MM-DDThh:mm:ssZ)
	 */
	public static String dateTimeToUTC(DateTime d)
	{
		return d.toString(DateTimeFormat.forPattern(ZULU_PATTERN));
	}

	/**
	 * Converts a <code>Date</code> object into a string in 'Zulu' format.
	 * 
	 * @param d
	 *            A <code>Date</code> object to be converted into a string in
	 *            'Zulu' format
	 * @return A string representing the date contained in the passed
	 *         <code>Date</code> object in 'Zulu' format (e.g.
	 *         yyyy-MM-DDThh:mm:ssZ)
	 */
	public static String dateToUTC(Date d)
	{
		DateTime dateTime = new DateTime(d);

		return dateTime.toString(DateTimeFormat.forPattern(ZULU_PATTERN));
	}

	/**
	 * Converts a <code>Date</code> object into a customized string format.
	 * 
	 * @param d
	 *            A <code>DateTime</code> object to be converted
	 * @param timeFormat
	 *            the customized string format, such as 'yyyy-MM-dd
	 *            HH:mm:ss.SSS'
	 * @return A string representing the date contained in the passed
	 *         <code>Date</code> object in customized string format
	 */
	public static String getDateTimeWithFormat(DateTime d, String timeFormat)
	{

		if (isNullOrEmpty(timeFormat))
			timeFormat = SIMPLE_DATE_PATTERN;

		return d.toString(DateTimeFormat.forPattern(timeFormat));
	}

	/**
	 * Converts a <code>Date</code> object into a customized string format.
	 * 
	 * @param d
	 *            A <code>Date</code> object to be converted
	 * @param timeFormat
	 *            the customized string format, such as 'yyyy-MM-dd
	 *            HH:mm:ss.SSS'
	 * @return A string representing the date contained in the passed
	 *         <code>Date</code> object in customized string format
	 */
	public static String getDateWithFormat(Date d, String timeFormat)
	{
		if (isNullOrEmpty(timeFormat))
			timeFormat = SIMPLE_DATE_PATTERN;

		DateTime dateTime = new DateTime(d);

		return dateTime.toString(DateTimeFormat.forPattern(timeFormat));
	}

	/**
	 * Converts a <code>Date</code> object into a string in 'Zulu' format.
	 * 
	 * @param d
	 *            A <code>Date</code> object to be converted into a string in
	 *            'Zulu' format
	 * @param t
	 *            timezone object
	 * @return A string representing the date contained in the passed
	 *         <code>DateTime</code> object in 'Zulu' format (e.g.
	 *         yyyy-MM-DDThh:mm:ssZ)
	 */
	public static String dateToUTC(DateTime d, TimeZone t)
	{
		return d.withZone(DateTimeZone.forTimeZone(t)).toString(DateTimeFormat.forPattern(ZULU_PATTERN));
	}

	/**
	 * Converts a <code>Date</code> object into a string in 'Zulu' format.
	 * 
	 * @param d
	 *            A <code>Date</code> object to be converted into a string in
	 *            'Zulu' format
	 * @param t
	 *            timezone object
	 * @return A string representing the date contained in the passed
	 *         <code>Date</code> object in 'Zulu' format (e.g.
	 *         yyyy-MM-DDThh:mm:ssZ)
	 */
	public static String dateToUTC(Date d, TimeZone t)
	{
		DateTime dateTime = new DateTime(d);

		return dateTime.withZone(DateTimeZone.forTimeZone(t)).toString(DateTimeFormat.forPattern(ZULU_PATTERN));
	}

	/**
	 * Converts a <code>Date</code> object into a string in 'Zulu' format.
	 * 
	 * @param d
	 *            A <code>Date</code> object to be converted into a string in
	 *            'Zulu' format
	 * @param t
	 *            timezone object
	 * @return A string representing the date contained in the passed
	 *         <code>Date</code> object in 'Zulu' format (e.g.
	 *         yyyy-MM-DDThh:mm:ss.SSSSSSSZ)
	 */
	public static String dateToUTCWithMS(Date d, TimeZone t)
	{
		DateTime dateTime = new DateTime(d);

		return dateTime.withZone(DateTimeZone.forTimeZone(t)).toString(DateTimeFormat.forPattern(ZULU_PATTERN_EXT));
	}

	/**
	 * Converts a <code>DateTime</code> object into a string in 'Zulu' format.
	 * 
	 * @param d
	 *            A <code>Date</code> object to be converted into a string in
	 *            'Zulu' format
	 * @param t
	 *            timezone object
	 * @return A string representing the date contained in the passed
	 *         <code>Date</code> object in 'Zulu' format (e.g.
	 *         yyyy-MM-DDThh:mm:ss.SSSSSSSZ)
	 */
	public static String dateTimeToUTCWithMS(DateTime d, TimeZone t)
	{
		return d.withZone(DateTimeZone.forTimeZone(t)).toString(DateTimeFormat.forPattern(ZULU_PATTERN_EXT));
	}

	/**
	 * Get a date from a string.
	 * 
	 * @param input
	 *            string with a date
	 * @return a DateTime
	 */
	public static DateTime getDateTimeFromString(String input)
	{
		DateTime dateTime = null;
		if (input != null && !input.isEmpty())
		{
			try
			{
				if (input.contains("?"))
					dateTime = DateTimeFormat.forPattern(SIMPLE_DATETIME_PATTERN)
							.parseDateTime(input.substring(0, 4).replace("?", "1") + "-01-01");
				else if (isNumeric(input))
					dateTime = DateTimeFormat.forPattern(SIMPLE_DATETIME_PATTERN)
							.parseDateTime(input.substring(0, 4) + "-01-01");
				// else if (input.contains(" ")) date =
				// FORMATTER.parse(input.replace(" ", "-"));
				else
					dateTime = DateTimeFormat.forPattern(SIMPLE_DATETIME_PATTERN).parseDateTime(input);
			}
			catch (IllegalArgumentException e)
			{
				logger.error("getDateTimeFromString returned an error {}.", e);
			}
		}

		return dateTime;
	}

	/**
	 * Get a date from a string.
	 * 
	 * @param input
	 *            string with a date
	 * @return a Date
	 */
	public static Date getDateFromString(String input)
	{
		if (input != null && !input.isEmpty())
		{
			try
			{
				DateTime dateTime = null;

				if (input.contains("?"))
					dateTime = DateTimeFormat.forPattern(SIMPLE_DATETIME_PATTERN)
							.parseDateTime(input.substring(0, 4).replace("?", "1") + "-01-01");
				else if (isNumeric(input))
					dateTime = DateTimeFormat.forPattern(SIMPLE_DATETIME_PATTERN)
							.parseDateTime(input.substring(0, 4) + "-01-01");
				// else if (input.contains(" ")) date =
				// FORMATTER.parse(input.replace(" ", "-"));
				else
					dateTime = DateTimeFormat.forPattern(SIMPLE_DATETIME_PATTERN).parseDateTime(input);

				return dateTime.toDate();
			}
			catch (IllegalArgumentException e)
			{
				logger.error("getDateFromString returned an error {}.", e);
			}
		}
		return null;
	}

	/**
	 * Get a UTC date from a date.
	 * 
	 * @param input
	 *            date with a date
	 * @return a Date
	 */
	public static Date getUtcDateFromDate(Date input)
	{

		Date date = null;
		try
		{
			String formattedString = new DateTime(input).withZone(DateTimeZone.UTC).toString(SIMPLE_DATETIME_PATTERN);

			date = DateTimeFormat.forPattern(SIMPLE_DATETIME_PATTERN).parseDateTime(formattedString).toDate();
		}
		catch (IllegalArgumentException e)
		{
			logger.error("getUtcDateFromDate returned an error {}.", e);
		}
		return date;
	}

	/**
	 * Get a UTC date from a string.
	 * 
	 * @param input
	 *            date with a date
	 * @return a Date
	 */
	public static DateTime getUtcDateTimeFromDateTime(DateTime input)
	{

		DateTime dateTime = null;

		try
		{
			String formattedString = input.withZone(DateTimeZone.UTC).toString(SIMPLE_DATETIME_PATTERN);

			dateTime = DateTimeFormat.forPattern(SIMPLE_DATETIME_PATTERN).parseDateTime(formattedString);
		}
		catch (IllegalArgumentException e)
		{
			logger.error("getUtcDateTimeFromDateTime returned an error {}.", e);
		}

		return dateTime;
	}

	/**
	 * Get a UTC date from a string.
	 * 
	 * @param input
	 *            string with a date
	 * @return a DateTime
	 */
	public static DateTime getUtcDateTimeFromString(String input)
	{

		if (input != null && !input.isEmpty())
		{
			try
			{
				if (input.contains("Z"))
				{
					return new DateTime(input.replace(" ", TIME_DELIMITER));
				}
				else
				{
					return new DateTime(input.replace(" ", TIME_DELIMITER) + ZULU_DELIMITER);
				}
			}
			catch (IllegalArgumentException e)
			{
				logger.error("getUtcDateTimeFromString returned an error {}.", e);
			}
		}

		return null;
	}

	/**
	 * Get a UTC date from a string.
	 * 
	 * @param input
	 *            string with a date
	 * @return a Date
	 */
	public static Date getUtcDateFromString(String input)
	{

		Date date = null;
		{
			try
			{
				DateTime dateTime = DateTimeFormat.forPattern(SIMPLE_DATETIME_PATTERN).withZone(DateTimeZone.UTC)
						.parseDateTime(input);
				date = dateTime.toDate();
			}
			catch (IllegalArgumentException e)
			{
				logger.error("getUtcDateTimeFromString returned an error {}.", e);
			}
		}

		return date;
	}

	/**
	 * @param enumType
	 *            the type of enum
	 * @param name
	 *            the name to get from the enum
	 * @param <T>
	 *            the type of enum
	 * @return the enum
	 */
	public static <T extends Enum<T>> T getEnumFromString(T enumType, String name)
	{
		if (enumType != null && name != null)
		{
			try
			{
				@SuppressWarnings("unchecked")
				Class<T> cl = (Class<T>) enumType.getClass();
				for (T option : cl.getEnumConstants())
				{
					if (option.toString().equalsIgnoreCase(name))
						return option;
				}
				// return Enum.valueOf(enumType, name.trim().toUpperCase());
			}
			catch (IllegalArgumentException ex)
			{
				return null;
			}
		}
		return null;
	}

	/**
	 * @param input
	 *            string with a date
	 * @return a unix date value
	 */
	/**
	 * @param input
	 *            The date string to be parsed.
	 * @return returns a long containing the unix date for the input string or 0
	 *         if the string couldn't be parsed.
	 */
	public static Long getUnixDate(String input)
	{
		if (input != null && !input.isEmpty())
		{
			try
			{
				DateTimeFormatter formatter = DateTimeFormat.forPattern("Y-MM-dd HH:mm:ss.sss");
				DateTime dateTime = null;

				if (input.contains("?"))
					dateTime = formatter.parseDateTime(input.substring(0, 4).replace("?", "1") + "-01-01");
				else if (isNumeric(input))
					dateTime = formatter.parseDateTime(input.substring(0, 4) + "-01-01");
				// else if (input.contains(" ")) date =
				// FORMATTER.parse(input.replace(" ", "-"));
				else
					dateTime = formatter.parseDateTime(input);

				return Long.valueOf(dateTime.getMillis() / ONE_THOUSAND);
			}
			catch (IllegalArgumentException e)
			{
				logger.error("getUnixDate returned an error {}.", e);
			}
		}

		return 0L;
	}

	/**
	 * Determines if the string is null or empty.
	 * 
	 * @param s
	 *            The string to test
	 * @return true if the string is null or empty.
	 */
	public static boolean isNullOrEmpty(String s)
	{
		return s == null || s.length() == 0;
	}

	/**
	 * Determines if the string is null or empty or just contains whitespace.
	 * 
	 * @param s
	 *            The string to test
	 * @return true if the string is null or empty or just contains whitespace.
	 */
	public static boolean isNullOrWhitespace(String s)
	{
		return s == null || s.length() == 0 || isWhitespace(s);
	}

	/**
	 * Tests whether the string contains only whitespace.
	 * 
	 * @param s
	 * @return true if the string contains only whitespace.
	 */
	private static boolean isWhitespace(String s)
	{
		int length = s.length();
		if (length > 0)
		{
			for (int i = 0; i < length; i++)
			{
				if (!Character.isWhitespace(s.charAt(i)))
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Converts a string to a mixed case string.
	 * 
	 * @param s
	 *            The string to convert to mixed case.
	 * @return A string that is mixed case.
	 */
	public static String toMixedCase(String s)
	{
		if (isNullOrWhitespace(s))
			return s;

		StringBuffer sb = new StringBuffer(s.length());
		boolean capitalizeNext = true;
		for (char c : s.toCharArray())
		{
			if (Character.isWhitespace(c) || !Character.isLetterOrDigit(c))
			{
				sb.append(c);
				capitalizeNext = true;
			}
			else if (capitalizeNext)
			{
				sb.append(Character.toTitleCase(c));
				capitalizeNext = false;
			}
			else
			{
				sb.append(Character.toLowerCase(c));
			}
		}

		return sb.toString();
	}

	/**
	 * @param s
	 *            string containing an number
	 * @return the int
	 */
	public static Integer intTryParse(String s)
	{
		try
		{
			if (isNumeric(s))
				return Integer.parseInt(s);
		}
		catch (NumberFormatException ex)
		{
			// Do nothing
		}

		return null;
	}

	/**
	 * Convert a string to a Long.
	 * 
	 * @param s
	 *            - A String containing the Long representation.
	 * @return - Long representation of the String. null if not a string or an
	 *         exception occurs.
	 */
	public static Long longTryParse(String s)
	{
		try
		{
			if (isNumeric(s))
				return Long.parseLong(s);
		}
		catch (NumberFormatException ex)
		{
			// Do nothing
		}

		return null;
	}

	/**
	 * @param s
	 *            string containing an number
	 * @return the float
	 */
	public static Float floatTryParse(String s)
	{
		try
		{
			if (isNumeric(s))
				return Float.parseFloat(s);
		}
		catch (NumberFormatException ex)
		{
			// Do nothing
		}

		return null;
	}

	/**
	 * @param s
	 *            string containing true or false
	 * @return the boolean
	 */
	public static Boolean booleanTryParse(String s)
	{
		if (s.equalsIgnoreCase(TRUE))
			return true;
		return false;
	}

	/**
	 * @param input
	 *            string
	 * @return if string is numeric value.
	 */
	public static boolean isNumeric(String input)
	{
		return input.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+");
	}

	/**
	 * @param input
	 *            string
	 * @return if string is Integer value.
	 */
	public static boolean isValidInteger(String input)
	{

		if (!isIntegerNumeric(input))
			return false;
		return isInIntegerRange(Double.parseDouble(input));

	}

	/**
	 * @param input
	 *            string
	 * @return if string is numeric value.
	 */
	public static boolean isIntegerNumeric(String input)
	{
		return input.matches("(-|\\+)?[0-9]+");
	}

	/**
	 * Tests whether the string contains a valid positive integer value.
	 * 
	 * @param input
	 *            The string to test.
	 * @return true if the string contains a valid positive integer value.
	 */
	public static boolean isValidPositiveInteger(String input)
	{
		return input != null && Utils.isValidInteger(input) && Utils.intTryParse(input) >= 0;
	}

	/**
	 * @param input
	 *            double
	 * @return if double in int range.
	 */
	public static boolean isInIntegerRange(double input)
	{
		return (input > Integer.MAX_VALUE || input < Integer.MIN_VALUE) ? false : true;
	}

	/**
	 * @return string with current time.
	 */
	public static String now()
	{
		DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT_NOW);
		return DateTime.now().toString(formatter);
	}

	/**
	 * @param input
	 *            string with a date value
	 * @return a string date parsed.
	 * @throws ParseException
	 */
	public static String parseDate(String input) throws ParseException
	{
		if (input != null && !input.isEmpty())
		{
			try
			{
				SimpleDateFormat dateFormat = new SimpleDateFormat(SIMPLE_DATETIME_PATTERN);
				Date date = null;
				if (input.contains("?"))
					date = dateFormat.parse(input.substring(0, 4).replace("?", "1") + "-01-01");
				else if (isNumeric(input))
					date = dateFormat.parse(input.substring(0, 4) + "-01-01");
				else if (input.contains(" "))
					date = dateFormat.parse(input.replace(" ", "-"));
				else
					date = dateFormat.parse(input);
				return dateToUTC(date);
			}
			catch (ParseException e)
			{
				logger.error("parseDate returned an error {}.", e);
				throw e;
			}
		}
		return input;
	}

	/**
	 * Parse delimited string into List<String>.
	 * 
	 * @param input
	 *            delimited string
	 * @param delimiter
	 *            the delimiter
	 * @return a List of Strings
	 */
	public static List<String> parseDelimitedString(String input, String delimiter)
	{
		List<String> list = new ArrayList<String>();
		if (input == null)
			return list;

		String[] ss = input.trim().split(delimiter);
		for (String s : ss)
		{
			if (s != null)
			{
				s = s.trim();
				if (!s.equals("") && !list.contains(s))
					list.add(s);
			}
		}
		return list;

	}

	/**
	 * 
	 * @param date1
	 *            date object to be added on
	 * @param years
	 *            years to add
	 * @param months
	 *            months to add
	 * @param days
	 *            days to add
	 * @param hours
	 *            hours to add
	 * @param minutes
	 *            minutest to add
	 * @param seconds
	 *            seconds to add
	 * @return date
	 */
	public static Date addDate(Date date1, int years, int months, int days, int hours, int minutes, int seconds)
	{
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		cal.setTime(date1);
		cal.add(Calendar.YEAR, years);
		cal.add(Calendar.MONTH, months);
		cal.add(Calendar.DATE, days);
		cal.add(Calendar.HOUR, hours);
		cal.add(Calendar.MINUTE, minutes);
		cal.add(Calendar.SECOND, seconds);
		return cal.getTime();
	}

	/**
	 * @param source
	 *            the source Boolean
	 * @param target
	 *            the target Boolean
	 * @return integer value. Value of -1 is source < target, value of zero if
	 *         equal, value of 1 of source > target.
	 */
	public static Integer compareBooleans(Boolean source, Boolean target)
	{
		if (source == null && target != null)
			return -1;
		if (source != null && target == null)
			return 1;
		if (source == null && target == null)
			return 0;

		try
		{
			return source.compareTo(target);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	/**
	 * @param source
	 *            the source Integer
	 * @param target
	 *            the target Integer
	 * @return integer value. Value of -1 is source < target, value of zero if
	 *         equal, value of 1 of source > target.
	 */
	public static Integer compareIntegers(Integer source, Integer target)
	{
		if (source == null && target != null)
			return -1;
		if (source != null && target == null)
			return 1;
		if (source == null && target == null)
			return 0;

		try
		{
			return source.compareTo(target);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	/**
	 * @param source
	 *            the source Long
	 * @param target
	 *            the target Long
	 * @return integer value. Value of -1 is source < target, value of zero if
	 *         equal, value of 1 of source > target.
	 */
	public static int compareLongs(Long source, Long target)
	{
		if (source == null && target != null)
			return -1;
		if (source != null && target == null)
			return 1;
		if (source == null && target == null)
			return 0;

		try
		{
			return source.compareTo(target);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	/**
	 * @param source
	 *            the source string
	 * @param target
	 *            the target string
	 * @return integer value. Value of -1 is source < target, value of zero if
	 *         equal, value of 1 of source > target.
	 */
	public static Integer compareStrings(String source, String target)
	{
		if (source == null && target != null)
			return -1;
		if (source != null && target == null)
			return 1;
		if (source == null && target == null)
			return 0;

		try
		{
			RuleBasedCollator collator = (RuleBasedCollator) Collator.getInstance(Locale.ENGLISH);
			String rules = collator.getRules().replace("<'\u005f'", "<' '<'\u005f'");
			return new RuleBasedCollator(rules).compare(source, target);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	/**
	 * @param source
	 *            the source string
	 * @param target
	 *            the target string
	 * @param ignoreQuotes
	 *            whether or not to ignore quotes
	 * @return integer value. Value of -1 is source < target, value of zero if
	 *         equal, value of 1 of source > target.
	 */
	public static Integer compareStrings(String source, String target, Boolean ignoreQuotes)
	{
		if (!ignoreQuotes)
			return compareStrings(source, target);

		if (source == null && target != null)
			return -1;
		if (source != null && target == null)
			return 1;
		if (source == null && target == null)
			return 0;

		try
		{
			RuleBasedCollator collator = (RuleBasedCollator) Collator.getInstance(Locale.ENGLISH);
			String rules = collator.getRules().replace("<'\u005f'", "<' '<'\u005f'");
			return new RuleBasedCollator(rules).compare(source.replace("'", ""), target.replace("'", ""));
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	/**
	 * Get the content of an element in an xml document.
	 * 
	 * @param pathname
	 *            pathname to the xml file.
	 * @param tagname
	 *            tagname to get from the document.
	 * @return String with the text content of the element.
	 * @throws SAXException
	 *             sax ex
	 * @throws IOException
	 *             io ex
	 * @throws ParserConfigurationException
	 *             pc ex
	 */
	public static String xmlGetTextContent(String pathname, String tagname)
			throws SAXException, IOException, ParserConfigurationException
	{
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(pathname));

		Node node = doc.getElementsByTagName(tagname).item(0);
		return node.getTextContent();
	}

	/**
	 * Set the content of an element in an xml document.
	 * 
	 * @param pathname
	 *            pathname to the xml file.
	 * @param tagname
	 *            tagname to set from the document.
	 * @param value
	 *            value to set into the element.
	 * @throws SAXException
	 *             sax ex
	 * @throws IOException
	 *             io ex
	 * @throws ParserConfigurationException
	 *             pc ex
	 * @throws TransformerException
	 *             t ex
	 */
	public static void xmlSetTextContent(String pathname, String tagname, String value)
			throws SAXException, IOException, ParserConfigurationException, TransformerException
	{
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(pathname));

		Node node = doc.getElementsByTagName(tagname).item(0);
		node.setTextContent(value);

		Transformer t = TransformerFactory.newInstance().newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");

		t.transform(new DOMSource(doc), new StreamResult(new File(pathname)));
	}

	/**
	 * Change Object to json String
	 */
	public static String objectToJsonByGson(Object o)
	{
		if (o == null)
			return null;

		return gsonSimpleDate.toJson(o);
	}

	/**
	 * Change Object to json String by Jackson
	 */
	public static String objectToJsonByJackson(Object o)
	{
		if (o == null)
			return null;

		try
		{
			String json = mapper.writeValueAsString(o);
			return json;
		}
		catch (JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Change Object to json String
	 */
	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	public static Object jsonToObjectByGson(String s, Class clazz)
	{
		if (!isGoodJson(s))
			return null;

		return (Object) gsonSimpleDate.fromJson(s, clazz);
	}

	/**
	 * Check the availibity of Json
	 */
	public static boolean isGoodJson(String json)
	{
		if (StringUtils.isBlank(json))
		{
			return false;
		}
		try
		{
			new JsonParser().parse(json);
			return true;
		}
		catch (JsonParseException e)
		{
			logger.error("bad json: " + json);
			return false;
		}
	}

	public static String getMD5Code(String originalValue)
	{
		byte[] source;
		try
		{
			source = originalValue.getBytes("UTF-8");
		}
		catch (UnsupportedEncodingException unsupportedEncodingException)
		{
			source = originalValue.getBytes();
		}
		String md5Value = null;
		char hexDigits[] =
		{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(source);

			byte temp[] = messageDigest.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++)
			{
				byte byte0 = temp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			md5Value = new String(str);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return md5Value;
	}

	private Utils()
	{
	}
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println(Utils.getSimpleDatePatternFromString("2015-12-23"));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}
