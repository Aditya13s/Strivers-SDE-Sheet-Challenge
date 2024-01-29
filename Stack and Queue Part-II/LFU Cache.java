/*
 * Using DoublyLinkedList
 */

class LFUCache {
    int capacity;
    int curSize;
    int minFreq;
    Map<Integer, Node> presentNode;
    Map<Integer, DoubleLinkedList> frequencyMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        curSize = 0;
        minFreq = 0;
        presentNode = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node curNode = presentNode.get(key);
        if(curNode == null) return -1;
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(presentNode.containsKey(key)) {
            Node curNode = presentNode.get(key);
            curNode.val = value;
            updateNode(curNode);
        } else {
            curSize++;
            if(curSize > capacity) {
                DoubleLinkedList minFreqList = frequencyMap.get(minFreq);
                presentNode.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFreq = 1;
            Node newNode = new Node(key, value);

            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            presentNode.put(key, newNode);
        }
    }

    public void updateNode(Node curNode) {
        int curFreq = curNode.freq;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        if(curFreq == minFreq && curList.isEmpty()) {
            minFreq++;
        }

        curNode.freq++;

        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.freq, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.freq, newList);
    }

    class Node {
        int key;
        int val;
        int freq;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            freq = 1;
        }
    }

    class DoubleLinkedList {
        Node head;
        Node tail;

        public DoubleLinkedList() {
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node curNode) {
            Node nextNode = head.next;
            head.next = curNode;
            curNode.prev = head;
            curNode.next = nextNode;
            nextNode.prev = curNode;
        }

        public void removeNode(Node curNode) {
            Node nextNode = curNode.next;
            Node prevNode = curNode.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;

        }

        public boolean isEmpty() {
            if(head.next == tail) return true;
            return false;
        }

    }
}
