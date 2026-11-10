class Solution {
    // public int help(int i,int j,int stones[],int pre[],int jump,int dp[][]){
    //     if(i>=j) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int max = Integer.MAX_VALUE;
    //     for(int k = i;k<j;k=k+jump-1){
    //         int step = help(k+1,j,stones,pre,jump,dp)+help(i,k,stones,pre,jump,dp);
    //         max = Math.min(step,max);
    //     }
    //     if((j-i)%(jump-1)==0) max += pre[j+1]-pre[i];
    //     return dp[i][j] = max;
    // }
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if((n-1)%(k-1)!=0) return -1;
        int pre[] = new int[n+1];
        int dp[][] = new int[n+1][n+1];
        // for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        for(int i = 0;i<n;i++) pre[i+1] = pre[i]+stones[i];
        // return help(0,n-1,stones,pre,k,dp);
        for(int i = 2;i<=n;i++){
            for(int j = 0;j+i<=n;j++){
                int len = j+i-1;
                int max = Integer.MAX_VALUE;
                for(int m = j;m<len;m=m+k-1){
                    int step = dp[m+1][len]+dp[j][m];;
                    max = Math.min(step,max);
                }
                if((len-j)%(k-1)==0) max += pre[len+1]-pre[j];
                dp[j][len] = max;
            }
        }
        return dp[0][n-1];
    }
}