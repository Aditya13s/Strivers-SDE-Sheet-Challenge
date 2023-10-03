public class Solution {

    static int left(int k) {
        return 2*k;
    }
    static int right(int k) {
        return 2*k+1;
    }
    static int parent(int k) {
        return k/2;
    }
    // minHeap function which take size of Queries and Queries as Input.
    // Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> minHeap = new ArrayList<>();
        minHeap.add(0); // Dummy value at index 0 to simplify indexing.

        for (int i = 0; i < n; i++) {
            if (q[i][0] == 0) {
                minHeap.add(q[i][1]);
                int idx = minHeap.size() - 1;
                bubbleUp(minHeap, idx);
            } else {
                if(minHeap.size() > 1) {
                    ans.add(minHeap.get(1)); // Get the minimum element.
                    int lastEl = minHeap.remove(minHeap.size() - 1);
                    if (minHeap.size() > 1) {
                        minHeap.set(1, lastEl);
                        bubbleDown(minHeap, 1);
                    }
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void bubbleUp(ArrayList<Integer> minHeap, int idx) {
        while (idx > 1) {
            int parentIdx = parent(idx);
            if (minHeap.get(parentIdx) > minHeap.get(idx)) {
                int temp = minHeap.get(parentIdx);
                minHeap.set(parentIdx, minHeap.get(idx));
                minHeap.set(idx, temp);
                idx = parentIdx;
            } else {
                break;
            }
        }
    }

    private static void bubbleDown(ArrayList<Integer> minHeap, int idx) {
        while (idx < minHeap.size()) {
            int leftChild = left(idx);
            int rightChild = right(idx);
            int smallestIdx = idx;

            if (leftChild < minHeap.size() && minHeap.get(leftChild) < minHeap.get(smallestIdx)) {
                smallestIdx = leftChild;
            }

            if (rightChild < minHeap.size() && minHeap.get(rightChild) < minHeap.get(smallestIdx)) {
                smallestIdx = rightChild;
            }

            if (smallestIdx != idx) {
                int temp = minHeap.get(smallestIdx);
                minHeap.set(smallestIdx, minHeap.get(idx));
                minHeap.set(idx, temp);
                idx = smallestIdx;
            } else {
                break;
            }
        }
    }
}
