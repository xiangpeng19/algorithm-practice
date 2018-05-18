class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target <= 0 || candidates == null || candidates.length == 0) {
            return res;
        }

        // in order to prune the tree
        Arrays.sort(candidates);

        find(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void find(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            cur.add(candidates[i]);
            find(res, cur, candidates, target - candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}