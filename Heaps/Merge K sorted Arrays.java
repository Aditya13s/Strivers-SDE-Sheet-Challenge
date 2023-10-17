/*
 * TC = O(Nlogk)
 * SC = O(k)
 */
public class Solution {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>(k, new ArrayElementComparator());

        for (int i = 0; i < k; i++) {
            if (!kArrays.get(i).isEmpty()) {
                minHeap.offer(new ArrayElement(kArrays.get(i).get(0), i, 0));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            ArrayElement element = minHeap.poll();
            ans.add(element.value);

            int nextIndex = element.indexInArray + 1;
            if (nextIndex < kArrays.get(element.arrayIndex).size()) {
                minHeap.offer(new ArrayElement(kArrays.get(element.arrayIndex).get(nextIndex), element.arrayIndex, nextIndex));
            }
        }

        return ans;
    }
}

class ArrayElement {
    int value;
    int arrayIndex;
    int indexInArray;

    public ArrayElement(int value, int arrayIndex, int indexInArray) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.indexInArray = indexInArray;
    }
}

class ArrayElementComparator implements Comparator<ArrayElement> {
    @Override
    public int compare(ArrayElement a, ArrayElement b) {
        return Integer.compare(a.value, b.value);
    }
}
