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
/*
 * Optimal
 * TC = O(N)
 * SC = O(1)
 */
public class Solution {
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        
        int xor = 0;
        for(int i=0; i<n; i++) {
            xor ^= arr.get(i);
            xor ^= i+1;
        }

        int rsb = xor & -xor;
        int x=0,y=0;
        for(int i=1; i<=n; i++) {
            if((rsb & arr.get(i-1)) == 0){
                x ^= arr.get(i-1);
            } else {
                y ^= arr.get(i-1);
            }
            if((i & rsb)==0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        int[] ans = new int[2];
        for(int i=0; i<n; i++) {
            if(x == arr.get(i)) {
                ans[1] = x;
                ans[0] = y;
                break;
            }else if(y == arr.get(i)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        
        return ans;
    }

}