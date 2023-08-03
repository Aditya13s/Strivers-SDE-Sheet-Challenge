/*
 * Brute Force(Hashing)
 * TC = O(N)
 * SC = O(N)
 */
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hashmap = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            hashmap.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;

        while(temp != null) {
            Node node = hashmap.get(temp);
            node.next = (temp.next != null) ? hashmap.get(temp.next) : null;
            node.random = (temp.random != null) ? hashmap.get(temp.random) : null;
            temp = temp.next;
        }

        return hashmap.get(head);       
    }
}

/*
 * Optimal(3 Steps)
 * TC = O(N)
 * SC = O(1)
 */
class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
   
        // Adding Copied Nodes in the next of that Node
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // Adding random in copied Nodes
        Node itr = head;
        while(itr != null) {
            if(itr.random != null) {
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }

        // Adding copied nodes into a new List and reseting the input List
        Node dummy = new Node(0);
        temp = dummy;
        itr = head;
        Node fast;

        while(itr != null) {
            fast = itr.next.next;
            
            temp.next = itr.next;
            temp = temp.next;

            itr.next = fast;
            itr = fast;
        }

        return dummy.next;       
    }
}