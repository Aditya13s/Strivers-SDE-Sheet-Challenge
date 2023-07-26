/*
 * Brute Force(Nesting)
 * TC = O(N*M)
 * SC = O(N*M)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode b = headB;

        while(b != null) {
            ListNode a = headA;
            while(a != null) {
                if(b == a) {
                    return a;
                }
                a = a.next;
            }
            b = b.next;
        }    
        return null;
    }
}

/*
 * Better(Hashing)
 * TC = O(N+M)
 * SC = O(N)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;   
        HashSet<ListNode> set = new HashSet<>();

        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}

 /*
 * Optimal(Difference)
 * TC = O(N+M)
 * SC = O(1)
 */
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {       
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            a = a == null?headB : a.next;
            b = b == null?headA : b.next;
        }
        return a;
    }
}