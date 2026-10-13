class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        st.push(tokens[0]);
        int i = 1;
        int ans = 0;
        while(i<tokens.length){
            String s = tokens[i];
            if(s.equals("+")||s.equals("*")||s.equals("-")||s.equals("/")){
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());
                if(s.equals("+")) st.push(String.valueOf(a+b));
                else if(s.equals("-")) st.push(String.valueOf(a-b));
                else if(s.equals("*")) st.push(String.valueOf(a*b));
                else st.push(String.valueOf(a/b));
            }
            else st.push(tokens[i]);
            i++;
        }
        return Integer.parseInt(st.peek());
    }
}