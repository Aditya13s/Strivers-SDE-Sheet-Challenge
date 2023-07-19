/*
 * Brute Force
 * TC = O(N^2)
 * SC = O(N)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int length = 0;

        for(int i=0; i<n; i++) {
            HashSet<Character> set = new HashSet<>();
            int tempLength = 0;
            for(int j=i; j<n; j++) {
                char ch = s.charAt(j);
                if(set.contains(ch)) {
                    break;
                }
                set.add(ch);
                tempLength++;
                length = Math.max(length, tempLength);
            }
        } 
        return length;
    }
}

/*
 * Optimal 1 (Two Pointer/Sliding Window)
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(int r=0; r<s.length(); r++) {
            char ch = s.charAt(r);
            if(set.contains(ch)) {
                while(l<r && set.contains(ch)) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(ch);
            count = Math.max(count, r-l+1);
        }
        return count;
    }
}

/*
 * Optimal 2 (Hashing)
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, n = s.length(), count = 0;

        while(r<n) {
            char ch = s.charAt(r);

            if(map.containsKey(ch)) {
                l = Math.max(map.get(ch) + 1, l);
            }

            map.put(ch, r);
            count = Math.max(count, r-l+1);
            r++;
        }
        return count;
    }
}