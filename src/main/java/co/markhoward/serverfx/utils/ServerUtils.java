package co.markhoward.serverfx.utils;

public class ServerUtils {
	
	/**
	 * Returns the int value of the passed string
	 * @param value The string to parse
	 * @param defaultValue If there is a problem parsing the string
	 * @return The value
	 */
	public static int toInt(final String value, final int defaultValue){
		try{
			return Integer.valueOf(value);
		}
		catch(NumberFormatException exception){
			return defaultValue;
		}
	}
}
