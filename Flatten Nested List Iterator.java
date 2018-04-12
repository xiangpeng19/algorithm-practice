/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private int index;

    private List<Integer> integers;

    private Iterator<Integer> iter;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.index = 0;
        this.integers = new ArrayList<>();
        flatten(nestedList);
        iter = integers.iterator();
    }


    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger num : nestedList) {
            if (num.isInteger()) {
                System.out.println(num.getInteger());
                integers.add(num.getInteger());
            } else {
                flatten(num.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */