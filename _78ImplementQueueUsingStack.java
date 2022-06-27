//Leetcode - 232 - Implement Queue using stacks

//using 2 stacks - push in O(n) & pop in O(1)
class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;

    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    public void push(int x) {
        while (!stk1.isEmpty()) {
            stk2.push(stk1.pop());
        }
        stk1.push(x);

        while (!stk2.isEmpty()) {
            stk1.push(stk2.pop());
        }
    }

    public int pop() {
        return stk1.pop();
    }

    public int peek() {
        return stk1.peek();
    }

    public boolean empty() {
        return stk1.isEmpty();
    }
}


// time comp - O(1) amortized
class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty() == false) {
            return output.pop();
        }
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty() == false) {
            return output.peek();
        }
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
