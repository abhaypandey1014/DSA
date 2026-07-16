class Solution {
    public void help(int nums[],int idx,List<Integer> list,List<List<Integer>> ans){
        if(list.size()>1) ans.add(new ArrayList<>(list));
        HashSet<Integer> set = new HashSet<>();
        for(int i = idx;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            if(!list.isEmpty() && nums[i]<list.get(list.size()-1)) continue;
            set.add(nums[i]);
            list.add(nums[i]);
            help(nums,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        help(nums,0,list,ans);
        return ans;
    }
}