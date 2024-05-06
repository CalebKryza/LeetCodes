/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        if(root == null){
            return sum;
        }
        TreeNode current = root;
        while(current.right != null || current.left != null){
            if(current.left != null && (current.left.left == null && current.left.right == null)){
                sum += current.left.val;
            }
            if(current.left != null){
                if(current.left.left != null || current.left.right != null){
                    sum += sumOfLeftLeaves(current.left);
                }
            }
            
            if(current.right == null){
                return sum;
            }
            current = current.right;

        }
        return sum;
    }
}