class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i <= nums.length - 2; i = i + 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            while (freq > 0) {
                res.add(val);
                freq--;
            }
        }
        
        return res.stream()
            .mapToInt(Integer::intValue)
            .toArray();

    }
}