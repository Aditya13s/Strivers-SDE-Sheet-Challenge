/*
 * Brute Force
 * TC = O(N * k)
 * SC = O(N * k)
 */
public class Solution {
    public static Node flattenLinkedList(Node head) {
        ArrayList<Integer> ans = new ArrayList<>();

        while (head != null) {
            ans.add(head.data);
            Node temp = head.child;

            while (temp != null) {
                ans.add(temp.data);
                temp = temp.child;
            }
            head = head.next;
        }

        Collections.sort(ans);

        Node start = new Node(0);
        Node temp = start;

        for (int i = 0; i < ans.size(); i++) {
            Node node = new Node(ans.get(i));
            temp.child = node;
            temp = node;
        }
        return start.child;
    }
}

/*
 * Optimal(Iterative)
 * TC = O(N * K)
 * SC = O(N)
 */
public class Solution {
	public static Node flattenLinkedList(Node root) {
		if(root==null || root.next==null)
			return root;
		root.next=flattenLinkedList(root.next);
		root=merge(root,root.next);
		return root;
	}

	static Node merge(Node a, Node b) {
		Node temp=new Node(0);
		Node dummy=temp;
		while(a!=null && b!=null) {
			if(a.data<b.data) {
				dummy.child=a;
				dummy=dummy.child;
				a=a.child;
			} else {
				dummy.child=b;
				dummy=dummy.child;
				b=b.child;
			}
		}
		if(a!=null)
			dummy.child=a;
		if(b!=null)
			dummy.child=b;
		return temp.child;
	}
}

/*
 * Optimal(Recursive)
 * TC = O(N * K)
 * SC = O(N)
 */
public class Solution {
	public static Node merge(Node first, Node second) {
		if (first == null) {
			return second;
		}

		if (second == null) {
			return first;
		}

		Node merged;

		if (first.data < second.data) {
			merged = first;
			merged.child = merge(first.child, second);
		} else {
			merged = second;
			merged.child = merge(first, second.child);
		}
		return merged;
	}

	public static Node flattenLinkedList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		head.next = flattenLinkedList(head.next);
		head = merge(head, head.next);
		return head;
	}
}

