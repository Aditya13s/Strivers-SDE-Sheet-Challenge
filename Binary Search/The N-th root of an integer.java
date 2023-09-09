/*
 * Brute Force(Linear Search)
 * TC = O(M*log(N))
 * SC = O(1)
 */
public class Solution {
    public static int NthRoot(int n, int m) {

        for(int i=1; i<m; i++) {
            int temp = func(i,n);
            if(temp == m) {
                return i;
            } else if(temp > m) {
                break;
            }

        }
        return -1;
    }

    public static int func(int i, int n) {
        int ans = 1;
        while(n > 0) {
            if(n % 2 == 1) {
                n--;
                ans *= i;
            } else {
                n /= 2;
                i = i*i;
            }
        }
        return ans;
    }
}

/*
 * Optimal (Binary Search) 
 * TC = O(log(M) * N)
 * SC = O(1)
 */
public class Solution {
    public static int NthRoot(int n, int m) {
        int low = 1; 
        int high = m;
        while(low <= high) {
            int mid = (low + high)/2;
            long root  = func(mid, n, m);
            if(root == 0) {
                low = mid+1;
            } else if(root == -1) {
                high = mid-1;
            } else if(root == 1) {
                return mid;
            }
        }
        
        
        return -1;
    }

    public static int func(int mid, int n, int m) {
        long ans = 1;
        for(int i=1; i<=n; i++) {
            ans *= mid;
            if(ans > m) return -1;
        }
        if(ans == m) return 1;
        return 0;
    }
}

