/*
 * TC = O(N)
 * SC = O(N)
 */

public class Solution{
    static class Stack {
        int[] arr;
        int pointer = -1;
        
        Stack(int capacity) {
            arr = new int[capacity];
        }
        public void push(int num) {
            if(isFull() == 0) {
                pointer++;
                arr[pointer] = num;
            }
        }
        public int pop() {
            if(isEmpty() == 1) return -1;     

            int ans = arr[pointer];
            pointer--;
            return ans;
            
            // Write your code here.
        }
        public int top() {
            if(isEmpty() == 1) return -1;

            return arr[pointer];
            
            // Write your code here.
        }
        public int isEmpty() {
            if(pointer == -1) return 1;
            else {
                return 0;
            }
            // Write your code here.
        }
        public int isFull() {
            if(pointer == arr.length - 1) {
                return 1;
            } else {
                return 0;
            }
            // Write your code here.
        }
    }
}