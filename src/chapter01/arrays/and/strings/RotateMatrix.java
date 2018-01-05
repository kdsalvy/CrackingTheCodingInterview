package chapter01.arrays.and.strings;

import java.util.Arrays;

/**
 * Rotate a given matrix by 90 degrees
 *
 * @author skedia
 *
 */
public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		RotateMatrix rm = new RotateMatrix();
		rm.rotateMatrix(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

	public void rotateMatrix(int[][] matrix) {
		for (int i = 0; i < matrix[0].length / 2; i++) {
			for (int j = i; j < matrix[0].length - 1 - i; j++) {
				swap(matrix, j, i, matrix.length - i - 1, matrix.length - j - 1);
			}
		}
	}

	private void swap(int[][] matrix, int j, int i, int k, int l) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[l][i];
		matrix[l][i] = matrix[k][l];
		matrix[k][l] = matrix[j][k];
		matrix[j][k] = temp;
	}

}
