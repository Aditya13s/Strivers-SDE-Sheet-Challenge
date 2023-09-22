/*
 * Optimal(Binary Search)
 * TC = O(M * log(max-min))
 * SC = O(1)
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        if(m < n) return -1;
        long min = 0;
        long max = 0;
        long res = -1;

        for (int t : time) {
            min = Math.min(min, t);
            max += t;
        }

        while (min <= max) {
            long mid = (min + max) / 2;
            if (isFeasible(time, n, mid)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return res;
    }

    public static boolean isFeasible(int[] time, int n, long k) {
        int days = 1;
        long sum = 0;

        for (int i = 0; i < time.length; i++) {
            if(time[i] > k) return false;
            if (sum + time[i] > k) {
                days++;
                sum = 0;
            }
            sum += time[i];
            
        }

        return days <= n;
    }
}