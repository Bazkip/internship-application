package internship_application;

/**
 * Answer to the Fleets Coffee Internship Coding Challenge
 * 
 * @author Brett Zimmerman
 * @date 05/18/2023
 */
public class FleetsInternApp {

	public static void main(String[] args) {
		System.out.println("Input String 'hello':\t" + firstNonRepeated("hello"));
		System.out.println("Input String 'helloh':\t" + firstNonRepeated("helloh"));
		System.out.println("Input String 'aabcc':\t" + firstNonRepeated("aabcc"));
		System.out.println("Input String 'aabbcc':\t" + firstNonRepeated("aabbcc"));
		System.out.println("Input String 'aabbccd':\t" + firstNonRepeated("aabbccd"));
	}

	/**
	 * Checks a string for the first occurrence of a non-repeated character
	 * 
	 * @param s a String to look through
	 * @return a String representing the first non-repeated character, or an empty
	 *         String if there is none
	 */
	public static String firstNonRepeated(String s) {
		if (s == null || s.isBlank())
			return "";

		s = s.strip().toLowerCase();
		char c;

		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);

			/*
			 * Check through entire String for another instance of that character. This is
			 * somewhat inefficient, since we're repeatedly checking characters which would
			 * have already been checked, but if we only check from a given character
			 * forwards, then we would falsely mark the last instance of a repeated
			 * character as a non-repeat.
			 * 
			 * We could instead store the indexes of repeated characters to skip over in
			 * future passes, but keeping those stored in memory and repeatedly checking
			 * them may not even be more efficient.
			 */
			for (int j = 0; j < s.length(); j++) {
				if (i != j && c == s.charAt(j))
					break;
				else if (j + 1 == s.length()) // if we've reached the end of the string, then we've found a
												// non-repeated character
					return String.valueOf(c);
			}
		}

		return ""; // if we get here, then no non-repeated characters were found
	}
}
