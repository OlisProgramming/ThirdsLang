package com.thirds.lang;

public class Messages {

	/**
	 * 0 = show errors and info only<br>
	 * 1 = show warnings, error and info only<br>
	 * 2 = show all messages
	 */
	public static int MESSAGE_LEVEL = 3;
	
	public static void debug(String message) {
		if (MESSAGE_LEVEL > 1)
			System.out.println(" > " + message);
	}
	
	public static void info(String message) {
		System.out.println("INFO: " + message);
	}
	
	public static void warning(String message) {
		if (MESSAGE_LEVEL > 0)
			System.out.println("WARN: " + message);
	}
	
	public static void error(String message) {
		System.err.println("ERROR: " + message + "\n");
		new Exception().printStackTrace();
		System.exit(-1);
	}
}
