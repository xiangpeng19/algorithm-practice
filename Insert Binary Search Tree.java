class Solution {

    public void insert(TreeNode root, int k) {
        if (root.left == null && k < root.val) {
            root.left = new TreeNode(k);
        }
        if (root.right == null && k < root.val) {
            root.right = new TreeNode(k);
        }
        if (root.val < k) {
            insert(root.left, k);
        }

        if (root.val > k) {
            insert(root.left, k);
        }
    }


    
}