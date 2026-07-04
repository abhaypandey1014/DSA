class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i<nums.length;i++){
            int a = nums[i];
            map.put(a,map.getOrDefault(a,0)+1);
        }
        return map.get(nums[n/2])==1;
    }
}