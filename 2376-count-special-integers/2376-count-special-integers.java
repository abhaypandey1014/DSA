class Solution {
    public int solve(String s,int idx,int tight,int start,int mask,int dp[][][][]){
        if(idx==s.length()) return start==1?1:0;
        if(dp[idx][tight][start][mask]!=-1) return dp[idx][tight][start][mask];
        int limit = (tight==1)?s.charAt(idx)-'0':9;
        int ans = 0;
        for(int i = 0;i<=limit;i++){
            int newtight = (tight==1 && (i==s.charAt(idx)-'0'))?1:0;
            if(start==0 && i==0){
                ans += solve(s,idx+1,newtight,0,mask,dp);
            }
            else{
                if((mask&(1<<i))!=0) continue;
                ans += solve(s,idx+1,newtight,1,mask|(1<<i),dp);
            }
        }
        return dp[idx][tight][start][mask] = ans;
    }
    public int help(String s){
        int dp[][][][] = new int[s.length()+1][2][2][1024];
        for(int i = 0;i<s.length()+1;i++){
            for(int j = 0;j<2;j++){
                for(int k = 0;k<2;k++){
                    for(int l = 0;l<1024;l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return solve(s,0,1,0,0,dp);
    }
    public int countSpecialNumbers(int n) {
        return help(String.valueOf(n));
    }
}