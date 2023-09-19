/*
 * Brute Force
 * TC = O(M+N)
 * SC = O(M+N)
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i=0, j=0, k=0;
        while(i < nums1.length && j<nums2.length) {
            if(nums1[i] <= nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        if(i != nums1.length) {
            while(i < nums1.length) {
                arr[k++] = nums1[i++];
            }
        } else if(j != nums2.length) {
            while(j < nums2.length) {
                arr[k++] = nums2[j++];
            }
        }
        
        int mid = (arr.length -1)/2;
        if(arr.length % 2 ==1) {
            return arr[mid];
        } else {
            double ans = (double)(arr[mid] + arr[mid+1])/2;
            return ans;
        }
    }
}

/*
 * Better Approach 
 * TC = O(M+N)
 * SC = O(1)
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int cnt = 0;
        int i=0, j=0;

        int idx2 = n/2;
        int idx1 = idx2 - 1;

        int idx1el = -1;
        int idx2el = -1;

        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] < nums2[j]) {
                if(cnt == idx2) idx2el = nums1[i];
                if(cnt == idx1) idx1el = nums1[i];
                cnt++;
                i++;
            } else {
                if(cnt == idx2) idx2el = nums2[j];
                if(cnt == idx1) idx1el = nums2[j];
                cnt++;
                j++;
            }
        }

        while(i < nums1.length) {
            if(cnt == idx2) idx2el = nums1[i];
            if(cnt == idx1) idx1el = nums1[i];
            cnt++;
            i++;
        }

        while(j < nums2.length) {
            if(cnt == idx2) idx2el = nums2[j];
            if(cnt == idx1) idx1el = nums2[j];
            cnt++;
            j++;
        }

        if(n%2 == 1) {
            return idx2el;
        }

        return (double)(idx1el+idx2el)/2;

    }
}

/*
 * Optimal 
 * TC = O(log(min(M+N)))
 * SC = O(1)
 */
class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if(a.length > b.length) return findMedianSortedArrays(b,a);
        int low = 0; 
        int high = a.length;

        int n = a.length + b.length; 
        int median = (n+1)/2; //Left half length

        while(low <= high) {
            int mid1 = (low + high)/2;
            int mid2 = median  - mid1;
            int l1 = mid1 > 0 ? a[mid1-1] : Integer.MIN_VALUE;
            int r1 = mid1 < a.length ? a[mid1] : Integer.MAX_VALUE;
            int l2 = mid2 > 0 ? b[mid2-1] : Integer.MIN_VALUE;
            int r2 = mid2 < b.length ? b[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if(n%2 == 1) return Math.max(l1,l2);
                else {
                    return (double)(Math.max(l1,l2) + Math.min(r1, r2))/2;
                }
            } else if(l1 > r2) {
                high = mid1-1;
            } else {
                low = mid1+1;
            }
        }

        return 0;
    }
}