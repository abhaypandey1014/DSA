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
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode insert(int val,TreeNode root){
        if(root==null){
            root = new TreeNode(val);
            return root;
        }
        else if(root.val<val) root.right = insert(val,root.right);
        else root.left = insert(val,root.left);
        return root;
    }
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        TreeNode ans = null;
        for(int i = 0;i<list.size();i++){
            ans = insert(list.get(i),ans);
        }
        return ans;
    }
}