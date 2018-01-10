package chapter03.stacks.and.queues;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a program to create 3 stacks in a single array
 * 
 * @author skedia
 *
 */
public class SingleArrayImplementing3Stacks {

	int[] dataArray = null;
	int[] indexArray = null;
	int next = 0;
	int[] stackTops = null;

	public SingleArrayImplementing3Stacks() {
		dataArray = new int[15];
		indexArray = new int[16];
		stackTops = new int[3];
		for (int i = 0; i < dataArray.length; i++) {
			dataArray[i] = -1;
			indexArray[i] = i + 1;
		}
		indexArray[indexArray.length - 1] = -1;
		for (int i = 0; i < stackTops.length; i++) {
			stackTops[i] = -1;
		}
	}

	public void push(int d, int stackIndex) {
		if (next == -1) {
			System.out.println("Stack is full");
			return;
		}
		int cTop = stackTops[stackIndex];
		stackTops[stackIndex] = next;
		dataArray[next] = d;
		int temp = indexArray[next];
		indexArray[next] = cTop;
		next = temp;
	}

	public int pop(int stackIndex) {
		if (stackTops[stackIndex] == -1) {
			System.out.println("Stack is empty");
			return -1;
		}
		int cTop = stackTops[stackIndex];
		stackTops[stackIndex] = indexArray[cTop];
		int pop = dataArray[cTop];
		dataArray[cTop] = -1;
		indexArray[cTop] = next;
		next = cTop;
		return pop;
	}

	public static void main(String[] args) {
		SingleArrayImplementing3Stacks stacks = new SingleArrayImplementing3Stacks();
		for (int i = 0; i < 15; i++) {
			stacks.push(new Random().nextInt(100), new Random().nextInt(3));
		}
		System.out.println(Arrays.toString(stacks.dataArray));
		System.out.println(Arrays.toString(stacks.indexArray));
		for (int i = 0; i < 15; i++) {
			int rN = new Random().nextInt(3);
			System.out.println("Stack " + rN + " : " + stacks.pop(rN));
		}

	}

}
