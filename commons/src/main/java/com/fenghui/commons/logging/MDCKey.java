package com.fenghui.commons.logging;


/**
 * Standard keys for our implementation of the logback MDC (Mapped Diagnostic Context).
 */
public enum MDCKey
{
	/** The name of this machine. Forms 1/3 of the {@link #GW_REQUEST_TRIPLET}. */
	HOSTNAME("hostname"),

	/**
	 * The unique value assigned to this particular request on this particular machine. Forms 1/3 of the {@link #GW_REQUEST_TRIPLET}.
	 */
	REQUEST_ID("request_id"),

	/**
	 * The name of this application running on this server. Forms 1/3 of the {@link #GW_REQUEST_TRIPLET}.
	 */
	APP_NAME("app_name"),

	/**
	 * An identifier for the visitor/user. Optional. This is expected to be a consistent user/client identifier, such as the device profile
	 * ID.
	 */
	USER_ID("user_id"),

	/**
	 * An identifier supplied by the client. Optional. The client can set this to any value if they wish, and it will be included in our
	 * logs. This is to support correlation of events across logs.
	 */
	CLIENT_TAG("tag"),

	/**
	 * The triplet of {@link #HOSTNAME}, {@link #REQUEST_ID}, and {@link #APP_NAME} which together forms a globally unique value for this
	 * request.
	 */
	GW_REQUEST_TRIPLET("requestId"),

	/**
	 * The Client's IP address.
	 */
	IP("ip");

	private final String key;

	private MDCKey(String name)
	{
		key = name;
	}

	@Override
	public String toString()
	{
		return key;
	}
}
