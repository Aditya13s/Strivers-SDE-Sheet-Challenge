/*
 * Brute Force
 * TC = O(Nlog(N))
 * SC = O(1)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }
}

/*
 * Better(Hashing)
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}

/*
 * Optimal
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(fast != slow) ;

        fast = nums[0];
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}