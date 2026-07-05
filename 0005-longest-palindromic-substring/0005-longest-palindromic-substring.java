class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append('#');
            sb.append(c);
        }
        sb.append('#');
        String t = sb.toString();
        int n = t.length();
        int[] p = new int[n];
        int max = 0;
        int centre = 0;
        int l = 0;
        int r = -1;
        int k;
        p[0] = 0;
        for(int i = 1;i<n;i++){
            // Rightmost bound se bahar chla gya matlab firse radius find kro
            if(i>r) k = 0;

            else{
                int j = l+(r-i);
                //left bound se bahar ni gya hai to same p[i] rhega
                if(j-p[j]>l){
                    p[i] = p[j];
                    continue;
                } 

                else k = r-i;
            }
            //radius find kr rhe palindrom ka
            while(i-k-1>=0 && i+k+1<n && t.charAt(i-k-1)==t.charAt(i+k+1)){
                k++;
            }
            p[i] = k;
            if(p[i]>max){
                max = p[i];
                centre = i;
            }
            if(i+k>r){
                l = i-k;
                r = i+k;
            }
        }
        int start = (centre-max)/2;
        return s.substring(start,start+max);
    }
}