class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 1;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            max = Math.max(nums[i],max);
        }
        int[] cnt = new int[max+1];
        for(int x : nums){
            cnt[x]++;
        }
        long[] freq = new long[max+1];
        for(int i = 1;i<=max;i++){
            for(int j = i;j<=max;j+=i){
                freq[i] += cnt[j];
            }
        }
        long pair[] = new long[max+1];
        for(int i = 0;i<=max;i++){
            pair[i] = (freq[i]*(freq[i]-1))/2;
        }
        long exact[] = new long[max+1];
        for(int i = max;i>=1;i--){
            exact[i] = pair[i];
            for(int j = 2*i;j<=max;j+=i){
                exact[i] -= exact[j];
            }
        }
        long pref[] = new long[max+1];
        pref[0] = exact[0];
        pref[1] = exact[1];
        for(int i = 2;i<=max;i++){
            pref[i] = pref[i-1]+exact[i];
        }
        int ans[] = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int lo = 1;
            int hi = max;
            while(hi>lo){
                int mid = lo + (hi-lo)/2;
                if(pref[mid]>queries[i]) hi = mid;
                else lo = mid+1;
            }
            ans[i] = lo;
        }
        return ans;
    }
}