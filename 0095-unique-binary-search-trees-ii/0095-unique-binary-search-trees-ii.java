/**
class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;//Zero node
        dp[1] = 1;//One Node
        for(int i = 2;i<n+1;i++){
            for(int j = 0;j<i;j++){
                int left = dp[j];//i
                int right = dp[i-j-1];//n-i-1
                dp[i] += right*left;//Catalan of n = catalan of 0 * catalan of n-1
            }
        }
        return dp[n];
    }
}
 */
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
        if(map.containsKey(new Pair(st,en))) {
            return map.get(new Pair(st,en));
        }
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