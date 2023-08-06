/*
 * Optimal
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int count = 0;
        int tempCount = 0;
        for(int j=0; j<nums.length; j++) {
            if(nums[j] == 0) {
                tempCount = 0;
            } else {
                tempCount++;
            }
            count = Math.max(tempCount, count);
        }       
        return count;
    }
}