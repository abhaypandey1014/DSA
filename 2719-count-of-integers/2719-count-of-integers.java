class Solution {
    public int solve(int dp[][][],String s,int idx,int tight,int sum,int min_sum, int max_sum){
        if(idx==s.length()) return (sum>=min_sum && sum<=max_sum)?1:0;
        if(dp[idx][tight][sum]!=-1) return dp[idx][tight][sum];
        int limit = (tight==1)?s.charAt(idx)-'0':9;
        int ans = 0;
        for(int i = 0;i<=limit;i++){
            int newtight = (tight==1 && (i==s.charAt(idx)-'0'))?1:0;
            if(i+sum>max_sum) continue;
            ans = (ans+solve(dp,s,idx+1,newtight,sum+i,min_sum,max_sum))%1000000007;
        }
        return dp[idx][tight][sum] = ans;
    }
    public int help(String s,int min_sum, int max_sum){
        int n = s.length();
        int dp[][][] = new int[n+1][2][9*23+1];
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<2;j++){
                for(int k = 0;k<9*22+1;k++){
                dp[i][j][k] = -1;
                }
            }
        }
        return solve(dp,s,0,1,0,min_sum,max_sum);
    }
    public String lower(String s){
        StringBuilder sb = new StringBuilder(s);
        for(int i = s.length()-1;i>=0;i--){
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
    public int count(String num1, String num2, int min_sum, int max_sum) {
        String l = lower(num1);
        int MOD = 1000000007;
        return ((help(num2,min_sum,max_sum)-help(l,min_sum,max_sum)+MOD))%MOD;
    }
}