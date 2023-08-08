/*
 * TC = O(NlogN)
 * SC = O(N)
 */
public class Solution {
    public static int maximumMeetings(int []start, int []end) {
        
        int n = start.length;
        int m[][] = new int[n][2];
        for(int i=0;i<n;i++){
            m[i][0] = start[i];
            m[i][1] = end[i];
        }
        
        Arrays.sort(m,(a,b) -> a[1] - b[1]);
        
        int count = 1;
        int tempEnd = m[0][1];
        for(int i=1; i<n; i++) {
            if(m[i][0] > tempEnd) {
                tempEnd = m[i][1];
                count++;
            }
        }
        return count;
    }
}
