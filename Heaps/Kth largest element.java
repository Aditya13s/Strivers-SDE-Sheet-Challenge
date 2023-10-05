/*
 * Brute Force 
 * TC = O(NlogN)
 * SC = O(1)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

/*
 * Priority Queue
 * TC = O(NlogN)
 * SC = O(N)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i: nums) pq.add(i);

        int ans = 0;
        while(k-- > 0) {
            ans = pq.poll();
        }

        return ans;
    }
}

/*
 * Quick Select
 * TC = O(N)-best, O(N^2)-worst
 * SC = O(1)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length -1;
        k = nums.length - k;
        while(true) {
            int idx = partition(nums, l, r);
            if(idx ==k) {
                return nums[idx];
            } else if(idx < k) {
                l = idx+1;
            } else {
                r = idx - 1;
            }
        }
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i=l+1, j=r;
        while(i<=j) {
            if(nums[i] >= pivot && nums[j] < pivot) {
                swap(nums, i, j);
                i++;
                j--;
            }
            if(nums[i] <= pivot) i++;
            if(nums[j] >= pivot) j--;
            
        }
        swap(nums, l, j);
        return j;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}