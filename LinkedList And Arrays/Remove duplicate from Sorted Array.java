/*
 * Brute Force
 * TC = O(NlogN)
 * SC = O(N)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int j =0;
        int[] arr = new int[set.size()];
        for(int x:set) {
            arr[j] = x;
            j++;
        }
        Arrays.sort(arr);

        j = 0;
        for(int x : arr) {
            nums[j] = x;
            j++;
        }
        return set.size();
    }
}

/*
 * Optimal(Two Pointer)
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j=1; j<nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        } 
        return i+1;
    }
}