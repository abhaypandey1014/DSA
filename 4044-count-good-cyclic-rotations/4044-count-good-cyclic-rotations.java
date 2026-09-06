class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n/2;
        int sum1 = 0;
        int sum2 = 0;
        while(r!=n){
            sum1 += nums[l];
            sum2 += nums[r];
            l++;
            r++;
        }
        int c1 = 0;
        int c2 = 0;
        if(sum1>sum2) c1++;
        else if(sum1<sum2) c2++;
        l = 1;
        r = n/2;
        while(l<n/2){
            sum1 += nums[r];
            sum1 -= nums[l-1];
            sum2 = sum2+nums[l-1]-nums[r];
            if(sum1>sum2) c1++;
            else if(sum1<sum2) c2++;
            l++;
            r++;
        }
        // if(c2==n/2) c2 = 0;
        return c1+c2;
    }
}