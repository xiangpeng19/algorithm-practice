class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null) {
            return res;
        }
        
        Arrays.sort(nums);

        dfs(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int index, int[] nums) {
        res.add(new ArrayList<Integer>(cur));
        
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(res, cur, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        find(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void find(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        res.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            find(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        int total = (int) Math.pow(2, len);
        for (int i = 0; i < total; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if ((t >> j) && 1 != 0) {
                    cur.add(nums[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }
}