/*
 * Optimal Solution 1
 * TC = O(logN)
 * SC = O(1)
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {        
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = (low + high)/2;

            if(mid != nums.length -1 && nums[mid] == nums[mid+1]) {
                if(mid % 2 == 0) {
                    low = mid;
                } else {
                    high = mid-1;
                }
            } else if(mid != 0 && nums[mid] == nums[mid-1]) {
                if(mid % 2 == 0) {
                    high = mid;
                } else {
                    low = mid+1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[low];
    }
}

/*
 * Optimal Solution 2
 * TC = O(logN)
 * SC = O(1)
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = (left + right)/2;
            if(mid % 2 == 1) mid--;

            if(nums[mid] != nums[mid+1]) {
                right = mid;
            } else {
                left = mid+2;
            }
        }

        return nums[left];
    }
}