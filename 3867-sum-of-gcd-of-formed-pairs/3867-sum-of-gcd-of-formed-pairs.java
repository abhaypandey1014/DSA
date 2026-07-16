class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int t = b;
            b = a%b;
            a = t;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int pref[] = new int[n];
        pref[0] = nums[0];
        int hcf[] = new int[n];
        hcf[0] = pref[0];
        for(int i = 1;i<n;i++){
            pref[i] = Math.max(pref[i-1],nums[i]);
            hcf[i] = gcd(pref[i],nums[i]);
        }
        long res = 0;
        Arrays.sort(hcf);
        for(int i = 0;i<n/2;i++){
            if(i!=n-i-1){
                res += gcd(hcf[i],hcf[n-i-1]);
            }
        }
        return res;
    }
}