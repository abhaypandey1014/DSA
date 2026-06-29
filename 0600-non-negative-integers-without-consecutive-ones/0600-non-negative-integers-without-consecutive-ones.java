class Solution {
    public int solve(String s,int idx,int dp[][][][],int tight,int start,int prev){
        if(idx==s.length()) return 1;
        if(dp[idx][tight][start][prev]!=-1) return dp[idx][tight][start][prev];
        int limit = (tight==1)?s.charAt(idx)-'0':1;
        int ans = 0;
        for(int i = 0;i<=limit;i++){
            int newTight = (tight==1 && i==limit)?1:0;
            if(start==0 && i==0) ans += solve(s,idx+1,dp,newTight,0,0);
            else{
                if(start==1 && prev==1 && i==1) continue;
                ans += solve(s,idx+1,dp,newTight,i,1);
            }
        }
        return dp[idx][tight][start][prev] = ans;
    }
    public int help(String s){
        int dp[][][][] = new int[s.length()+1][2][2][2];
        for(int i = 0;i<s.length()+1;i++){
            for(int j = 0;j<2;j++){
                for(int k = 0;k<2;k++){
                    for(int l = 0;l<2;l++){
                    dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return solve(s,0,dp,1,0,0);
    }
    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        return help(s);
    }
}