/*
 * Optimal Soln(Binary Search)
 * TC = O(NlogN + N*log(max-min))
 * SC = O(1)
 */

public class Solution {
    public static int aggressiveCows(int []stalls, int k) {

        Arrays.sort(stalls);

        int min=1, max = stalls[stalls.length-1] - stalls[0];
    
        while(min <=max) {
            int mid = (min + max)/2;
            if(canWePlace(stalls, mid, k)) {
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        return max;
    }

    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int cowsCount = 1;
        int prev = stalls[0];
        for(int i=1; i<stalls.length; i++) {
            if(stalls[i] - prev >= dist) {
                cowsCount++;
                prev = stalls[i];
            }
            if(cowsCount >= cows) return true;

        }

        return false;
    }


    
}