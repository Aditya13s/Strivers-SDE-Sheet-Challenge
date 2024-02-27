/*
 * TC = O(N^2)
 * SC = O(1)
 */
class Solution {
    public String longestPalindrome(String s) {
        
        String result = s.substring(0, 1);
        for(int i=0; i<s.length()-1; i++) {
            String odd = expandFromCenter(s, i, i);    
            String even = expandFromCenter(s, i, i+1);

            if(odd.length() > result.length()) {
                result = odd;
            } 
            if(even.length() > result.length()){
                result = even;
            }

        }
        return result;
    }
 
    public String expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}