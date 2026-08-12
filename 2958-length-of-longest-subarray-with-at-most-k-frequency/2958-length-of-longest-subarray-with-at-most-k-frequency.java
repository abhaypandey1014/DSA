class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max =  0;
        int n = nums.length;
        int len = 0;
        while(right!=n){
            int num = nums[right];
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)<=k){
                len = right-left+1;
            }
            else{
                max = Math.max(len,max);
                len = 0;
                while(map.get(num)>k){
                    map.put(nums[left],map.get(nums[left])-1);
                    left++;
                }
            }
            right++;
        }
        
        return max = Math.max(len,max);
    }
}