class Solution {
    public long pow(long x, long y){
    long mod = 1000000007;
    x = x%mod;
    if(y==0) return 1;
    long half = pow(x,y/2);
    long ans = (half*half)%mod;
    if(y%2==1) ans = (ans*x)%mod;
    return ans;
}
    public int sumDecoded(long[] nums) {
        int n = nums.length;
        int width = 0;
        long d = 0;
        long x = 0;
        long y = 0;
        long ans = 0;
        int mod = 1000000007;
        for(int i = 0;i<n;i++){
            width = (int)(nums[i]%10);
            d = (nums[i]/10);
            String s = String.valueOf(d);
            x = (long)(Long.parseLong(s.substring(0,(width))));
            y = (long)(Long.parseLong(s.substring(width)));
            ans = (ans + pow(x,y)%mod)%mod;
        }
        return (int)ans;
    }
}