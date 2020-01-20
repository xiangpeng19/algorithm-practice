package excludes;

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num: nums1) {
            set.add(num);
        }
        for (int num: nums2) {
            if (set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }
        int[] result = new int[res.size()];
        int index = 0;
        for (int num: res) {
            result[index++] = num;
        }
        return result;
    }
}