/*
 * Brute Force(Hashing)
 * TC = O(N)
 * SC = O(N)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet <ListNode> hashTable=new HashSet<>();
        while(head != null) {
            if(hashTable.contains(head)) return true;
            hashTable.add(head);
            head = head.next;
        }
        return false;
    }
}

/*
 * Optimal(fast and slow)
 * TC = O(N)
 * SC = O(1)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}