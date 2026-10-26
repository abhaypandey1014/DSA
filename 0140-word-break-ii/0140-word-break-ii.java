class Solution {
    public void help(String s,HashSet<String> map,int i,List<String> ans,String curr){
        if(i>=s.length()){
            ans.add(curr);
            return;
        }
        for(int j = i;j<s.length();j++){
            String temp = "";
            String dum = curr;
            if(map.contains(s.substring(i,j+1))){
                if(i!=0) curr += " ";
                temp = s.substring(i,j+1);
                help(s,map,j+1,ans,curr+temp);
                curr = dum;
            }
        }
        return;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        HashSet<String> map = new HashSet<>();
        for(int i = 0;i<wordDict.size();i++) {
            String curr = wordDict.get(i);
            map.add(curr);
        }
        // Boolean dp[] = new Boolean[s.length()];
        help(s,map,0,ans,"");
        return  ans;
    }
}