class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        find(res, new ArrayList<>(), nums, 0);
        return res;
        
    }


    private void find(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        res.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            find(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }

    }
}