class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return help(String.valueOf(finish),limit,s)-help(String.valueOf(start-1),limit,s);
    }
    
    public long help(String str,int limit, String s){
        if(str.length()<s.length()) return 0;
        long dp[][] = new long[20][2];
        for(int i = 0;i<20;i++){
            for(int j = 0;j<2;j++){
                dp[i][j] = -1;
            }
        }
        return solve(dp,str,limit,s,0,1);
    }

    public long solve(long dp[][],String str,int limit, String s,int idx,int tight){
        int n = str.length();
        int m = s.length();
        if(idx==str.length()) return 1;
        if(dp[idx][tight]!=-1) return dp[idx][tight];
        long ans = 0;
        // Pehle prefix bhar rahe hai 
        if(idx<n-m){
            int bound = (tight==1)?str.charAt(idx)-'0':9;
            //Ab boundry check krenge ki kaha tak loop chalega valid hone k liye
            int min = Math.min(limit,bound);
            for(int i = 0;i<=min;i++){
                int newtight = (tight==1 && i==str.charAt(idx)-'0')?1:0;
                ans += solve(dp,str,limit,s,idx+1,newtight);
            }
        }
        //ab suffix ki validity check krni hai jo fixed hone hai
        else{
            int digit = s.charAt(idx-(n-m))-'0';
            //4331
            //4321

            if(tight==0){
                ans += solve(dp,str,limit,s,idx+1,0);
            }
            else{
                int cur = str.charAt(idx) - '0';
                if(digit<cur) ans += solve(dp,str,limit,s,idx+1,0);
                else if(digit==cur) ans += solve(dp,str,limit,s,idx+1,1);
            }
        }
        return dp[idx][tight] = ans;
    }
}