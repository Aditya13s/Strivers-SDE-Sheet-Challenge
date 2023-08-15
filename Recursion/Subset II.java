/*
 * TC = O(2^N)
 * SC = O(2^N)
 */

 class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subset2(0, nums, list, ans);
        return ans;
        
    }

    public void subset2(int idx, int[] arr, ArrayList<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));

        for(int i=idx; i<arr.length; i++) {
            if(i != idx && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            subset2(i+1, arr, list, ans);
            list.remove(list.size() - 1);
        }
    
    }
}