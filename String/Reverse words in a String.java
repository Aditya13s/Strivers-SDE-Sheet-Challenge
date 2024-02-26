/*
 * Brute Force
 * TC = O(N)
 * SC = O(N)
 */

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        String result = "";
        for(int i=0; i<arr.length; i++) {
            result = arr[i] + result;
            if(i != arr.length -1) {
                result = " " + result;
            }
        }
        return result;
    }
}

/*
 * Optimal
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public String reverseWords(String s) {
        String result = "";
        int i = s.length() - 1;
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) == ' ') i--;
            
            int j = i;

            if(i < 0) break;

            while(i >= 0 && s.charAt(i) != ' ') i--;
            
            if(result.isEmpty()) {
                result = result.concat(s.substring(i+1, j+1));
            } else {
                result = result.concat(" " + s.substring(i+1, j+1));
            }
        }
        return result;
    }
}