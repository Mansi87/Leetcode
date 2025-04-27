class MinStack {
    private Stack<Long> st;
    private long min;
    public MinStack() {
        st = new Stack<>();
        min = 0;
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push((long)val);
            min = val;
        }
        else{
            if(val>=min)  st.push((long)val);
            else{
                st.push(2L*val-min);
                min=val;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        long x = st.peek();
        if(x<min){
            min = 2 * min - x;
        }
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty())  return -1;
        long x = st.peek();
        if(x>=min)   return (int)x;
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */