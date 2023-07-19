/*
 * Brute Force(Nesting)
 * TC = O(N^2)
 * SC = O(1)
 */
public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        int n = a.length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            int xor = 0;
            for(int j=i; j<n; j++) {
                xor ^= a[j];
                if(xor == b) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

/*
 * Optimal
 * TC = O(N)
 * SC = O(N)
 */
public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        int xor = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<a.length; i++) {
            xor ^= a[i];
            int x = xor^b;

            if(map.containsKey(x)) {
                count += map.get(x);
            }

            if(map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }
        }
        return count;
    }
}