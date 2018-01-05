package chapter01.arrays.and.strings;

/**
 * Compress a string having consecutive same character with a string having the
 * character and its count with it. Ex - aaabbbbccddddd to a3b4c2d5
 * 
 * @author skedia
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		String s1 = "aaabbbbbbccddqqaaaattreee";
		StringCompression sc = new StringCompression();
		System.out.println(sc.compressString(s1));
	}

	public String compressString(String s1) {
		StringBuilder result = new StringBuilder();
		Character prev = null;
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (prev != null && s1.charAt(i) == prev)
				count++;
			else if (prev == null) {
				prev = s1.charAt(i);
				count = 1;
			} else {
				result.append(prev);
				result.append(count);
				count = 1;
				prev = s1.charAt(i);
			}
		}
		return result.toString();
	}

}
