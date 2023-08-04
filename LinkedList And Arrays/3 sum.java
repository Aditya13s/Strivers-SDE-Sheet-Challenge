/*
 * Better
 * TC = O(N^2)
 * SC = O(N)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        
        int n= nums.length;

        for(int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();

            for(int j=i+1; j<n; j++) {
                int third = -(nums[i] + nums[j]);
                if(set.contains(third)) {
                    List<Integer> res = Arrays.asList(nums[i], nums[j], third);
                    res.sort(null);
                    ans.add(res);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<List<Integer>>(ans);
    }
}

/*
 * Optimal
 * TC = O(N^2)
 * SC = O(1)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n= nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n; i++) {
            // Skip duplicate values
            if(i != 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) {
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    List<Integer> res = Arrays.asList(nums[i] , nums[j] , nums[k]);
                    ans.add(res);
                    j++;
                    k--;
                    // Skip duplicate values
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(k > j && nums[k] == nums[k+1]) k--;
                }
            }   
        }
        return ans;
    }
}