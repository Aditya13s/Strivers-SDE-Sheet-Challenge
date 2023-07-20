/*
* Iterative Solution
* TC = O(N)
* SC = O(1)
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prevHead = null; // 0
        ListNode nextHead = head; // 1

        while(nextHead != null ) {
            ListNode tempHead = nextHead.next; 
            nextHead.next = prevHead; 
            prevHead = nextHead; 
            nextHead = tempHead; 
        }
        return prevHead;
    }
}

/*
* Recursive Solution
* TC = O(N)
* SC = O(1)
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }
}
