/*
 * Brute Force (Nested Loop)
 * TC = O(N^2)
 * SC = O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        return max;
    }
}
/*
 * Optimal)
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for(int i=0; i<n; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(prices[i]-minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}