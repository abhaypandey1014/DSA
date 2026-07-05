class Solution {
    public long getSum(int[] nums) {
        int n = nums.length;
        long pref[] = new long[n+1];
        for(int i = 0;i<n;i++){
            pref[i+1] = pref[i]+nums[i];
        }
        int l = 0;
        int r = -1;
        long sum = 0;
        int p[] = new int[n];
        //Agar odd hai
        for(int i = 0;i<n;i++){
            int k;
            //agar rightmost bound k bahar hai k ko reset kro
            if(i>r) k = 0;
            else{
                int j = (l+r)-i;
                if(j-p[j]>l){
                    p[i] = p[j];
                    int left = i-p[i];
                    int right = i+p[i];
                    sum = Math.max(sum,pref[right+1]-pref[left]);
                    continue;
                }
                else k = r-i;
            }

            //Now fill p[i] by finding new k
            while(i-k-1>=0 && i+k+1<n && nums[i-k-1]==nums[i+k+1]) k++;
            p[i] = k;
            
            int left = i-p[i];
            int right = i+p[i];
            sum = Math.max(sum,pref[right+1]-pref[left]);
            //Expansion of window
            if(i+k>r){
                l = i-p[i];
                r = i+p[i];
            }
        }

        //Even hua to 
        l = 0;
        r = -1;
        Arrays.fill(p,0);
        for(int i = 0;i<n;i++){
            //agar rightmost bound k bahar hai k ko reset kro
            int k;
            if(i>r) k = -1;
            else{
                int j = (l+r)-i;
                if(j-p[j]>l){
                    p[i] = p[j];
                    if(p[i]>0){
                        int left = i-p[i];
                        int right = i+p[i]-1;
                        sum = Math.max(sum,pref[right+1]-pref[left]);
                    }
                    continue;
                }
                else k = r-i;
            }

            //let say k = -1
            // 10 20 20 10
            // i--->2
            // left = 2-(-1+1),     right = 2+(-1+1)-1
            while(i-k-2>=0 && i+k+1<n && nums[i-k-2]==nums[i+k+1]) k++;
            p[i] = k+1;
            
            int left = i-p[i];
            int right = i+p[i]-1;
            sum = Math.max(sum,pref[right+1]-pref[left]);
            //Expansion of window
            if(i+k>r){
                l = i-p[i];
                r = i+p[i]-1;
            }
        }
        return sum;
    }
}