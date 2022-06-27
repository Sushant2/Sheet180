//Coding Ninjas - Implement Stack using Arrays

//time comp - O(1)
//space comp - O(stack.length)
public class Stack {
    int[] stackArr;
    int size;
    int top;

    public Stack(int n) {
        stackArr = new int[n];
        this.size = n;
        top = -1;
    }

    void push(int num) {
        // Write your code here.
        if (top != size - 1)
            stackArr[++top] = num;
    }

    int pop() {
        // Write your code here.
        if (top != -1) {
            int val = stackArr[top];
            top--;
            return val;
        } else
            return -1;
    }

    int top() {
        // Write your code here.
        if (top != -1)
            return stackArr[top];
        else
            return -1;
    }

    int isEmpty() {
        // Write your code here.
        if (top == -1)
            return 1;
        else
            return 0;
    }

    int isFull() {
        // Write your code here.
        if (top == size - 1)
            return 1;
        else
            return 0;
    }
}
