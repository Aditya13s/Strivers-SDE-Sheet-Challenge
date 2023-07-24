/*
 * Brute Force
 * TC = O(2N)
 * SC = O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode curr = head;
       int count = 1;
       while(curr.next != null) {
           count++;
           curr = curr.next;
       }

       int pos = count - n;
       ListNode start = head;

       if(pos == 0) {
           head = start.next;
       } else {
           while(pos-1>0) {
               start = start.next;
               pos--;
           }
           start.next = start.next.next;
       }

       return head;       
    }
}

/*
 * Two Pointer (Optimal)
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null) {
            return null;
        }

        ListNode start = new ListNode();
        start.next = head;

        ListNode slow = start;
        ListNode fast = start;

        for(int i=1; i<=n; i++) {
            fast = fast.next;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return start.next;       
    }
}