class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < n; i++)
        {
            if(i > 0 && nums[i]==nums[i-1]) continue;
            for(int j = i+1; j < n ;j++)
            {
                if(j > i+1 && nums[j]==nums[j-1]) continue;
                int p = j+1;
                int q = n-1;
                while(p < q)
                {
                long sum = nums[i] + nums[j] ;
                sum += nums[p] + nums[q];
                if(sum < target)
                {
                    p++;
                }
                else if(sum > target) q--;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[p]);
                    temp.add(nums[q]);
                    ans.add(temp);
                    p++;
                    q--;
                    while(p < q && nums[p]==nums[p-1]) p++;
                    while(p < q && nums[q]==nums[q+1]) q--;
                }
                }
            }
        }
        return ans;
    }
}