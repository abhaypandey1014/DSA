class Solution {
    HashMap<Pair,List<TreeNode>> map;
    class Pair{
        int l;
        int r;
        public Pair(int l,int r){
            this.l = l;
            this.r = r;
        }
    }
    public List<TreeNode> help(int st,int en){
        List<TreeNode> list = new ArrayList<>();
        if(st>en){
            list.add(null);
            return list;
        }
        if(map.containsKey(new Pair(st,en))) return map.get(new Pair(st,en));
        for(int i = st;i<=en;i++){
            List<TreeNode> left = help(st,i-1);
            List<TreeNode> right = help(i+1,en);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        map.put(new Pair(st,en),list);
        return list;
    }
    public List<TreeNode> generateTrees(int n) {
        map = new HashMap<>();
        return help(1,n);
    }
}