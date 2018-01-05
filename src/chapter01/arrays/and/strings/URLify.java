package chapter01.arrays.and.strings;

/**
 * In a given string array replace all the spaces with %20. The extra space is
 * provided in the array and thus the logic should be in place.
 * 
 * @author skedia
 *
 */
public class URLify {

	public static void main(String[] args) {
		String str = "I am Saurabh Kedia      ";
		URLify u = new URLify();
		char[] array = str.toCharArray();
		u.urlifyCharArray(array);
		System.out.println(new String(array));

	}

	public void urlifyCharArray(char[] array) {
		boolean isFirstCharEncountered = false;

		int index = array.length - 1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] != ' ')
				isFirstCharEncountered = true;
			if (!isFirstCharEncountered)
				continue;
			if (array[i] == ' ') {
				array[index--] = '0';
				array[index--] = '2';
				array[index--] = '%';
			} else {
				swap(array, i, index);
				index--;
			}
		}
	}

	public void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
