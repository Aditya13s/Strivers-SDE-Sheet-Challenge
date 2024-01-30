/*
 * Optimal Approach (Using Deque)
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int index = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<nums.length; i++) {
            if(!queue.isEmpty() && queue.peek() == i-k) {
                queue.poll();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offer(i);
            if(i >= k-1) {
                ans[index++] = nums[queue.peek()];
            }

        }
        return ans;
    }
}