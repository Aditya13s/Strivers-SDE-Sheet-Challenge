/*
 * Brute Force
 * TC = O(N^2logN)
 * SC = O(N^2)
 */
public class Solution {
    public static int[] kMaxSumCombination(int []a, int []b, int n, int k){
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int x = a[i] + b[j];
                pq.add(x);
            }
        }
        int[] arr = new int[k];
        for(int i=0; i<k; i++) {
            arr[i] = pq.poll();
        }
        return arr;
    }
}

/*
 * Optimal
 * TC = O(NlogN)
 * SC = O(N)
 */
public class Solution {

    public static class Pair<F, S> {
        public F first;
        public S second;
        
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getKey() {
            return first;
        }

        public S getValue() {
            return second;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }


        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
    public static int[] kMaxSumCombination(int[] a, int[] b, int n, int k) {
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> maxHeap = new PriorityQueue<>(Comparator.comparingInt(p -> -p.getKey()));

        maxHeap.add(new Pair<>(a[n - 1] + b[n - 1], new Pair<>(n - 1, n - 1)));

        HashSet<Pair<Integer, Integer>> mySet = new HashSet<>();
        mySet.add(new Pair<>(n - 1, n - 1));

        int[] result = new int[k];
        int index = 0;

        while(k > 0) {
            Pair<Integer, Pair<Integer, Integer>> top = maxHeap.poll();
  
            int sum = top.getKey();
            int x = top.getValue().getKey();
            int y = top.getValue().getValue();

            result[index++] = sum;

            if(x-1 >= 0 && !mySet.contains(new Pair<>(x-1, y))) {
                maxHeap.add(new Pair<>(a[x-1] + b[y], new Pair<>(x-1, y)));
                mySet.add(new Pair<>(x-1, y));
            }
            if(y-1 >= 0 && !mySet.contains(new Pair<>(x, y-1))) {
                maxHeap.add(new Pair<>(a[x] + b[y-1], new Pair<>(x, y-1)));
                mySet.add(new Pair<>(x, y-1));
            }
            k -= 1;
        }
        return result;
        
    }

}