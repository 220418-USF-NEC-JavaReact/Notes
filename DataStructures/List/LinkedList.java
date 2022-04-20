package Day3;

// Linked List Class
class LinkedList
{
	Node head; // head of list

    /**
     * Push an element to the top of the LinkedList
     * @param newData
     */
    public void push(int newData){
        // Create the new node to be added
        Node newNode = new Node(newData);

        // Make next of the new Node as head
        newNode.next = head;

        // Move the head to point to the new node
        head = newNode;
    }

    /**
     * Inserts an node after another node
     * @param prevNode
     * @param newData
     */
    public void insertAfter(Node prevNode, int newData){
        // Check if the given node is null
        if (prevNode == null) {
            System.out.println(
                "The given previous node cannot be null");
            return;
        }

        // Insert the data into the new node
        Node newNode = new Node(newData);

        // Make the next of the new Node as next of prevNode
        newNode.next = prevNode.next;

        // make next of prevNode as newNode
        prevNode.next = newNode;
    }

    /**
     * Appends a new node to the end of the LinkedList
     * @param newData
     */
    public void append(int newData){
        // Put the data in a new node
        Node newNode = new Node(newData);

        // If the list is empty, make the new node the head
        if (head == null)
        {
            head = new Node(newData);
            return;
        }

        // Since the new node is the last node, the next parameter is null
        newNode.next = null;

        // Else loop through the LinkedList until we reach the last node
        Node last = head;
        while (last.next != null)
            last = last.next;

        // Change the next of the last node to the new node
        last.next = newNode;
        return;
    }

    /**
     * Deletes the first occurrence of a key in a Linked List
     * @param key
     */
    void deleteNode(int key){
        // Store head node
        Node temp = head, prev = null;
 
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }
 
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
 
        // If key was not present in linked list
        if (temp == null)
            return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    }

    public void printList(){
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }
    
	/* Node Class */
	class Node{
		int data;
		Node next;
		
		Node(int d) {data = d; next = null; }
	}

    public static void main(String args[]){
        
        LinkedList llist = new LinkedList();
 
        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);
 
        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);
 
        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);
 
        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);
 
        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        // delete 8
        llist.deleteNode(8);
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();

    }

}
