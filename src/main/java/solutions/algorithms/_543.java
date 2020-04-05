package solutions.algorithms;

import commons.models.TreeNode;

public class _543 {

    public static class Solution {

        private int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            getLongestBranch(root);
            return max;
        }

        /**
         * This function does two things:
         * 1) returns the longest diameter of either left or right branch.
         * 2) update the global variable to store the final result.
         *
         * @param node
         * @return
         */
        public int getLongestBranch(TreeNode node) {
            // base case:
            if (node == null) {
                return 0;
            }

            int left = getLongestBranch(node.left);
            int right = getLongestBranch(node.right);

            max = Math.max(max, right + left);

            return Math.max(left, right) + 1;

        }
    }

}
