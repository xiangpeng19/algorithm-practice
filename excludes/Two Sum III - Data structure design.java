package excludes;

class TwoSum {
    Map<Integer, Integer> nums;

    /** Initialize your data structure here. */
    public TwoSum() {
        nums = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (!nums.containsKey(number)) {
            nums.put(number, 0);
        }         
        nums.put(number, nums.get(number) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        for (Integer num : nums.keySet()) {
            int remainder = value - num;
            if (nums.containsKey(remainder)) {
                if (num != remainder || map.get(num) > 1) {
                    return true;
                }
            }
            
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */