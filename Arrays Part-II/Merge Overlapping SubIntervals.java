/*
 * Optimal Approach
 * TC = O(Nlog(N))
 * SC = O(N)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        
        int[] element = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] <= element[1]) {
                if(intervals[i][1] > element[1]){
                    element[1] = intervals[i][1];
                }
            } else {
                res.add(element);
                element = intervals[i];
            }
        }

        res.add(element);
        return res.toArray(new int[0][]);
    }
}