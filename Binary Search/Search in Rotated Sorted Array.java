/*
 * TC = O(logN)
 * SC = O(1)
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;

            // the left side is sorted
            if(nums[left] <= nums[mid]) {
                if(target >= nums[left] && target <= nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            // right side is sorted
            } else {
                if(target >= nums[mid] && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }

        return -1;
        

    }
}