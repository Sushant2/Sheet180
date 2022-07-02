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


// Most Optimised approach - using 1 stack & ecrypt & decrpt method to push -
// pop values
// time comp - O(1)
// space comp - O(n)

class MinStack {
    Stack<Long> stk = new Stack<>();
    Long mini;

    public MinStack() {
        mini = Long.MAX_VALUE;
    }

    public void push(int val) {
        // convert int to long
        Long value = Long.valueOf(val);
        if (stk.isEmpty()) {
            mini = value;
            stk.push(value);
        } else {
            if (value < mini) {
                stk.push(2 * value - mini);
                mini = value;
            } else {
                stk.push(value);
            }
        }
    }

    public void pop() {
        if (stk.isEmpty())
            return;
        Long val = stk.pop();
        if (val < mini)
            mini = 2 * mini - val;
    }

    public int top() {
        Long val = stk.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }
}

//Another approach - without using stack
//LinkedList Nodes

class MinStack {
    public class Node {
        int val, min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null)
            head = new Node(val, val, null);
        else
            head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}