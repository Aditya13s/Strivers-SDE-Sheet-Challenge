/*
 * TC = O(N!)
 * SC = O(N)
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        permutations( numList, new ArrayList<Integer>(), result);
        return result;
    }

    public void permutations( List<Integer> nums, List<Integer> permutation, List<List<Integer>> result) {
        if(nums.isEmpty()) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0; i<nums.size(); i++) {
            int num = nums.get(i);
            permutation.add(num);
            nums.remove(i);
            permutations( nums, permutation, result);
            permutation.remove(permutation.size() -1);
            nums.add(i, num);
        }
    }
}