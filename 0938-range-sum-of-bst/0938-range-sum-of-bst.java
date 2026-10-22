class Solution {
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        int ans = 0;
        for(int i = 0;i<list.size();i++){
            if(list.get(i)>=low && list.get(i)<=high) ans += list.get(i);
        }
        return ans;
    }
}