/*
 * TC = O(NlogN)
 * SC = O(N)
 */

class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        
        int endTemp = arr[0][1];
        int count = 1;
        for(int i=1; i<n; i++) {
            if(arr[i][0] > endTemp) {
                count++;
                endTemp = arr[i][1];
            }
        }
        
        return count;
        
        
    }
}