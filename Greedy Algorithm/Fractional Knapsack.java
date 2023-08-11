/*
 * TC = O(NlogN)
 * SC = O(1)
 */
public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
		Arrays.sort(items, (a,b) -> Double.compare((double)b.value/b.weight , (double)a.value/a.weight));

		
		int weight = 0;
		double value = 0;

		for(Pair item: items) {
			int remWeight = w - weight;
			if(remWeight >= item.weight) {
				value += item.value;
				weight += item.weight;
			} else {
				value += (double)item.value/item.weight * (double)remWeight;
				break;
			}
		}
		
		return value;
	}
}