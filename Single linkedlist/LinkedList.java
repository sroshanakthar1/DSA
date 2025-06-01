class LinkedList {

    // Node class to represent each element in the list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    private Node head;

    // Add a node to the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Remove a node from the list by value
    public void remove(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If the node to be removed is the head
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // If the node was found, remove it
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Node with data " + data + " not found");
        }
    }

    // Print the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.print("List: ");
        list.printList();

        list.remove(2);
        System.out.print("After removing 2: ");
        list.printList();

        list.remove(5);  // Trying to remove a non-existent element
    }
}
