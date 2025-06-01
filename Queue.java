class Queue {

    private int arr[];       // Array to store queue elements
    private int front;       // Front points to the front element in the queue
    private int rear;        // Rear points to the last element in the queue
    private int capacity;    // Maximum capacity of the queue
    private int count;       // Current size of the queue

    // Constructor to initialize the queue
    Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Utility function to add an item to the queue
    public void enqueue(int item) {
        // Check for queue overflow
        if (isFull()) {
            System.out.println("Queue Overflow");
            System.exit(1);
        }

        System.out.println("Inserting " + item);
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    // Utility function to remove front element from the queue
    public int dequeue() {
        // Check for queue underflow
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }

        int item = arr[front];
        System.out.println("Removing " + item);
        front = (front + 1) % capacity;
        count--;

        return item;
    }

    // Utility function to return the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return arr[front];
    }

    // Utility function to return the size of the queue
    public int size() {
        return count;
    }

    // Utility function to check if the queue is empty
    public boolean isEmpty() {
        return (size() == 0);
    }

    // Utility function to check if the queue is full
    public boolean isFull() {
        return (size() == capacity);
    }

    // Display elements of the queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.print("Queue: ");
        queue.printQueue();

        queue.dequeue();
        System.out.println("After dequeue");
        queue.printQueue();
    }
}
