class Solution {
    int MOD = 1000000007;
    public int helper(String word1, String word2, String target,int i,int j,int k,int flag1,int flag2,int dp[][][][][]){
        if(dp[i][j][k][flag1][flag2]!=-1) return dp[i][j][k][flag1][flag2];
        if(k==target.length()) return (flag1!=0 && flag2!=0)? 1 : 0;
        int way1 = 0;
        int way2 = 0;
        for(int idx = i;idx<word1.length();idx++){
            if(word1.charAt(idx)==target.charAt(k))
            way1 = (way1+helper(word1,word2,target,idx+1,j,k+1,1,flag2,dp))%MOD;
        }
        for(int idx = j;idx<word2.length();idx++){
            if(word2.charAt(idx)==target.charAt(k))
            way2 = (way2+helper(word1,word2,target,i,idx+1,k+1,flag1,1,dp))%MOD;
        }
        return dp[i][j][k][flag1][flag2] = (int)((way1+way2)%MOD);
    }
    public int interleaveCharacters(String word1, String word2, String target) {
        int n = word1.length();
        int n1 = word2.length();
        int n2 = target.length();
        int dp[][][][][] = new int[n+1][n1+1][n2+1][2][2];
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<n1+1;j++){
                for(int k = 0;k<n2+1;k++){
                    for(int l = 0;l<2;l++){
                        for(int m = 0;m<2;m++){
                            dp[i][j][k][l][m] = -1;
                        }
                    }
                }
            }
        }
        return (helper(word1,word2,target,0,0,0,0,0,dp))%MOD;
    }
}