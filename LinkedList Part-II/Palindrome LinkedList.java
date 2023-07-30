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

