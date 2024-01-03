/*
 * TC = O(N)
 * SC = O(N)
 */

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<A.size(); i++) {
            while(!stack.empty() && stack.peek() >= A.get(i)) {
                stack.pop();
            }
            
            if(stack.empty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        
        return result;
        
        
    }
}
