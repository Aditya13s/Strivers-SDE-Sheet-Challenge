/*
 * TC = O(1)
 * SC = O(1)
 */

public class Solution {
    class Queue {
        int front, rear;
        int []arr;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            arr[rear] = e;
            rear++;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            // Write your code here.
            if(front >= rear) return -1;
            int num = arr[front];
            front++;
            return num;
        }
    }
}