/*
 * TC = O(NlogN)
 * SC = O(N)
 */
public class Solution {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting meeting) {
            return Integer.compare(this.end, meeting.end);
        }
    }
    public static int maximumMeetings(int []start, int []end) {
        // Write your code here.
        int n = start.length;
        Meeting[] meetings = new Meeting[n];
        for(int i=0; i<n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        };
        
        Arrays.sort(meetings);
        
        int count = 1;
        int tempEnd = meetings[0].end;
        for(int i=1; i<n; i++) {
            if(meetings[i].start > tempEnd) {
                tempEnd = meetings[i].end;
                count++;
            }
        }
        return count;
    }
}
