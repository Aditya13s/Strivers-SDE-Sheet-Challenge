/*
 * Tabulation(DP)
 * TC = O(V*M)
 * SC = O(V)
 */
class Solution {

	public int minCoins(int coins[], int M, int V)  {
	    int[] dp = new int[V+1];
	    
	    for(int i=1; i<=V; i++) {
	        dp[i] = Integer.MAX_VALUE;
	        for(int j=M-1; j>=0; j--) {
	            int coin = coins[j];
	            if(coin <= i && dp[i-coin] != Integer.MAX_VALUE) {
	                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);   
	            }
	        }
	        
	    }
	    
	    return dp[V] == Integer.MAX_VALUE ? -1: dp[V];
	} 
}