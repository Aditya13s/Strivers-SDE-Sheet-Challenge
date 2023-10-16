/* 
 * Time Complexity = O(logN)
 * Space Complexity = O(N)
 */

class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());        
    }
    
    public void addNum(int num) {
        if (minHeap.isEmpty() || num >= minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        while (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
        while (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */