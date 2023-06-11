/*
 * Brute Force(Nesting)
 * TC = O(N^2)
 * SC = O(1)
 */
public class Solution {
    public static long getInversions(long arr[], int n) {
        int res = 0;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i] > arr[j]) {
                    res++;
                } 
            }
        }
        return res;
        
    }
}

/*
 * Optimal (Merge Sort)
 * TC = O(Nlog(N))
 * SC = O(N)
 */
public class Solution {
    public static long getInversions(long arr[], int n) {
        
        return mergeSort(arr,new long[n], 0, n-1);
    }

    public static long mergeSort(long arr[],long temp[], int left, int right) {
        int mid = 0;
        long count = 0;
        if(right>left) {
            mid = (right+left)/2;
            count += mergeSort(arr, temp, left, mid);
            count += mergeSort(arr, temp, mid+1, right);
            count += merge(arr, temp, left, mid+1, right);
        }
        return count;
    }

    public static long merge(long arr[], long[] temp, int left, int mid, int right) {
        int i=left;
        int j = mid;
        int k = left;
        long count = 0;

        while((i<= mid-1) && (j<=right)) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
                count += (mid-i);
            }
        }

        while(i<=mid-1) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j<=right) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        for(i=left; i<=right; i++) {
            arr[i] = temp[i];
        }
        return count;
    }

}