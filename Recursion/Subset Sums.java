/*
 * TC = O(2^N)
 * SC = O(2^N)
 */

class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        
        
        ArrayList<Integer> sum = new ArrayList<>();
        subsets(0,0,arr,N,sum);
        Collections.sort(sum);
        return sum;
        
    }
    
    public void subsets(int i, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> subsets) {
        if(i == n) {
            subsets.add(sum);
            return;
        }
        
        subsets(i+1, sum, arr, n, subsets);
        subsets(i+1, sum + arr.get(i), arr, n, subsets);
    }
}