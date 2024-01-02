/*
 * Recursion
 * TC = O(N^2)
 * SC = O(N)
 */

public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
		int val = stack.pop();
		if(stack.isEmpty()) {
			stack.push(val);
			return;
		}

		int biggest = checkStack(val, stack);
		stack.push(biggest);
	}

	public static int checkStack(Integer val, Stack<Integer> stack) {
		int small = val, big = stack.pop();
		if(small > big) {
			int temp = small;
			small = big;
			big = temp;
		}

		if(!stack.isEmpty()) {
			int biggerFromSort = checkStack(small, stack);
			if(biggerFromSort > big) {
				int temp = big;
				big = biggerFromSort;
				small = checkStack(temp, stack);
			} else {
				small = biggerFromSort;
			}
		}
		stack.push(small);
		return big;
	}

}