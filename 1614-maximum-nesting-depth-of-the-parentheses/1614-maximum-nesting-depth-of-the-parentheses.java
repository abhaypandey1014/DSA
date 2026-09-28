class Solution {
    public int maxDepth(String s) {
        int op = 0;
        int ans = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            if(s.charAt(i)=='(') op++;
            else if(s.charAt(i)==')'){
                ans = Math.max(op,ans);
                op--;
            } 
        }
        return ans;
    }
}