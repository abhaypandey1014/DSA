class Solution {
    public long maximumValue(int n, int s, int m) {
        long ans = (long)s + (long)(n/2)*m-((n-1)/2);
        if(n==1) return s;
        if(n%2!=0) return ans+1;
        else return ans;
    }
}