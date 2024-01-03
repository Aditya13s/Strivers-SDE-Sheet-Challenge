/*
 * TC = O(N)
 * SC = O(1)
 */


public class LRUCache {
    class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int ans = node.value;
            removeNode(node);
            addToFront(node);
            return ans;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
        } 
        Node node = new Node(key, value);
        if (map.size() == capacity) {
            Node lastNode = tail.prev;
            removeNode(lastNode);
        }
        addToFront(node);
        
    }

    public void removeNode(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
        map.remove(node.key);
    }

    public void addToFront(Node node) {
        Node headNextNode = head.next;
        head.next = node;
        node.next = headNextNode;
        node.prev = head;
        headNextNode.prev = node;
        map.put(node.key, node);
    }
}

