/*
 * Brute Force(Arraylist)
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {     
        ArrayList<Integer> ll = new ArrayList<>();
        while(head != null) {
            ll.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = ll.size() -1;

        while(j>=i) {
            if(ll.get(i) == ll.get(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}


/*
 * Optimal
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = reverseList(slow.next);
        slow = slow.next;
        while(slow != null) {
            if(head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}