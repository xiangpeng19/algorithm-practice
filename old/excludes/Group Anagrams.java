package excludes;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (!groups.containsKey(sorted)) {
                groups.put(sorted, new ArrayList<String>());
            }

            groups.get(sorted).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        res.addAll(groups.values());
        return res;     
    }
}