/*
 * TC = O(N)
 * SC = O(N)
 */

public class Solution {
	public static int findCelebrity(int n) {
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<n; i++) {
			st.add(i);
		}

		while(st.size() >= 2) {
			int i = st.pop();
			int j = st.pop();

			if(Runner.knows(i, j)) {
				st.push(j);
			} else {
				st.push(i);
			}

		}

		int pot = st.pop();

		for(int i=0; i<n; i++) {
			if(i != pot) {
				if(!Runner.knows(i, pot) || Runner.knows(pot, i)) {
					return -1;
				}
			}
		}		
		return pot;
    }
}