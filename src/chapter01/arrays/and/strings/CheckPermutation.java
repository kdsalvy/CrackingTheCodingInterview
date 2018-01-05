package chapter01.arrays.and.strings;

/**
 * Check if second string is a permutation of first string in place
 * 
 * @author skedia
 *
 */
public class CheckPermutation {

	public static void main(String[] args) {
		String s1 = "ABCDEFGH";
		String s2 = "ABDECHFG";

		CheckPermutation pos = new CheckPermutation();
		System.out.println(pos.isAPermutationOfOther(s1, s2));
	}

	public boolean isAPermutationOfOther(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		// sort both the strings
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		sort(c1);
		sort(c2);

		// return true if equal
		for (int i = 0; i < c1.length; i++)
			if (c1[i] != c2[i])
				return false;
		return true;
	}

	public void sort(char[] array) {
		int n = array.length;
		int index = n / 2;
		for (int i = index; i >= 0; i--) {
			heapify(array, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			swap(array, i, 0);
			heapify(array, i, 0);
		}
	}

	public void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void heapify(char[] array, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && array[largest] < array[left])
			largest = left;
		if (right < n && array[largest] < array[right])
			largest = right;
		if (largest != i) {
			swap(array, largest, i);
			heapify(array, n, largest);
		}
	}

}
