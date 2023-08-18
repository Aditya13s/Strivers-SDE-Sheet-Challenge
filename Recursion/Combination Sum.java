/*
 * Optimal Approach 1
 * TC = O(2^N)
 * SC = O(N)
 * N = target
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(0,candidates, target, 0, new ArrayList<Integer>(), ans);

        return ans;
        
        
    }

    public void combination(int index, int[] candidates, int target, int sum, List<Integer> list, List<List<Integer>> ans) {

        if(sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=index; i<candidates.length; i++) {
            int remainingSum = target - sum;
            if(remainingSum >= candidates[i]) {
                sum += candidates[i];
                list.add(candidates[i]);
                combination(i, candidates, target, sum, list, ans);
                sum -= candidates[i];
                list.remove(list.size() - 1);
            }
        }

    }
     
}


/*
 * Optimal Approach 2
 * TC = O(2^N)
 * SC = O(N)
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        findCombination(0, target, candidates, new ArrayList<Integer>(), result);
        return result;
    }

    public static void findCombination(int index, int target, int[] candidates, List<Integer> currentSubset, List<List<Integer>> result) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(currentSubset));
            }
            return;
        }

        if (candidates[index] <= target) {
            currentSubset.add(candidates[index]);
            findCombination(index, target - candidates[index], candidates, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }

        findCombination(index + 1, target, candidates, currentSubset, result);
    }
}

