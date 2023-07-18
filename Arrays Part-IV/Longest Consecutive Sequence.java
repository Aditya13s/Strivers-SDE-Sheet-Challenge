/*
 * Brute Force
 * TC = O(NlogN)
 * SC = O(1)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int count = 1;
        int temp = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]+1) {
                temp++;
            } else if(nums[i] != nums[i-1]){
                temp = 1;
            }
            count = Math.max(temp, count);
        }
        return count;
    }
}

/*
 * Optimal
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        
        int longestCount = 0;
        for(int num: nums) {
            if(!set.contains(num-1)) {
                int currNum = num;
                int currCount = 1;
                while(set.contains(currNum + 1)) {
                    currNum++;
                    currCount++;
                }
                longestCount = Math.max(currCount, longestCount);
            }
        }
        return longestCount;
    }
}

