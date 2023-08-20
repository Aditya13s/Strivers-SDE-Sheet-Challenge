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