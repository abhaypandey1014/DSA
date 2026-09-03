class Solution {
    public int valid(int[] nums,int mid){
        int l = 0;
        int n = nums.length;
        int count = 0;
        for(int r = 0;r<n;r++){
            while(nums[r]-nums[l]>mid) l++;
            count += r-l;
        }
        return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int hi = nums[n-1]-nums[0];
        int lo = 0;
        while(hi>lo){
            int mid = lo+(hi-lo)/2;
            if(valid(nums,mid)>=k) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
}