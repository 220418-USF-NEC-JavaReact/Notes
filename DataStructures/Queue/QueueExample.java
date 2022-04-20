public class QueueExample {
    public static void main(String args[]) {

        Queue q = new Queue();
        System.out.println("Size before: "+q.size());

        // Queueing integers 1 through 5
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        System.out.println("Size after: "+q.size());
        q.printQueue();

        // Dequeueing the first 2 that were enqueue
        q.dequeue();
        q.dequeue();
        q.printQueue();

        // Queueing a couple more
        q.enqueue(6);
        q.enqueue(7);
        q.printQueue();

        // Use the peek function to view the head and not remove it
        System.out.println("Peeking at head: "+q.peek());
        q.printQueue();
    }
}