class MyStack {
    private Queue<Integer> q;

    public MyStack() { 
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        int s = q.size();
        q.offer(x);
        for(int i=0; i<s; i++){
            q.offer(q.peek());
            q.poll();
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
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