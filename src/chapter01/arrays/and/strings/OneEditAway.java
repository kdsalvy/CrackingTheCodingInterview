package chapter01.arrays.and.strings;

/**
 * Create a method that will take two strings and validate if 2nd string is just
 * one edit, i.e. insert/replace/remove, away from first string.
 * 
 * @author skedia
 *
 */
public class OneEditAway {

	public static void main(String[] args) {
		String s1 = "apple";
		String s2 = "aplle";
		String s3 = "appl";
		String s4 = "rapple";
		String s5 = "rappling";

		OneEditAway oea = new OneEditAway();
		System.out.println(oea.isSingleEditAway(s1, s2));
		System.out.println(oea.isSingleEditAway(s1, s3));
		System.out.println(oea.isSingleEditAway(s1, s4));
		System.out.println(oea.isSingleEditAway(s1, s5));
	}

	public boolean isSingleEditAway(String s1, String s2) {
		if (s1.length() - s2.length() == 1)
			return checkInsertCase(s1, s2);
		if (s1.length() - s2.length() == 0)
			return checkReplaceCase(s1, s2);
		if (s1.length() - s2.length() == -1)
			return checkRemoveCase(s1, s2);
		return false;
	}

	private boolean checkRemoveCase(String s1, String s2) {
		boolean isSingleEditDone = false;
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else if (isSingleEditDone) {
				return false;
			} else {
				j++;
				isSingleEditDone = true;
			}
		}
		return true;
	}

	private boolean checkReplaceCase(String s1, String s2) {
		boolean isSingleEditDone = false;
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else if (isSingleEditDone) {
				return false;
			} else {
				i++;
				j++;
				isSingleEditDone = true;
			}
		}
		return true;
	}

	private boolean checkInsertCase(String s1, String s2) {
		boolean isSingleEditDone = false;
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else if (isSingleEditDone) {
				return false;
			} else {
				i++;
				isSingleEditDone = true;
			}
		}
		return true;
	}

}
