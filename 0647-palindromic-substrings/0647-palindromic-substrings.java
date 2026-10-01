class Solution {
    public boolean poss(int i,int j,int dp[][],String s){
        if(i>=j) return true;
        if(dp[i][j]!=-1) return dp[i][j]==1;
        if(s.charAt(i)==s.charAt(j) && poss(i+1,j-1,dp,s)){
            dp[i][j] = 1;
            return true;
        }
        dp[i][j] = -1;
        return false;
    }
    public int countSubstrings(String s) {
        int max = 0;
        int prev = 0;
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        int c = 0;
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(poss(i,j,dp,s)){
                    c++;
            
                }
            }
        }
        return c;
    }
}