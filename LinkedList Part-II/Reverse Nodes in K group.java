/*
 * Iterative 
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = new ListNode(0);
        start.next = head;

        ListNode prev = start;
        ListNode curr = prev.next;
        ListNode nxt = curr.next;
        int length = 0;
        while(curr != null) {
            curr = curr.next;
            length++;
        }
        
        while(length>=k) {
            curr = prev.next;
            nxt = curr.next;
            for(int i=1; i<k; i++) {
                curr.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;
                nxt = curr.next;
            }
            prev = curr;
            length -=k;
        }
        return start.next;
    }
}

/*
 * Recursive
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) { 
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}