class Solution {
    public int minLights(int[] lights) {
        int diff[] = new int[lights.length+1];
        int n = lights.length;
        for(int i = 0;i<n;i++){
            if(lights[i]>0){
                int left = Math.max(0,i-lights[i]);
                int right = Math.min(n-1,i+lights[i]);
                diff[left]++;
                diff[right+1]--;
            }
        }
        int curr = 0;
        int vis[] = new int[n];
        for(int i = 0;i<n;i++){
            curr += diff[i];
            vis[i] = curr;
        }
        int ans = 0;
        int i = 0;
        while(i<n){
            if(vis[i]>0) i++;
            else{
                ans++;
                i += 3;
            }
        }
        return ans;
    }
}