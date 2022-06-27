//Coding Ninjas - implement queue using arrays

public class Queue {
    int[] que;
    int front, rear, size;

    Queue() {
        // Implement the Constructor
        que = new int[100001];
        front = 0;
        rear = 0;
        size = 0;
    }

    Queue(int size) {
        que = new int[size];
        front = 0;
        rear = 0;
        size = 0;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        if (size == 0)
            return true;
        else
            return false;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        if (size < que.length) {
            que[rear] = data;
            rear = (rear + 1) % que.length;
            size++;
        }
    }

    int dequeue() {
        // Implement the dequeue() function
        if (size == 0) {
            return -1;
        }

        int val = que[front];
        size--;
        front = (front + 1) % que.length;
        if (front == 0)
            rear = 0;
        return val;
    }

    int front() {
        // Implement the front() function
        if (size == 0)
            return -1;
        else
            return que[front];
    }

}
