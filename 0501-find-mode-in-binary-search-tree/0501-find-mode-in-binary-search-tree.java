class Solution {
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0;i<list.size();i++){
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
            max = Math.max(map.get(list.get(i)),max);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==max) ans.add(key);
        }
        int res[] = new int[ans.size()];
        for(int i = 0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}