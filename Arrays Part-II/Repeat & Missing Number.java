/*
 * Brute Force
 * TC = O(N)
 * SC = O(N)
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int repeat = 0;
        long actualSum = 0;
        long sum = 0;
        for(int i=0; i<arr.size(); i++) {
            actualSum += i+1;
            sum += arr.get(i);
            if(set.contains(arr.get(i))){ 
                repeat = arr.get(i);
            }
            set.add(arr.get(i));
        }
        ans.add(repeat);
        long diff = actualSum - sum + repeat;
        ans.add((int) diff);
        return ans;
    }
}