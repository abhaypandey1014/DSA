class Solution {
    int sum = 0;
    public void solve(TreeNode root){
        if(root == null) return;
        solve(root.right);
        sum += root.val;
        root.val = sum;
        solve(root.left);
    }
    public TreeNode bstToGst(TreeNode root){
        solve(root);
        return root;
    }
}