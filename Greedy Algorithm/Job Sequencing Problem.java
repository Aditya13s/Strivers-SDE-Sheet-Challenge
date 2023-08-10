/*
 * TC = O(NlogN) + O(N*M) = O(NlogN)
 * SC = O(M)
 * M = Maximum Deadline
 */
public class Solution {
    public static int[] jobScheduling(int [][]jobs) {
        // Write your code here
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);


        int tempDeadline = Integer.MIN_VALUE;
        for(int[] job: jobs) {
            tempDeadline = Math.max(job[1], tempDeadline);
        }

        int[] profitCheck = new int[++tempDeadline];
        Arrays.fill(profitCheck, -1);

        int count=0, profit = 0;

        for(int i=0; i<n; i++) {
            for(int k=jobs[i][1]; k>0; k--) {
                if(profitCheck[k] == -1) {
                    profitCheck[k] = jobs[i][1];
                    count++;
                    profit += jobs[i][2];
                    break;

                }

            }
        }

        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = profit;

        return ans;
    }
}
