/*
 * Brute Force
 * TC = O(N^2)
 * SC = O(1)
 */
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                long check = (long)nums[j] * 2;
                if((long)nums[i] > check) {
                    count++;
                }
            }
        }
        return count;
    }    
}

/*
 * Optimal
 * TC = O(Nlog(N))
 * SC = O(N)
 */
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public int mergeSort(int[] nums, int low, int high) {
        if(low >=high ) return 0;
        int mid = (low+high)/2;
        int ans = mergeSort(nums, low, mid);
        ans += mergeSort(nums, mid+1, high);
        ans += merge(nums, low, mid, high);
        return ans;
    }

    public int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid+1;
        for(int i=low; i<=mid; i++) {
            while(j<=high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j-(mid+1));
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while(left <= mid && right<=high) {
            if(nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while(left<=mid) {
            temp.add(nums[left++]);
        }
        while(right<=high) {
            temp.add(nums[right++]);
        }
        for(int i=low; i<=high; i++) {
            nums[i] = temp.get(i-low);
        }
        return cnt;
    }
}