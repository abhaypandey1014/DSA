class Solution {
    public int help(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for(int right = 0;right<nums.length;right++){
            int a = nums[right];
            map.put(a,map.getOrDefault(a,0)+1);
            while(map.size()>k){
                int b = nums[left];
                map.put(b,map.getOrDefault(b,0)-1);
                if(map.get(b)==0) map.remove(b);
                left++;
            }
            ans += right-left+1;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return help(nums,k)-help(nums,k-1);
    }
}