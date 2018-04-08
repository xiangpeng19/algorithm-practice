    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> ret = new ArrayList<List<Integer>>();
         if (nums == null) {
             return ret;
         }
         
         Arrays.sort(nums);
         
         dfs(nums, 0, new ArrayList<Integer> (), ret);
         
         return ret;   
    }
    
    
    private void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
    	res.add(new ArrayList<Integer>(cur));
		
		for (int i = index; i < nums.length; i++) {
			cur.add(nums[i]);
			dfs(nums, i + 1, cur, res);
			cur.remove(cur.size() - 1);
		}    
    }




// start with empty set, then for every number in the input number list, we create new copy of every subset it was created before, and add that number to every new copy subset
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>();
                subset.addAll(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }
        return res;
    }



    // bit maunipalation
    public List<List<Integer>> subsets(int[] nums) {
        int total = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    cur.add(nums[j]);
                }
            }

            res.add(cur);
        }
        
        return res;
    }