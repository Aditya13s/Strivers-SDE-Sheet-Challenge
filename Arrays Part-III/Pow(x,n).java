/*
 * Brute Force
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        for(int i=0; i<Math.abs(n); i++) {
            ans*=x;
        }
        if(n < 0) {
            ans = 1/ans;
        }
        return ans;
    }
}
/*
 * Optimal
 * TC = O(log(N))
 * SC = O(1)
 */
class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;

        if(n < 0){
            n = -n;
            x = 1/x;
        }
        while(n != 0) {
            if(n%2 != 0) {
                ans *= x;
            }
            x *= x;
            n /= 2;
        }
        return ans;

    }
}