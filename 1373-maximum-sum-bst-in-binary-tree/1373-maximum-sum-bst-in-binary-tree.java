class Solution {
    class Node{
        boolean bst;
        int min;
        int max;
        int sum;
        int ans;
        public Node(boolean bst,int min,int max,int sum,int ans){
            this.bst = bst;
            this.max = max;
            this.min = min;
            this.sum = sum;
            this.ans = ans;
        }
    }
    public Node solve(TreeNode root){
        if(root==null) return new Node(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0,0);
        Node left = solve(root.left);
        Node right = solve(root.right);
        int result = Math.max(left.ans,right.ans);
        if(left.bst && right.bst && left.max<root.val && right.min>root.val){
            int sum = root.val+left.sum+right.sum;
            result = Math.max(result,sum);
            return new Node(true,Math.min(root.val,left.min),Math.max(root.val,right.max),sum,result);
        }
        return new Node(false,0,0,0,result);
    }
    public int maxSumBST(TreeNode root) {
        Node res = solve(root);
        return res.ans; 
    }
}