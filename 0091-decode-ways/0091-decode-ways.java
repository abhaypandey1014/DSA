class Solution {
    public int help(String s,int i,HashMap<String,Character> map,StringBuilder sb,int dp[]){
        if(i>=s.length()) return 1;
        if(sb.toString().length()>2) return 0;
        int ans = 0;
        if(dp[i]!=-1) return dp[i];
        for(int j = i;j<s.length();j++){
            sb.append(s.charAt(j));
            System.out.println(sb);
            if(map.containsKey(sb.toString())) ans += help(s,j+1,map,new StringBuilder(),dp);
        }
        return dp[i] = ans;
    }
    public int numDecodings(String s) {
        HashMap<String,Character> map = new HashMap<>();
        for(int i = 1;i<=26;i++) map.put(String.valueOf(65-65+i),(char)(65+i-1));
        if(s.charAt(0)=='0') return 0;
        StringBuilder sb = new StringBuilder();
        int dp[] = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return help(s,0,map,sb,dp);
    }
}