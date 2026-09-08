class Solution {
    public int help(String s, String t,int i,int j,int n,int m,StringBuilder sb,int dp[][]){
        if(i==n || j==m) return (sb.length()==m)?1:0;
        //pick
        int pick = 0;
        int skip = 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
        sb.append(s.charAt(i));
        pick += help(s,t,i+1,j+1,n,m,sb,dp);
        sb.deleteCharAt(sb.length()-1);
        skip += help(s,t,i+1,j,n,m,sb,dp); 
        }
        else skip += help(s,t,i+1,j,n,m,sb,dp); 
        return dp[i][j] = pick+skip;
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        StringBuilder sb = new StringBuilder();
        return help(s,t,0,0,n,m,sb,dp);
    }
}