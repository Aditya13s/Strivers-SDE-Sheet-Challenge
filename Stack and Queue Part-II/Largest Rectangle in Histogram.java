/*
 * Better Approach(Using Stack)
 * TC = O(N)
 * SC = O(N)
 */

 class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i] ) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i] ) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                rightSmall[i] = n-1;
            } else {
                rightSmall[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++) {
            area = Math.max(area, (rightSmall[i] - leftSmall[i] + 1) * heights[i]);
        }

        return area;

    }
}

/*
 * Optimal Approach(Using Arrays)
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        leftSmall[0] = -1;
        rightSmall[n-1] = n;
        for (int i = 1; i < n; i++) {
            int small = i-1;
            while(small >= 0 && heights[small] >= heights[i]) {
                small = leftSmall[small];
            }
            leftSmall[i] = small;
        }

        for(int i=n-2; i>=0; i--) {
            int small = i+1;
            while(small < n && heights[small] >= heights[i]) {
                small = rightSmall[small];
            }
            rightSmall[i] = small;
        
        }

        for(int i=0; i<n; i++) {
            area = Math.max(area, (rightSmall[i] - leftSmall[i] - 1) * heights[i]);
        }

        return area;

    }
}