/*
 * BruteForce(Finding the left_max and right_max of every index)
 * TC = O(N^2)
 * SC = O(1)
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int waterTrapped = 0;

        for(int i=0; i<n; i++) {
            int j = i;
            int left_max = 0;
            int right_max = 0;

            while(j >= 0) {
                left_max = Math.max(left_max, height[j]);
                j--;
            }

            j = i;
            while(j < n) {
                right_max = Math.max(right_max, height[j]);
                j++;
            }

            waterTrapped += Math.min(left_max, right_max) - height[i];
        }
        return waterTrapped;       
    }
}

/*
 * Better(Find the left_max and right_max of all the index and store in an array)
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int waterTrapped = 0;

        int[] left_max = new int[n];
        int[] right_max = new int[n];

        left_max[0] = height[0];
        right_max[n-1] = height[n-1];

        for(int i=1; i<n; i++) {
            left_max[i] = Math.max(left_max[i-1], height[i]);
        }

        for(int i=n-2; i>=0; i--) {
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }

        for(int i=0; i<n; i++) {
            waterTrapped += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return waterTrapped;       
    }
}

/*
 * Optimal (Two Pointer)
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length -1;
        int leftMax = height[0], rightMax = height[height.length -1];
        int waterTrapped = 0;

        while(left<right) {
            if(leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
            }
        }
        
        return waterTrapped;       
    }
}