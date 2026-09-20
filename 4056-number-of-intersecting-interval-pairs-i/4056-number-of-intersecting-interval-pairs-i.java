class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int count = 0;
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(intervals[i][1]>=intervals[j][0] ) count++;
            }
        }
        return count;
    }
}