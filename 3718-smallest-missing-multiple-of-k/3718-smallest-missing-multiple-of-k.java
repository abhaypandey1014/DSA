class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans = 0;
        int lim = 100*k;
        int i = 0;
        for(i = k;i<=lim;i=i+k){
            if(!set.contains(i)){
                ans = i;
                break;
            }
        }
        return ans==0?(i):ans;
    }
}