class MyQueue {
    Stack<Integer> st= new Stack<>();
      Stack<Integer> helper= new Stack<>();


    public MyQueue() {
        //constructor
    }
    
    public void push(int x) {
        st.push(x);
        
    }
    
    public int pop() {
         while(st.size()>1){
            helper.push(st.pop());

        }
        int x=st.pop();
        while(helper.size()>0){
            st.push(helper.pop());
        }
        return x;
        
    }
    
    public int peek() {
      
         while(st.size()>1){
            helper.push(st.pop());

        }
        int x=st.peek();
           while(helper.size()>0){
            st.push(helper.pop());
        }
        return x;
    }
    
    public boolean empty() {
        return st.size()==0;
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */