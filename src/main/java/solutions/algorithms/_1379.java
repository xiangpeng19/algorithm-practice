package solutions.algorithms;

import commons.models.TreeNode;

public class _1379 {

    public static class Solution {

        public final TreeNode getTargetCopy(final TreeNode original,
                                            final TreeNode cloned,
                                            final TreeNode target) {
            if (original == null) {
                return null;
            }
            // we find the target in the original tree, now the cloned tree
            // should be the at the same position as the original one
            if (original.val == target.val) {
                return cloned;
            }

            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left == null) {
              return getTargetCopy(original.right, cloned.right, target);
            } else {
                return left;

            }
        }

    }

}
