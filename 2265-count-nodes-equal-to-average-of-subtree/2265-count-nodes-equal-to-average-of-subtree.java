class Solution {
    private int count = 0;
    private int countNode(TreeNode root) {
        if(root == null) return 0;
        return 1+countNode(root.left)+countNode(root.right);
    }
    public int subtreeSum(TreeNode root){
        if(root == null) return 0;
        return root.val+subtreeSum(root.left)+subtreeSum(root.right);
    }
    public void traverse(TreeNode root){
        if(root == null) return;
        int sum = subtreeSum(root);
        int node = countNode(root);
        if(sum/node == root.val) count++;
        traverse(root.left);
        traverse(root.right);
    }
    public int averageOfSubtree(TreeNode root){
        count = 0;
        traverse(root);
        return count;
    }
}