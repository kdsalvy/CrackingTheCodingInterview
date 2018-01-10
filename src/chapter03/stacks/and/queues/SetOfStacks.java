package chapter03.stacks.and.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Design a new data structure SetOfStacks which creates a new Stack on reaching
 * some capacity but the complete data structure performs as a single stack in
 * working.<br/>
 * Extend it to include a method popAt that pops from the stack at given index
 * 
 * @author skedia
 *
 */
public class SetOfStacks {

	List<Stack<Integer>> setOfStacks = new ArrayList<>();
	int capacity = 0;
	int index = 0;

	public SetOfStacks(int n) {
		capacity = n;
	}

	public void push(int d) {
		if (setOfStacks.size() == 0)
			setOfStacks.add(new Stack<>());
		else if (setOfStacks.get(index).size() == capacity) {
			index++;
			setOfStacks.add(new Stack<>());
		}
		setOfStacks.get(index).push(d);
	}

	public int pop() {
		if (setOfStacks.get(index).isEmpty())
			index--;
		return setOfStacks.get(index).pop();
	}

	public int popAt(int index) {
		if (setOfStacks.get(index).isEmpty())
			return -1;
		else
			return setOfStacks.get(index).pop();
	}

	public static void main(String[] args) {
		SetOfStacks sos = new SetOfStacks(5);
		for (int i = 0; i < 20; i++)
			sos.push(new Random().nextInt(20));

		for (int i = 0; i < 10; i++)
			System.out.println("Pop: " + sos.pop());

		for (int i = 0; i < 10; i++)
			System.out.println("PopAt: " + sos.popAt(new Random().nextInt(4)));
	}

}
