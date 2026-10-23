class MyStack {
    Queue<Integer> q1; 
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int ans = 0;
        if(!q1.isEmpty()){
            while(q1.size()!=1){
                q2.add(q1.remove());
            }
            ans = q1.remove();
        }
        else{
            while(q2.size()!=1){
                q1.add(q2.remove());
            }
            ans = q2.remove();
        }
        return ans;
    }
    
    public int top() {
        int ans = 0;
        if(q1.size()==1) return q1.peek();
        else if(q2.size()==1) return q2.peek();
        if(!q1.isEmpty()){
            while(q1.size()!=1){
                q2.add(q1.remove());
            }
            ans = q1.peek();
            q2.add(q1.remove());
        }
        else{
            while(q2.size()!=1){
                q1.add(q2.remove());
            }
            ans = q2.peek();
            q1.add(q2.remove());
        }
        // if(q2.isEmpty()) return null;
        return ans;
    }
    
    public boolean empty() {
        return q2.isEmpty()&&q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */