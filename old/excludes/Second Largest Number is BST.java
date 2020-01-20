package excludes;

class Solution {

    public int secondLargestNumber(TreeNode root) {
        TreeNode pre = findRightMostNode(root.left);
        return help(root, pre);
    }

    public int help(TreeNode node, TreeNode pre) {
        if (node.right == null) {
            return pre.val;
        } 
        return help(node.right, node);
    }

    public TreeNode findRightMostNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.right != null) {
            return findRightMostNode(root.right);
        } else {
            return root;
        }
    }


    public int secondLargestNumber(TreeNode root) {
        TreeNode pre = null;
        TreeNode cur = root;

        // find the largest number
        while (cur.right != null) {
            pre = cur;
            cur = cur.right;
        }

        // find the second largest number in left branch
        if (cur.left != null) {
            cur = cur.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            pre = cur;
        }
        return pre.val;
    }
}