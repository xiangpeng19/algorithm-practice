public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int target = -numbers[i];
            // do two sum here with above target
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
                int twoSum = numbers[start] + numbers[end];
                if (twoSum > target) {
                    end--;
                } else if (twoSum < target) {
                    start++;
                } else {
                    ArrayList<Integer> curRes = new ArrayList<>(Arrays.asList(numbers[i], numbers[start], numbers[end]));

                    if (!res.contains(curRes)) {
                        res.add(curRes);
                    }
                    start++;
                    end--;
//                    break;
                }
            }
        }
        return res;
    }
}