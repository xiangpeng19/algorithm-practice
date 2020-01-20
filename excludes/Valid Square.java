package excludes;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int d1 = distance(p1, p2);
        int d2 = distance(p2, p3);
        int d3 = distance(p3, p4);
        int d4 = distance(p4, p1);
        int d5 = distance(p1, p3);
        int d6 = distance(p2, p4);
        List<Integer> dists = new ArrayList<>();
        dists.add(d1);
        dists.add(d2);
        dists.add(d3);
        dists.add(d4);
        dists.add(d5);
        dists.add(d6);

        Set<Integer> set = new HashSet<>();
        
        for (int d : dists) {
            if (d != 0) {
                set.add(d);
            } else {
                return false;
            }
        }
        

        
        return set.size() == 2;

    }

    private int distance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];

        return dx * dx + dy * dy;
    }
}