//leetcode - 155 Min Stack
//Put, Pop, getMin, Peek all in O(1)

//Approach - 1
//using 2 Stacks - if push - push on both, & if pop - pop from both
//time comp - O(1)
//space comp - O(2n)

class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStack;

    public MinStack() {
        stk = new Stack<>();
        minStack = new Stack<>();
        // initially push INT.MAX in minstack
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        // push in both
        stk.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stk.pop();
        minStack.pop();
    }

    public int top() {
        if (stk.size() == 0)
            return -1;
        return stk.peek();
    }

    public int getMin() {
        if (stk.size() == 0)
            return -1;
        return minStack.peek();
    }
}


//Most Optimised approach - using 1 stack & ecrypt & decrpt method to push - pop values
//time comp - O(1)
//space comp - O(n)
