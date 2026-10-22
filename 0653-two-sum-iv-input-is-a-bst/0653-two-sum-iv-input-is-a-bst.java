class Solution {
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<list.size();i++){
            set.add(list.get(i));
        }
        for(int i = 0;i<list.size();i++){
            if(set.contains(k-list.get(i)) && (k-list.get(i))!=list.get(i)) return true;
        }
        return false;
    }
}