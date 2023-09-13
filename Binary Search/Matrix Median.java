/*
 * Brute Force
 * TC = O(M * N * log(M*N))
 * SC = O(M*N)
 */
public final class Solution {
    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int[] arr = new int[m*n];
        int k = 0;
        for(int i=0; i<n; i++){ 
            for(int j=0; j<m; j++) {
                arr[k++] = matrix[j][i];
            }
        }
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
}

/*
 * Optimal
 * TC = O(32 * Mlog(N))
 * SC = O(1)
 */
public final class Solution {
    public static int findMedian(int matrix[][], int m, int n) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<m; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][n-1]);
        }
        int medianCheck = (m*n + 1)/2;
        
        while(min < max) {
            int mid = (min+max)/2;
            int count = 0;
            int find = 0;
            for(int i=0; i<m; i++) {
                find = Arrays.binarySearch(matrix[i], mid);
                System.out.println(count + "  " + find + "  " + i);
                if(find < 0) {
                    find = Math.abs(find) - 1;
                } else {
                    while(find < matrix[i].length && matrix[i][find] == mid) {
                        find+=1;
                    }
                }
                count += find;
            }

            if(count < medianCheck) {
                min = mid+1;
            } else {
                max = mid;
            }
        }

        return min;
    }
}