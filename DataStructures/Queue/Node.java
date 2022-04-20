public class Node {

    private int data;
    private Node next;

    public Node () {
        this.data = 0;
        this.next = null;
    }

    public Node (int data) {
        this.data = data;
        this.next = null;
    }
    
    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}