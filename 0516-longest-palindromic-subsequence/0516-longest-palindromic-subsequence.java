class Solution {
    public int lcs(String s1 ,String s2,int i,int j,int dp[][]){
        if(i>=s1.length() || j>=s1.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1+lcs(s1,s2,i+1,j+1,dp);
        else return dp[i][j] = Math.max(lcs(s1,s2,i+1,j,dp),lcs(s1,s2,i,j+1,dp));
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        return lcs(s,rev,0,0,dp);
    }
}