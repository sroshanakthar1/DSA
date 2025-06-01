// Java program to implement
// a Singly Linked List
public class LinkedList {
    Node head; // head of list

    // Linked list Node.
    // Node is a static nested class
    // so main() can access it
    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node
    public static LinkedList insert(LinkedList list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }

        System.out.println();
    }

    // Method to delete a node in the LinkedList by key
    public static LinkedList deleteByKey(LinkedList list, int key) {
        // Store head node
        Node currNode = list.head, prev = null;

        // If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head

            System.out.println(key + " found and deleted");

            // Return the updated list
            return list;
        }

        // Search for the key to be deleted,
        // keep track of the previous node
        // as we need to change currNode.next
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore, currNode should not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;

            System.out.println(key + " found and deleted");
        }

        // If key was not present in linked list
        if (currNode == null) {
            System.out.println(key + " not found");
        }

        // Return the updated list
        return list;
    }

    // Method to create a single linked list with 6 nodes
    public static void main(String[] args) {
        // Start with the empty list
        LinkedList list = new LinkedList();

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);

        // Print the LinkedList
        printList(list);

        // Delete node with value 1
        deleteByKey(list, 1);

        // Print the LinkedList
        printList(list);

        // Delete node with value 4
        deleteByKey(list, 4);

        // Print the LinkedList
        printList(list);

        // Delete node with value 10 (which is not present in the list)
        deleteByKey(list, 10);

        // Print the LinkedList
        printList(list);
    }
}
