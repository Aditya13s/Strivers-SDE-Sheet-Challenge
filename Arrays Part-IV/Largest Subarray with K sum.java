/*
 * Brute Force
 * TC = O(N^2)
 * SC = O(1)
 */
public class Solution {
	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		int n = arr.size();
		int maxCount = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum+=arr.get(j);
                if(sum == 0) {
                    maxCount = Math.max(maxCount, j-i+1);
                }
            }
        }       
        return maxCount;
	}
}

/*
 * Optimal(Hashing)
 * TC = O(N)
 * SC = O(N)
 */
public class Solution {
	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        int n = arr.size();
        int maxCount = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            sum += arr.get(i);
            if(arr.get(i) == 0 && maxCount == 0) {
                maxCount = 1;
            }
            if(sum == 0) {
                maxCount = i+1;
            }
            if(map.containsKey(sum)) {
                maxCount = Math.max(maxCount, i-map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxCount;
	}
}