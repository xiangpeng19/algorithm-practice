package excludes;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = new ArrayList<>();
        List<TreeNode> pathToQ = new ArrayList<>();
        findPath(root, p, pathToP);
        findPath(root, q, pathToQ);
        int size = Math.min(pathToP.size(), pathToQ.size());
        TreeNode parent = root;
        for (int i = 0; i < size; i++) {
            if (pathToP.get(i) == pathToQ.get(i)) {
                parent = pathToP.get(i);
            } else {
                return parent;
            }
        }

        return parent;
    }

    public void findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        while (root != null) {
            path.add(root);
            if (root.val < node.val) {
                root = root.right;
            } else if (root.val > node.val) {
                root = root.left;
            } else {
                return;
            }
        }
    }


    // cool!
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }


}
