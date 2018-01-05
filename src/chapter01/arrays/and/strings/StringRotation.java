package chapter01.arrays.and.strings;

/**
 * Given two strings s1 and s2. Check s2 is a rotated string of s1 or not
 * 
 * @author skedia
 *
 */
public class StringRotation {

	public static void main(String[] args) {
		String s1 = "whiteboard";
		String s2 = "teboardwhi";
		StringRotation sr = new StringRotation();
		System.out.println(sr.isRotatedString(s1, s2));
		System.out.println(sr.isRotatedString2(s1, s2));

	}

	// Not so elegant solution
	public boolean isRotatedString(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int i = 0;
		// reach the starting point where the s1 and s2 matches
		while (i < s1.length() && s1.charAt(i) != s2.charAt(0))
			i++;
		// if
		if (i == s1.length() - 1)
			return false;
		int j = i;
		int k = 0;

		while (k < s2.length()) {
			if (j >= s1.length())
				j = j % s1.length();
			if (s1.charAt(j++) != s2.charAt(k++))
				return false;
		}
		return true;
	}

	// Elegant Solution
	public boolean isRotatedString2(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() == 0)
			return false;
		String s3 = s2 + s2;
		return isSubstring(s1, s3);
	}

	public boolean isSubstring(String s1, String s3) {
		int i = 0;
		int j = 0;

		while (s1.charAt(0) != s3.charAt(i))
			i++;

		int k = i;
		while (j < s1.length() && s1.charAt(j) == s3.charAt(k)) {
			j++;
			k++;
		}
		System.out.println(k - i);
		return k - i == s1.length();
	}

}
