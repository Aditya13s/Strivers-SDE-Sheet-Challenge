/*
 * TC = O(NlogN)
 * SC = O(1)
 */

class Solution {
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        
        Arrays.sort(arr);
        Arrays.sort(dep);

        int ans = 0;
        int count = 0;
        int j = 0;
        int i = 0;

        while (i < n) {
            if (arr[i] <= dep[j]) {
                count++;
                ans = Math.max(ans, count);
                i++;
            } else if (arr[i] > dep[j]) {
                count--;
                j++;
            }
        }
        return ans;
    }
}
