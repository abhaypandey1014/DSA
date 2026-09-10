class Solution {
    private int count = 0;
    private int count(TreeNode root) {
        if(root == null) return 0;
        return 1+count(root.left)+count(root.right);
    }
    public int sum(TreeNode root){
        if(root == null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
    public void help(TreeNode root){
        if(root == null) return;
        int sum = sum(root);
        int node = count(root);
        if(sum/node == root.val) count++;
        help(root.left);
        help(root.right);
    }
    public int averageOfSubtree(TreeNode root){
        count = 0;
        help(root);
        return count;
    }
}