/*
 *  Using Nested Loops (TLE)
 *  TC = O(N^3)
 *  SC = O(1)
 */
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] arr = new int[n];
        for(int windowSize=1; windowSize<=n; windowSize++) {
            int max = Integer.MIN_VALUE;
            for(int i=0; i<=n-windowSize; i++) {
                int min = Integer.MAX_VALUE;
                for(int j=i; j<i+windowSize; j++) {
                    min = Math.min(min, a[j]);
                }
                max = Math.max(min, max);
            }
            arr[windowSize-1] = max;
        }
        return arr;
    }
}

/*
 * Using Monotonic Stack
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    static int[] maxOfMin(int[] a, int n) {
        int[] arr = new int[n];
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nextSmaller[i] = n;
            } else {
                nextSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++) {
            int length = nextSmaller[i] - prevSmaller[i] - 1;
            arr[length - 1] = Math.max(arr[length-1], a[i]);
            
        }
        for(int i=n-2; i>=0; i--) {
            arr[i] = Math.max(arr[i], arr[i+1]);
        }
        return arr;
    }
}
