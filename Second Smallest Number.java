class Solution {

    public int secondSmallest(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException();
        }
        // option 1 - sort arrays
        // Arrays.sort(nums);
        
       // option 2 - use candidate 
       int smallest;
       int secondSmallest;
       if (nums[0] < nums[1]) {
           smallest = nums[0];
           secondSmallest = nums[1];
       } else {
           smallest = nums[1];
           secondSmallest = nums[0];
       }
       for (int i = 2; i < nums.length; i++) {
           int num = nums[i];
           if (num <= smallest) {
               smallest = num;
               secondSmallest = smallest;
           } else if (num > smallest && num <= secondSmallest) {
               secondSmallest = num;
           }
       }
       return secondSmallest;
    }
}