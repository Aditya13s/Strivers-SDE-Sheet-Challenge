/*
 * Brute Force
 * TC = O(N^2)
 * SC = O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return nums[0];
    }
}

/*
 * Better 
 * TC = O(Nlog(N))
 * SC = O(N)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

            if(map.get(nums[i]) > n/2) {
                return nums[i];
            }
        }
        return 0;
    }
}

/*
 * Optimal - 1
 * TC = O(Nlog(N))
 * SC = O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

 /*
 * Optimal - 2
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++) {
            if(count == 0) {
                majority = nums[i];
                count = 1;
                continue;
            }
            if(nums[i] == majority) count++;
            else if(nums[i] != majority) count --;
        }
        return majority;
    }
}

