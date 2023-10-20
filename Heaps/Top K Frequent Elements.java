/*
 * TC = O(NlogK)
 * SC = O(N)
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> counter.get(b) - counter.get(a));
        for(int num: counter.keySet()) {
            heap.offer(num);
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}