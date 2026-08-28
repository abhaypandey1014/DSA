class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int i = 0;
        int n = s.length();
        while(i<n){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            int j = i;
            while(j<n){
                char ch = s.charAt(j);
                if(ch=='1') count++;
                sb.append(ch);
                if(count>k) break;
                else if(count==k){
                    String curr = sb.toString();
                    if(ans.length()==0 || ans.length()>curr.length() || (ans.length()==curr.length() && curr.compareTo(ans)<0))
                    ans = curr;
                }
                j++;
            }
            i++;
        }
        return ans;
    }
}