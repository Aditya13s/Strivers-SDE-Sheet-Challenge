/*
 * Brute Force
 * TC = O(N^2)
 * SC = O(1)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}

/*
 * Optimal
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for(int i=0; i<n; i++) {
            if(map.containsKey(target - nums[i])) {
                arr[0] = map.get(target-nums[i]);
                arr[1] = i;
                return arr;
            }
            map.put(nums[i], i);
        }
        return arr;
    }
}