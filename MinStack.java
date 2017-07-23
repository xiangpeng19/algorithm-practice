public class MinStack {
    
    private Stack<Integer> normalStack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        // do initialize if necessary
        this.normalStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        this.normalStack.push(number);
        if (this.minStack.isEmpty() || min() >= number) {
            this.minStack.push(number);
        } 
    }

    public int pop() {
        // write your code here
        int numToPop = this.normalStack.pop();
        if (numToPop == min()) {
            this.minStack.pop();
        }
        return numToPop;
    }

    public int min() {
        // write your code here
        return this.minStack.peek();
    }
}
