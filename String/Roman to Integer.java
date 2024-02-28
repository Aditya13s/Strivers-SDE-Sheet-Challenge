/*
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public int romanToInt(String s) {
        
        int result = 0;

        Map<Character, Integer> map = Map.of(
            'M', 1000,
            'D', 500,
            'C', 100,
            'L', 50,
            'X', 10,
            'V', 5,
            'I', 1);

        int prevValue = 0;
        
        for(int i=0; i<s.length(); i++) {
            int currValue = map.get(s.charAt(i));
            if(i > 0 && prevValue < currValue) {
                result -= 2*prevValue;
            }
            result += currValue;
            prevValue = currValue;
        } 
        
        return result;
    }
}