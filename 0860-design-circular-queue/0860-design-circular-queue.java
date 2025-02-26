class MyCircularQueue {
    int front;
    int rear;
    int size;
    int dq[];

    public MyCircularQueue(int k) { // constructor
        front = -1;
        rear = -1;
        size = k;
        dq = new int[k];
    }

    public boolean enQueue(int value) { // enqueue means we can add element at one side and remove elemnt fron other
                                        // side
                                        // or we can say NORMAL QUEUE
                                        // enquue -- addition
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front++;
        }
        rear = (rear + 1) % size;
        dq[rear] = value;
        return true;
    }

    public boolean deQueue() { // doubly ended queue
        if (isEmpty()) {
            return false;
        }
        if(front==rear){
            front=rear=-1;
        }
        else{
            front=(front+1)%size;
        }
        return true;

    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return dq[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return dq[rear];
    }

    public boolean isEmpty() {
        return front == -1 ? true : false;
    }

    public boolean isFull() {
        return front == (rear + 1)%size ? true : false; // see the vidio for clarification
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */