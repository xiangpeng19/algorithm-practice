/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        List<Integer> res = new ArrayList<>();

        inorder(res, root);
        return res.get(k - 1);
    }

    private void inorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }







    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        int num = countChildren(root.left);
        if (num >= k) {
            return kthSmallest(root.left, k);
        } else if (num + 1 < k) {
            return kthSmallest(root.right, k - 1 - num);
        } else {
            return root.val;
        }
    }


    private int countChildren(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + countChildren(node.left) + countChildren(node.right);
    }


}