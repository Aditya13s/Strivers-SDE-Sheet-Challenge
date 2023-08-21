/*
 * TC = O(2^N)
 * SC = O(N)
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        substring(0, s, new ArrayList<String>(), result);
        return result;
        
    }

    public void substring(int idx, String s, List<String> substring, List<List<String>> result) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(substring));
            return;
        }

        for(int i=idx; i<s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                substring.add(s.substring(idx, i+1));
                substring(i+1, s, substring, result);
                substring.remove(substring.size() -1);
            }
        }

    }

    public boolean isPalindrome(String s, int l, int r) {
        while(l<=r) {
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}

/*
 * Dynamic Programming
 * TC = O(N^2)
 * SC = O(N^2)
 */
class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                dp[start][end] = (s.charAt(start) == s.charAt(end)) && (len <= 2 || dp[start + 1][end - 1]);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        generatePartitions(0, s, new ArrayList<String>(), dp, result);
        return result;
    }

    public void generatePartitions(int start, String s, List<String> partition, boolean[][] dp, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                partition.add(s.substring(start, end + 1));
                generatePartitions(end + 1, s, partition, dp, result);
                partition.remove(partition.size() - 1);
            }
        }
    }
}
