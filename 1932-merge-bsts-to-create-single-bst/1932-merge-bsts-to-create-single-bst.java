class Solution {
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer,TreeNode> map = new HashMap<>(); 
    public boolean poss(TreeNode root,long lo,long hi){
        if(root==null) return true;
        if(root.val<=lo || root.val>=hi) return false;
        if(root.right==null && root.left==null){
            if(map.containsKey(root.val)){
                TreeNode node = map.remove(root.val);
                root.left = node.left;
                root.right = node.right;
            }
        }
        return poss(root.left,lo,root.val)&&poss(root.right,root.val,hi);
    }
    public TreeNode canMerge(List<TreeNode> trees) {
        for(TreeNode node:trees){
            map.put(node.val,node);
            if(node.left!=null) set.add(node.left.val);
            if(node.right!=null) set.add(node.right.val);
        }
        TreeNode root = null;
        for(TreeNode node: trees){
            if(!set.contains(node.val)){
                root = node;
                break;
            }
        }
        if(root==null) return null;
        map.remove(root.val);
        if(poss(root,Long.MIN_VALUE,Long.MAX_VALUE) && map.isEmpty()) return root;
        return null;
    }
}