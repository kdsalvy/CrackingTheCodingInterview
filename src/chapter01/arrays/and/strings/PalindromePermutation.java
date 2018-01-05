package chapter01.arrays.and.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Write Code to check if a string is the permutation of a palindrome
 * 
 * @author skedia
 *
 */
public class PalindromePermutation {

	public static void main(String[] args) {
		String s = "ababb abab";
		PalindromePermutation pp = new PalindromePermutation();
		System.out.println(pp.isPermutationOfPalindrome(s));
	}

	public boolean isPermutationOfPalindrome(String s) {
		Map<Character, Integer> charCountMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				continue;
			int count = 1;
			if (charCountMap.containsKey(s.charAt(i)))
				count = charCountMap.get(s.charAt(i)) + 1;
			charCountMap.put(s.charAt(i), count);
		}

		System.out.println(charCountMap);
		boolean isSingleOdd = false;
		for (Integer i : charCountMap.values()) {
			if (i % 2 == 0)
				continue;
			if (isSingleOdd)
				return false;
			isSingleOdd = true;
		}
		return true;
	}
}
