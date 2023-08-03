/*
 * Brute Force
 * TC = O(k*N)
 * SC = O(1)
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {        
        if(head == null || head.next == null || k == 0) return head;

        ListNode dummy = head;
        int length = 0;
        while(dummy != null) {
            length++;
            dummy = dummy.next;
        }
        k = k % length;

        for(int i=0; i<k; i++) {
            ListNode temp = head;

            while(temp.next.next != null) temp = temp.next;
            temp.next.next = head;
            head = temp.next;
            temp.next = null;
        }
        return head;
    }
}

/*
 * Optimal 
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {        
        if(head == null || head.next == null || k == 0) return head;

        ListNode temp = head; 
        int length = 1;

        while(temp.next != null) {
            temp = temp.next;
            length++;
        }

        temp.next = head;
        k = k % length;
        int end = length - k;

        while(end-- != 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

        return head;       
    }
}