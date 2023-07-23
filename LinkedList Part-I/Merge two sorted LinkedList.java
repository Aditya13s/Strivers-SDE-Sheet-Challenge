/*
 * Brute Force(Recursive)
 * TC = O(N+M)
 * SC = O(N+M)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;
    
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

/*
 * Optimal(Iterative)
 * TC = O(N+M)
 * SC = O(1)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail=tail.next;
        }

        if(list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return head.next;
    }
}