class Solution {
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<list.size();i++){
            map.put(list.get(i),map.get(i));
        }
        for(int i = 0;i<queries.size();i++){
            ArrayList<Integer> list1 = new ArrayList<>();
            int lo = 0;
            int hi = list.size()-1;
            int tar = queries.get(i);
            while(hi>=lo){
                int mid = lo+(hi-lo)/2;
                if(list.get(mid)==tar) {
                    list1.add(tar);
                    list1.add(tar);
                    break;
                }
                else if(list.get(mid)>tar) hi = mid-1;
                else lo = mid+1;
            }
            if(list1.size()!=2) {
                if(hi>=0) list1.add(list.get(hi));
                else list1.add(-1);
                if(lo<list.size()) list1.add(list.get(lo));
                else list1.add(-1);
            }
            ans.add(new ArrayList<>(list1));
        }
        return ans;
    }
}