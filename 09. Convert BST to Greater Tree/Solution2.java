//Java Solution

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
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        //inorder traversal
        //and start from last and add
        if(root==null){
            return null;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
             // traverse the tree
        while (curr != null || s.size() > 0)
        {
            while (curr!=null)
            {
                s.push(curr);
                curr = curr.left;
            }
            /* Current must be NULL at this point */
            curr = s.pop();
            list.add(curr);
            curr = curr.right;
        }
        int sum=0;
        for(int i=list.size()-1;i>=0;i--){
            sum += list.get(i).val;
            list.get(i).val = sum;
            list.set(i,list.get(i));
        }
        return root;        
    }
}
