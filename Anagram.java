import java.lang.foreign.FunctionDescriptor;
import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1NEW = preProcess(str1);
		String str2New = preProcess(str2);
		boolean found;
		if (str1NEW.length() != str2New.length())
		return false;
		for (int i = 0; i < str1NEW.length(); i++) 
		{
			char charFrom1 = str1NEW.charAt(i);
			 found = false;
			for (int l = 0; l < str2New.length(); l++) 
			{
				if (charFrom1 == str2New.charAt(l))
				{
					String new2Before = str2New.substring(0,l);
					String new2After = str2New.substring(l+1);
					str2New = new2Before + new2After;
					found = true;
					break;
				}
			}
		if (!found)
		return false;
		}

		return str2New.length() == 0;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerCaseString = str.toLowerCase();
		String newString = "";
		for (int i = 0; i < str.length(); i++) 
		{
			char ch = lowerCaseString.charAt(i);
			if ((ch >= 'a') && (ch<= 'z'))
			{
				newString += ch;
			}
		}
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newString = "";
		String newStr = str;
		String newBefore;
		String newAfter;
		while (newStr.length()>0)
		{
			int random = (int) (Math.random()*newStr.length());
			char ch = newStr.charAt(random);
			newString += ch;
			newBefore = newStr.substring(0, random);
			newAfter = newStr.substring(random+1);
		
		}
		return newString;
	}
}
