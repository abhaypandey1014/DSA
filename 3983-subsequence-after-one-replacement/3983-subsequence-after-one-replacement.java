class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int pref[] = new int[n+1];
        int suff[] = new int[n+1];
        int m = t.length();
        int j = 0;
        pref[0] = -1;
        for(int i = 0;i<n;i++){
            //Index find kro jaha pr match kr rha hai 
            while(j<m && t.charAt(j)!=s.charAt(i)) j++; 
            if(j==m){//koi ni match hua abhi tak
                for(int k = i;k<n;k++){
                    pref[k+1] = m;
                }
                break;
            }
            //match ho ja to store krate jao
            pref[i+1] = j;
            j++;
        }
        //matlab ki last character tak match ho gya hai t string k
        if(pref[n]!=m) return true;

        suff[n] = m;
        j = m-1;
        for(int i = n-1;i>=0;i--){
            //Index find kro jaha pr match kr rha hai 
            while(j>=0 && t.charAt(j)!=s.charAt(i)) j--; 
            if(j<0){//koi ni match hua abhi tak
                for(int k = i;k>=0;k--){
                    suff[k] = -1;
                }
                break;
            }
            //match ho ja to store krate jao
            suff[i] = j;
            j--;
        }

        for(int i = 0;i<n;i++){
            //------  a  b  c  -----
            //    -1  0  2  2
            //        \     ---> gap should be checked whether it can be filled by other character in the other string or not
            //         \
            //    -1 -1  1  2
            //------  a  c   -----
            if(pref[i]+1<suff[i+1]) return true;
        }
        return false;
    }
}