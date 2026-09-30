class Solution {
    public String convert(String s, int numRows) {
        List<List<Character>> ans = new ArrayList<>();
        int n = s.length();
        if(n==0) return "";
        for(int i = 0;i<numRows;i++) ans.add(new ArrayList<>());
        int i = 0;
        while(i<n){
            for(int j = 0;j<numRows && i<n;j++){
                ans.get(j).add(s.charAt(i));
                i++;
            }
            for(int j = numRows-2;j>0 && i<n;j--){
                ans.get(j).add(s.charAt(i));
                i++;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int j = 0;j<numRows;j++){
            for(char ch : ans.get(j)){
                res.append(ch);
            }
        }
        return res.toString();
    }
}