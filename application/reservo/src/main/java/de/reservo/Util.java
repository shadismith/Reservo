package de.reservo;

public class Util {
	
	public static final String AUTHENTICATION_OBJECT = "authObj";
	
	public static boolean stringsNotEmpty(String ... pArgs) {
		for (String arg:pArgs) {
			if (arg == null || arg.isEmpty()) {
				return false;
			}
		}
		return true;
	}

}
