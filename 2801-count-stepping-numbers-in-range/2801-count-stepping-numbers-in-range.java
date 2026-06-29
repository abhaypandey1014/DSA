class Solution {
    public int solve(String s,int idx,int tight,int start,int prev,int dp[][][][]){
        if(idx==s.length()) return start==1?1:0;
        if(dp[idx][tight][start][prev]!=-1) return dp[idx][tight][start][prev];
        int limit = (tight==1)?s.charAt(idx)-'0':9;
        int ans = 0;
        for(int i = 0;i<=limit;i++){
            int newtight = (tight==1 && (i==s.charAt(idx)-'0'))?1:0;
            if(start==0 && i==0){
                ans = (ans+solve(s,idx+1,newtight,0,10,dp))%1000000007;//preventig overflow
            }
            else{
                if(start==1 && Math.abs(prev-i)!=1) continue;
                else ans = (ans+solve(s,idx+1,newtight,1,i,dp))%1000000007;
            }
        }
        return dp[idx][tight][start][prev] = ans;
    }
    public int help(String s){
        int n = s.length();
        int dp[][][][] = new int[n+1][2][2][11];
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<2;j++){
                for(int k = 0;k<2;k++){
                    for(int l = 0;l<11;l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return solve(s,0,1,0,10,dp);
    }
    public String lower(String s){
        StringBuilder sb = new StringBuilder(s);
        for(int i = sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='0') sb.setCharAt(i,'9');
            else{
            sb.setCharAt(i,(char)(sb.charAt(i)-1));
            break;
            }
        }
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public int countSteppingNumbers(String low, String high) {
        int MOD = 1000000007;
        String l = lower(low);
        return (help(high)-help(l)+MOD)%MOD;
    }
}