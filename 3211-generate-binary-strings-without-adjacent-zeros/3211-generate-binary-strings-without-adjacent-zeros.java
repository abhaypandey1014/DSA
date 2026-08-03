class Solution {
    public void help(List<String> ans,int n,String s,int prev){
        if(s.length()==n){
            ans.add(s);
            return;
        }
        for(int i = 0;i<=1;i++){
            String s2 = String.valueOf(i);
            if(prev == i && i==0) continue;
            help(ans,n,s+s2,i);
        }
    }
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        help(ans,n,"",-1);
        return ans;
    }
}