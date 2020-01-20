/**
 * Created by lxp19_000 on 2015-04-16.
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //use BFS
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        //store the number of current level of nodes
        int curNodes = 1;
        //store the number of next level of nodes
        int nextNodes = 0;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            TreeNode node;
            while (curNodes > 0) {
                node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextNodes++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextNodes++;
                }
                curNodes--;
            }
            res.add(level);
            curNodes = nextNodes;
            nextNodes = 0;
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
        System.out.println(new Solution().levelOrder(n1));

    }
}