public class Queue {

    Node head;
    Node tail;

    // No args-constructor
    public Queue() {
        head = null;
        tail = null;
    }

    // Constructor with the first value initialized
    public Queue(int val) {
        Node first = new Node(val);
        this.head = first;
        this.tail = first;
    }

    // Creates a node with the newest value, then adds that node to the tail
    public void enqueue(int val) {
        Node curr = new Node(val);
        // If the queue is empty
        if(this.size() == 0) {
            this.head = curr;
            this.tail = curr;
        } else {
            this.tail.setNext(curr);
            this.tail = curr;
        }
    }

    // removes the head and returns the value
    public int dequeue() {
        int val = head.getData();
        this.head = this.head.getNext();
        return val;
    }

    // Just for convenience, a print function
    public void printQueue() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + ", ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    // Finds size of the queue
    public int size() {
        Node curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.getNext();
        }
        return count;
    }

    // Just views the head without removing it
    public int peek() {
        return head.getData();
    }
}