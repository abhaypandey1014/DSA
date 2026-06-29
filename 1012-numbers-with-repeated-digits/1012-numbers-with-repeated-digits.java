class Solution {
    public int solve(String s,int idx,int dp[][][][],int tight,int start,int mask){
        if(idx==s.length()) return start==1?1:0;
        if(dp[idx][tight][start][mask]!=-1) return dp[idx][tight][start][mask];
        int limit = tight==1?s.charAt(idx)-'0':9;
        int ans = 0;
        for(int i = 0;i<=limit;i++){
            int newTight = (tight==1 && i==s.charAt(idx)-'0')?1:0;
            //leading zero  
            if(i==0 && start == 0) ans += solve(s,idx+1,dp,newTight,0,mask);
            else
            {
                //already present or not condition
                if((mask&(1<<i))!=0) continue;
                //mask|(1<<i) ---> add kar rahe hai 
                ans += solve(s,idx+1,dp,newTight,1,mask|(1<<i));
            }
        }
        return dp[idx][tight][start][mask] = ans;
    }
    public int help(String s){
        int dp[][][][] = new int[s.length()+1][2][2][1024];//idx,tight,start,bitmask
        for(int i = 0;i<s.length()+1;i++){
            for(int j = 0;j<2;j++){
                for(int k = 0;k<2;k++){
                    for(int m = 0;m<1024;m++){
                    dp[i][j][k][m] = -1;
                    }
                }
            }
        }
        return solve(s,0,dp,1,0,0);
    }
    public int numDupDigitsAtMostN(int n) {
        return n - help(String.valueOf(n));
    }
}