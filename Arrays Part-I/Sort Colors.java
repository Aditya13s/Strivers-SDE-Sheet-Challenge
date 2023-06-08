/* Brute Force
TC = O(Nlog(N))
SC = O(1)*/
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

/* Better
TC = O(N)
SC = O(1)*/
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zero++;
            } else if(nums[i] == 1) {
                one++;
            } else {
                two++;
            }
        }
        int k = 0;
        for(int i=0; i<zero; i++) {
            nums[k] = 0;
            k++;
        }
        for(int i=0; i<one; i++) {
            nums[k] = 1;
            k++;
        }
        for(int i=0; i<two; i++) {
            nums[k] = 2;
            k++;
        }
    }
}

/* Optimal
TC = O(N)
SC = O(1)*/
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length -1;

        while(mid<=high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else if(nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
