class Solution {
    // public String rev(String s){
    //     String ans = "";
    //     for(int i = s.length()-1;i>=0;i--){
    //         ans += s.charAt(i);
    //     }
    //     return ans;
    // }
    public String smallestPalindrome(String s) {
        if(s.length()==1) return s;
        int arr[] = new int[26];
        String st = "";
        for(int i = 0;i<s.length();i++){
            int a = s.charAt(i)-'a';
            arr[a]++;
        }
        for(int i = 0;i<26;i++){
            if(arr[i]==s.length()) return s;
            if(arr[i] == 1) continue;
            int idx = arr[i]/2;
            if(arr[i]%2==0){
                while(idx!=0){
                    st += (char)('a'+i);
                    idx--;
                }
                arr[i] = 0;
            }
            else{
                while(idx!=0){
                st += (char)('a'+i);
                idx--;
                }
                arr[i]=1;
            }
        }
        StringBuilder right = new StringBuilder(st).reverse();
        for(int i = 0;i<26;i++){
            if(arr[i]==1) st += (char)('a'+i);
        }
        return st + right;
    }
}