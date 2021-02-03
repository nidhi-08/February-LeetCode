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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //base case
        if(root==null){
            return null;
        }
        //else fix right and left subtree

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        
        //case the final tree has root < low
        if(root.val<low){
            TreeNode rchild = root.right;
            root = null;
            return rchild;
        }
        //case the final tree has root>high
        if(root.val>high){
            TreeNode lchild = root.left;
            root = null;
            return lchild;
        }
        
        //case root is within the range
        return root;
    }
}
