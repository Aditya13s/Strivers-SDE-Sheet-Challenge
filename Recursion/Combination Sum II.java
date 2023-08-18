/*
 * TC = O(2^N)
 * SC = O(N)
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combination(0, candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void combination(int index, int[] candidates, int target, int sum, List<Integer> list, List<List<Integer>> result) {
        if(sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<candidates.length; i++) {
            int remainingSum = target - sum;
            if(i != index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] <= remainingSum) {
                sum += candidates[i];
                list.add(candidates[i]);
                combination(i+1, candidates, target, sum, list, result);
                list.remove(list.size() - 1);
                sum -= candidates[i];
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
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combination(0, candidates, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void combination(int index, int[] candidates, int target,  List<Integer> list, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<candidates.length; i++) {
            if(i != index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;

            list.add(candidates[i]);
            combination(i+1, candidates, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}