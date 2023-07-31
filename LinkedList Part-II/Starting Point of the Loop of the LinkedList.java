/*
 * Brute Force(Hashing)
 * TC = O(N)
 * SC = O(N)
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while(head != null) {
            if(set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}

/*
 * Optimal (Fast and Slow)
 * TC = O(N)
 * SC = O(1)
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        
        if(fast == null || fast.next == null) return null;

        while(head != slow) {
            slow= slow.next;
            head = head.next;
        }
        return head;
    }
}
