class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        long ans = 0;
        int n = intervals.length;
        for(int i = 0;i<n;i++){
            int en = intervals[i][1];
            int l = i+1;
            int r = n;
            while(l<r){
                int mid = (l+r)/2;
                if(intervals[mid][0]>en) r = mid;
                else l = mid+1;
            }
            ans += l-i-1;
        }
        return ans;
    }
}