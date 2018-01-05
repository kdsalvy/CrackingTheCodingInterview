package chapter01.arrays.and.strings;

import java.util.Set;
import java.util.HashSet;

/**
 * Check if all the characters in a string is unique. How will you do it if no
 * extra data structure is allowed.
 * 
 * @author skedia
 *
 */
public class UniqueChars {

	public static void main(String[] args) {
		UniqueChars unique = new UniqueChars();
		String str = "abcdefghijfklm";
		System.out.println(unique.isUniqueUsingSet(str));
		System.out.println(unique.isUniqueInPlace(str));
	}

	public boolean isUniqueUsingSet(String str) {
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			if (charSet.contains(str.charAt(i)))
				return false;
			charSet.add(str.charAt(i));
		}
		return true;
	}

	public boolean isUniqueInPlace(String str) {
		// sort the string
		char[] charArray = str.toCharArray();
		sort(charArray, 0, charArray.length - 1);
		// iterate and check if prev char is same as current char then return
		// false
		Character prev = null;
		for (int i = 0; i < charArray.length; i++) {
			if (prev != null && charArray[i] == prev)
				return false;
			prev = charArray[i];
		}
		return true;

	}

	public void sort(char[] charArray, int startIndex, int endIndex) {
		if (startIndex >= endIndex)
			return;
		int pivotIndex = partition(charArray, startIndex, endIndex);

		sort(charArray, startIndex, pivotIndex - 1);
		sort(charArray, pivotIndex + 1, endIndex);
	}

	public int partition(char[] charArray, int startIndex, int endIndex) {
		int pivot = charArray[endIndex];

		int j = startIndex;
		for (int i = startIndex; i < endIndex; i++) {
			if (charArray[i] < pivot) {
				swap(charArray, i, j);
				j++;
			}
		}
		swap(charArray, j, endIndex);
		return j;
	}

	public void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}
}
