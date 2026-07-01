class Solution {
    public int solve(String s,int dp[][][][],int idx,int tight,int start,int change){
        if(idx==s.length()) return (change==1 && start==1)?1:0;
        if(dp[idx][tight][start][change]!=-1) return dp[idx][tight][start][change];
        int limit = (tight==1)?s.charAt(idx)-'0':9;
        int ans = 0;
        for(int i = 0;i<=limit;i++){
            int newtight = (tight==1 && (i==s.charAt(idx)-'0'))?1:0;
            if(start==0 && i==0) ans += solve(s,dp,idx+1,newtight,0,0);
            else{
                if(i==3 || i==4 || i==7) continue;
                //agr 0 1 ya 8 hua to change same rhega otherwise 1 ho jaega
                int newChange = change;
                if(i==2 || i==5 || i==6 || i==9) newChange = 1;
                ans += solve(s,dp,idx+1,newtight,1,newChange);
            }
        }
        return dp[idx][tight][start][change] = ans;
    }
    public int help(String s){
        int n = s.length();
        int dp[][][][] = new int[n+1][2][2][2];
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<2;j++){
                for(int k = 0;k<2;k++){
                    for(int m = 0;m<2;m++){
                        dp[i][j][k][m] = -1;
                    }
                }
            }
        }
        return solve(s,dp,0,1,0,0);
    }
    public int rotatedDigits(int n) {
        return help(String.valueOf(n));
    }
}