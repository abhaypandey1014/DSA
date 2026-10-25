class Solution {
    HashMap<TreeNode, Integer> dp = new HashMap<>();
    public int help(TreeNode root){
        if(root==null) return 0;
        int pick = 0;
        int skip = 0;
        int right = 0;
        int left = 0;
        //pick
        if(dp.containsKey(root)) return dp.get(root);
        if(root.left!=null) left = help(root.left.left)+help(root.left.right);
        if(root.right!=null) right = help(root.right.left)+help(root.right.right);
        pick = root.val+right+left;
        //skip
        skip = help(root.left)+help(root.right);
        dp.put(root,Math.max(pick,skip));
        return Math.max(pick,skip);
    }
    public int rob(TreeNode root) {
        return help(root);
    }
}