class Solution {
    public int solve(int dp[][][],String digits[],String s,int idx,int tight,int start){
        if(idx==s.length()) return start==1?1:0;
        if(dp[idx][tight][start]!=-1) return dp[idx][tight][start];
        int limit = (tight==1)?s.charAt(idx)-'0':9;
        int ans = 0;
        if(start==0){
            int newtight = (tight==1 && limit==0)?1:0;
            ans += solve(dp,digits,s,idx+1,newtight,0);
        }
        //Bcos of restriction we only traverse digits
        for(String d:digits){
            int digit = d.charAt(0)-'0';
            if(digit>limit) continue;
            int newtight = (tight==1 && digit-(s.charAt(idx)-'0')==0)?1:0;
            ans += solve(dp,digits,s,idx+1,newtight,1);
        }
        return dp[idx][tight][start] = ans;
    }
    public int help(String digits[],String s){
        int n = s.length();
        int dp[][][] = new int[n+1][2][2];
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<2;j++){
                for(int k = 0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(dp,digits,s,0,1,0);
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        return help(digits,String.valueOf(n));
    }
}