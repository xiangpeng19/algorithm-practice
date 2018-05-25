
class Solution {
    public List<Integer> sort3(int num1, int num2, int num3) {
        int max = Math.max(num1, Math.max(num2, num3));
        int min = Math.min(num1, Math.min(num2, num3));
        int mid = num1 ^ num2 ^ num3 ^ max ^ min;

        List<Integer> res = new ArrayList<>();
        res.add(min);
        res.add(mid);
        res.add(max);

        return res;

    }
}