/*
 * TC = O(N^2)
 * SC = O(N)
 */
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder result = new StringBuilder();
        findPermutation(nums, k - 1, result);

        return result.toString();
        
    }
    public void findPermutation(List<Integer> nums, int k, StringBuilder result) {
        if (nums.isEmpty()) {
            return;
        }

        int factorial = 1;
        int size = nums.size();
        for (int i = 1; i < size; i++) {
            factorial *= i;
        }

        int index = k / factorial;
        result.append(nums.get(index));
        nums.remove(index);
        findPermutation(nums, k % factorial, result);
    }
}