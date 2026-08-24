class Solution {
    public boolean valid(int mid,int m, int n, int k){
        long sum = 0;
        for(int i = 1;i<=m;i++){
            sum += Math.min((mid/i),n);
        }
        return (int)sum<k;
    }
    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m*n;
        while(hi>lo){
            int mid = lo + (hi-lo)/2;
            if(valid(mid,m,n,k)) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}