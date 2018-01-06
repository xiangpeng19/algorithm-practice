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
    /*
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flip = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> curRes = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                curRes.add(cur.val);
                
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            if (flip) {
                Collections.reverse(curRes);
            }

            flip = !flip;
            res.add(curRes);

        }

        return res;
        
    }
}