class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        if(s.length()==0 || s.length()==1) return s.length();
        int right = 0;
        for(right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1){
                max = Math.max(max,right-left);
                char ch1 = s.charAt(left);
                map.put(ch1,map.getOrDefault(ch1,0)-1);
                left++;
            }
        }
        max = Math.max(max,right-left);
        return max;
    }
}