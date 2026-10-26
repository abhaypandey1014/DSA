class Solution {
    public boolean help(String s,HashMap<Character,List<String>> map,int i,Boolean dp[]){
        if(i>=s.length()) return true;
        if(dp[i]!=null) return dp[i];
        if(map.containsKey(s.charAt(i))){
            for(int j = 0;j<map.get(s.charAt(i)).size();j++){
                String curr = map.get(s.charAt(i)).get(j);
                int len = curr.length();
                if((i+len)<=s.length() && s.substring(i,len+i).equals(curr) && help(s,map,len+i,dp)) return dp[i] = true; 
            }
        }
        return dp[i] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashMap<Character,List<String>> map = new HashMap<>();
        for(int i = 0;i<wordDict.size();i++) {
            String curr = wordDict.get(i);
            if(!map.containsKey(curr.charAt(0))) map.put(curr.charAt(0),new ArrayList<>());
            map.get(curr.charAt(0)).add(curr);
        }
        Boolean dp[] = new Boolean[s.length()];
        return help(s,map,0,dp);
    }
}