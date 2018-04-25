
class Solution {

    private int max = 1;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        depth(nestedList, 1);
        return sum(nestedList, max);
    }
    
    private void depth(List<NestedInteger> list, int depth) {
        for (NestedInteger i : list) {
            if (!i.isInteger()) {
                depth++;
                max = Math.max(max, depth);
                depth(i.getList(), depth);
                depth--;
            }
        }
    }
    private int sum(List<NestedInteger> list, int depth) {
        int sum = 0;
        if (depth < 1) {
            return sum;
        }
        for (NestedInteger i : list) {
            if (i.isInteger()) {
                sum += i.getInteger() * depth;
            } else {
                sum += sum(i.getList(), depth - 1);
            }
        }

        return sum;
    }
    

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    unweighted += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }
}