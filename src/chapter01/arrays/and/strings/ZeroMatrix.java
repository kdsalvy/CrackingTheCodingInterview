package chapter01.arrays.and.strings;

import java.util.Arrays;

/**
 * Write a method that on encountering zero in a matrix makes the complete
 * column and row as 0
 * 
 * @author skedia
 *
 */
public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5, 6 }, { 7, 0, 8, 0, 9, 10 }, { 11, 12, 13, 14, 15, 16 },
				{ 17, 18, 0, 19, 20, 21 } };
		ZeroMatrix zm = new ZeroMatrix();
		zm.makeRowColZero(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

	public void makeRowColZero(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				int j = 0;
				while (j < matrix[i].length) {
					matrix[i][j++] = 0;
				}
			}
		}

		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				int i = 0;
				while (i < matrix.length) {
					matrix[i++][j] = 0;
				}
			}
		}
	}

}
