class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] isVisited = new boolean[nums.length];
        find(res, isVisited, new ArrayList<Integer>(), nums);

        return new ArrayList<>(res);
    }

    private void find(Set<List<Integer>> res, boolean[] isVisited, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            cur.add(nums[i]);
            find(res, isVisited, cur, nums);
            cur.remove(cur.size() - 1);
            isVisited[i] = false;
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        } 

        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
                continue;
            } 
            used[i] = true; 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false; 
            tempList.remove(tempList.size() - 1);
        }
    }
}