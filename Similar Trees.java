public class Solution {


    // compare if two trees are similar - all the leaf node values are the same
    public boolean similarTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }

        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        addLeaves(res1, root1);
        addLeaves(res2, root2);

        return res1.equals(res2);

    }


    private void addLeaves(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res.add(node.val);
        }

        addLeaves(res, node.left);
        addLeaves(res, node.right);
    }

}
