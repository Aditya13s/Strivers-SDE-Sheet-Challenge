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