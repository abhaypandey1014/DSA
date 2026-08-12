class Solution {
    public int missingInteger(int[] nums) {
        int arr[] = new int[2500];
        int n = nums.length;
        int pref[] = new int[n];
        pref[0] = nums[0];
        for(int i = 0;i<n;i++){
            arr[nums[i]]++;
            if(i!=0) pref[i] = nums[i]+pref[i-1];
        }
        int j = 1;
        int r = 0;
        while(j!=n){
            if(nums[j]==nums[j-1]+1) j++;
            else{
                r = j-1;
                break;
            }
        }
        int num = pref[r];
        if(j==n) num = pref[n-1];
        for(int i = num;i<2500;i++){
            if(arr[i]==0) return i;
        }
        return 0;
    }
}