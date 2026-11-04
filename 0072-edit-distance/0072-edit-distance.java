class Solution {
    public int help(String s1,String s2,int i,int j,int dp[][]){
        if(i>=s1.length()) return s2.length()-j;
        if(j>=s2.length()) return s1.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        int w1 = 0;
        int w2 = 0;
        int w3 = 0;
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] =help(s1,s2,i+1,j+1,dp);
        else{
            w1 = 1+help(s1,s2,i+1,j,dp);
            w2 = 1+help(s1,s2,i+1,j+1,dp);
            w3 = 1+help(s1,s2,i,j+1,dp);
        }
        return dp[i][j]= Math.min(w1,Math.min(w2,w3));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        return help(word1,word2,0,0,dp);
    }
}