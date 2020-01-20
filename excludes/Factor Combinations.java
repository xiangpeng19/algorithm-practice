package excludes;

class Solution {
   public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();

        if (n == 1) {
            return res;
        }

        addFactors(res, new ArrayList<>(), n, 1, 2);

        return res;

    }

    private void addFactors(List<List<Integer>> res, List<Integer> cur, int target, int num, int start) {
        if (num == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (num > target) {
            return;
        }

        for (int i = start; i < target; i++) {
            if (num * i > target) {
                break;
            }
            if (target % i == 0) {
                cur.add(i);
                addFactors(res, cur, target, i * num, i);
                cur.remove(cur.size() - 1);
            }

        }


    }

}