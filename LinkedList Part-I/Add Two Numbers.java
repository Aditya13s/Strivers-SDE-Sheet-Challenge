/*
 * Using Carry
 * TC = O(N or M)
 * SC = O(N or M)
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode tail = start;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
        }

        return start.next;
    }
}