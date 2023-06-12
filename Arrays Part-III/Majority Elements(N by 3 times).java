/*
 * Brute Force
 * TC = O(N^2)
 * SC = O(1)
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            if(count > n/3 && !ans.contains(nums[i])) {
                ans.add(nums[i]);
            }
        }

        return ans;
        
    }
}

/*
 * Better
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > n/3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
        
    }
}

/*
 * Optimal (Extended Boyer Moore’s Voting Algorithm)
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0, el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(cnt1 == 0 && nums[i] != el2) {
                el1 = nums[i];
                cnt1++;
            } else if(cnt2 == 0 && nums[i] != el1) {
                el2 = nums[i];
                cnt2++;
            } else if(nums[i] == el1) cnt1++; 
            else if(nums[i] == el2) cnt2++; 
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == el1) {
                cnt1++;
            }
            if(nums[i] == el2) {
                cnt2++;
            }
        }

        if(cnt1 > n/3) ans.add(el1);
        if(cnt2 > n/3) ans.add(el2);
        return ans;
        
    }
}