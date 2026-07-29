class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int c = 0;
        int left = 0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()==3){
                System.out.println(map.size()+" ");
                c += s.length()-1-i+1;
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));
                left++;
            }
        }
        return c;
    }
}