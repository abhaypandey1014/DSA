class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<series1.length && j<series2.length){
            List<Integer> list = new ArrayList<>();
            if(series1[i][0]==series2[j][0]){
                list.add(series1[i][0]);
                list.add(series1[i][1]+series2[j][1]);
                ans.add(new ArrayList<>(list));
                i++;
                j++;
            }
            else if(series1[i][0]<series2[j][0]){
                list.add(series1[i][0]);
                list.add(series1[i][1]+series2[j][1]);
                ans.add(new ArrayList<>(list));
                i++;
            }
            else{
                list.add(series2[j][0]);
                list.add(series1[i][1]+series2[j][1]);
                ans.add(new ArrayList<>(list));
                j++;
            }
        }
        while(i<series1.length){
            List<Integer> list = new ArrayList<>();
            list.add(series1[i][0]);
            list.add(series1[i][1]);
            ans.add(new ArrayList<>(list));
            i++;
        }
        while(j<series2.length){
            List<Integer> list = new ArrayList<>();
            list.add(series2[j][0]);
            list.add(series2[j][1]);
            ans.add(new ArrayList<>(list));
            j++;
        }
        return ans;
    }
}