//Leetcode - 225 - Implement Stack using Queues

//uisng 2 queues - push in O(1) & pop in O(n)
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q1.add(x);
        top = x;
    }

    public int pop() {
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int val = q1.remove();
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return val;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

// using 2 queues - push in O(n), pop in O(n)
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q2.add(x);
        top = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        int val = q1.remove();
        if (!q1.isEmpty())
            top = q1.peek();
        return val;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}


// using single queue - push in O(n) & pop in O(1)
class MyStack {
    Queue<Integer> que;

    public MyStack() {
        que = new ArrayDeque<>();
    }

    public void push(int x) {
        que.add(x);
        int size = que.size();
        while (size > 1) {
            que.add(que.remove());
            size--;
        }
    }

    public int pop() {
        return que.remove();
    }

    public int top() {
        return que.peek();
    }

    public boolean empty() {
        return que.isEmpty();
    }
}