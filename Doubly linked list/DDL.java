public class DDL {
	Node head;
	
	class Node{
		int data;
		Node prev;
		Node next;
		
		Node(int d){
			data = d;
		}
	}
	
	public void insertionFront(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		newNode.prev = null;
		
		if(head!=null)
			head.prev = newNode;
			head = newNode;
	}
	
	public void insertionAfter(Node prev_node, int data){
		if(prev_node == null){
			System.out.println("previous node cannot be null");
			return;
		}
		
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		new_node.prev = prev_node;
		
		if(new_node.next != null)
		new_node.next.prev = new_node;
	}
	
	void insertEnd(int data){
		Node new_node = new Node(data);
		Node temp = head;
		new_node.next = null;
		
		if(head == null){
			new_node.prev = null;
			head = new_node;
			return;
		}
		
		while(temp.next != null)
			temp = temp.next;
			temp.next = new_node;
			new_node.prev = temp;
	}
	
	/*------------------------------QuickSort---------------------------------------------*/
	
	  
    Node lastNode(Node node){
        while(node.next!=null)
            node = node.next;
        return node;
    }
     
 

    Node partition(Node l,Node h)
    {
       
        int x = h.data;
        Node i = l.prev;
      
        for(Node j=l; j!=h; j=j.next)
        {
            if(j.data <= x)
            {
                
                i = (i==null) ? l : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i==null) ? l : i.next;  
        int temp = i.data;
        i.data = h.data;
        h.data = temp;
        return i;
    }
     
    void _quickSort(Node l,Node h)
    {
        if(h!=null && l!=h && l!=h.next){
            Node temp = partition(l,h);
            _quickSort(l,temp.prev);
            _quickSort(temp.next,h);
        }
    }
     
    public void quickSort(Node node)
    {
       
        Node head = lastNode(node);
         
        _quickSort(node,head);
    }
	
	//---------------------------------MERGE SORT----------------------------------------------
	
    Node split(Node head)
    {
        Node fast = head, slow = head;
        while (fast.next != null
               && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }
 
    Node mergeSort(Node node)
    {
        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node);
 
        node = mergeSort(node);
        second = mergeSort(second);
 
        return merge(node, second);
    }
 
    Node merge(Node first, Node second)
    {
        
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }
 
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        }
        else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
	
	//---------------------------------THE LARGEST NODE----------------------------------------------
    static int LargestInDLL(Node head_ref)
    {
        Node max, temp;
        
        temp = max = head_ref;
        
        while (temp != null) {
 
            if (temp.data > max.data)
                max = temp;
 
            temp = temp.next;
        }
        return max.data;
    }
	
	//---------------------------------THE SMALLEST NODE----------------------------------------------

    static int SmallestInDLL(Node head_ref)
    {
        Node min, temp;
 
        temp = min = head_ref;
 
        while (temp != null) {
 
            if (temp.data < min.data)
                min = temp;
 
            temp = temp.next;
        }
        return min.data;
    }
	
	//---------------------------------PALINDROME OR NOT----------------------------------------------
		static boolean isPalindrome(Node left)
	{
		if (left == null)
		return true;
 
		Node right = left;
		while (right.next != null)
        right = right.next;
 
		while (left != right)
		{
			if (left.data != right.data)
				return false;
 
			left = left.next;
			right = right.prev;
		}
 
		return true;
	}
	
	//---------------------------------SIZE OF THE DOUBLY LINKED LIST----------------------------------------------

    static int findSize(Node node)
    {
        int res = 0;
        while (node != null) 
        {
                res++;
                node = node.next;
        }
  
        return res;
    }
	
	//---------------------------------REMOVE DUPLICATE FROM A SORTED, THE DOUBLY LINKED LIST----------------------------------------------
	
    public void removeDuplicates(Node head)
    {

        if (head== null)
            return;
   
        Node current = head;
 
        while (current.next != null)
        {
            
            if (current.data == current.next.data)
               
                deleteNode(head, current.next);
   
            else
                current = current.next;
        } 
          
    }
 
 
 
   public void deleteNode(Node head, Node del)
    {
 
        if(head==null || del==null)
        {
            return ;
        }
        
        if(head==del)
        {
            head=del.next;
        }
        
        if(del.next!=null)
        {
            del.next.prev=del.prev;
        }
       
        if (del.prev != null)
            del.prev.next = del.next;
 
    }
	
	//------------------------------Rotate the doubly linked list--------------------------
	 int size = 0;  
    
    Node tail = null;  
	
	public void addNode(int data) {  
       
        Node newNode = new Node(data);  
  
        
        if(head == null) {  
            
            head = tail = newNode;  
            
            head.prev = null;  
             
            tail.next = null;  
        }  
        else {  
             
            tail.next = newNode;  
           
            newNode.prev = tail;  
            
            tail = newNode;  
              
            tail.next = null;  
        }  
          
        size++;  
    }  
	
	public void rotateList(int n) {  
        
        Node current = head;  
  
        
        if(n == 0 || n >= size)  
            return;  
        else {  
            
            for(int i = 1; i < n; i++)  
                current = current.next;  
  
           
            tail.next = head;               
            head = current.next;           
            head.prev = null;            
            tail = current;   
            tail.next = null;  
        }  
    }
	

	//------------------------------------------------------------------------------------
	static void printList(Node node){
		Node last = null;
		while(node != null){
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		DDL doubly_li = new DDL();
		DDL doubly_li2 = new DDL();
		DDL doubly_li3 = new DDL();  
		
		doubly_li.insertEnd(5);
		doubly_li.insertionFront(1);
		doubly_li.insertionFront(6);
		doubly_li.insertEnd(9);
		doubly_li.insertionAfter(doubly_li.head, 11);
		doubly_li.insertionAfter(doubly_li.head.next, 15);
		doubly_li.insertionAfter(doubly_li.head.next, 15);
		
		System.out.print("Linked List\n");
		doubly_li.printList(doubly_li.head);
		
		
		System.out.print("\n---------------------------------------------");
		
		System.out.println("\nQUICK SORT \nLinked List before sorting");
		doubly_li.printList(doubly_li.head);
		System.out.println("Linked List after sorting ");
		doubly_li.quickSort(doubly_li.head);
		doubly_li.printList(doubly_li.head);
		
		System.out.print("\n---------------------------------------------");
		
		doubly_li2.insertEnd(5);
		doubly_li2.insertionFront(1);
		doubly_li2.insertionFront(6);
		doubly_li2.insertEnd(9);
		doubly_li2.insertionAfter(doubly_li2.head, 11);
		doubly_li2.insertionAfter(doubly_li2.head.next, 15);
		
		System.out.println("\nMERGE SORT \nLinked List before sorting");
		doubly_li2.printList(doubly_li2.head);
		System.out.println("Linked List after sorting ");
		doubly_li2.mergeSort(doubly_li2.head);
		doubly_li2.printList(doubly_li2.head);
		
		System.out.print("\n---------------------------------------------");
		
		System.out.println("\nLARGEST NODE\nLinked List");
		doubly_li.printList(doubly_li.head);
		System.out.printf("Largest Node: " + LargestInDLL(doubly_li.head));
		
		System.out.print("\n\n---------------------------------------------");
		
		System.out.println("\nSMALLEST NODE\nLinked List");
		doubly_li.printList(doubly_li.head);
		System.out.printf("Smallest Node: " + SmallestInDLL(doubly_li.head));
		
		System.out.print("\n\n---------------------------------------------");
		
		System.out.println("\nPALINDROME OR NOT\nLinked List");
		doubly_li.printList(doubly_li.head);
		if (isPalindrome(doubly_li.head))
			System.out.printf("It is Palindrome");
		else
			System.out.printf("Not Palindrome\n");
		
		System.out.print("\n---------------------------------------------");
		System.out.println("\nROTATED THE DOUBLY Linked List");
		doubly_li3.addNode(5);  
        doubly_li3.addNode(1);  
        doubly_li3.addNode(6);  
        doubly_li3.addNode(9);  
        doubly_li3.addNode(11);
		doubly_li3.addNode(15);
		
		System.out.println("Original List: ");  
        doubly_li3.printList(doubly_li3.head);  
  
        //Rotates list by 3 nodes  
        doubly_li3.rotateList(3);  
  
        System.out.println("Rotated List: ");  
        doubly_li3.printList(doubly_li3.head); 
		
		System.out.print("\n---------------------------------------------");
		System.out.println("\nSize of the Doubly Linked List : " + findSize(doubly_li.head));
		
		System.out.print("\n---------------------------------------------");
		
		System.out.println("\nOriginal doubly linked list:");
        doubly_li.printList(doubly_li.head);
 
        /* remove duplicate nodes */
        doubly_li.removeDuplicates(doubly_li.head);
        System.out.println("\nDoubly linked list after removing duplicates:");
        doubly_li.printList(doubly_li.head);
		
		System.out.print("\n---------------------------------------------");
		
		doubly_li3.addNode(5);  
        doubly_li3.addNode(1);  
        doubly_li3.addNode(6);  
        doubly_li3.addNode(9);  
        doubly_li3.addNode(11);
		doubly_li3.addNode(15);
		
		System.out.println("\nOriginal List: ");  
        doubly_li3.printList(doubly_li3.head);  
  
        //Rotates list by 3 nodes  
        doubly_li3.rotateList(3);  
  
        System.out.println("Rotated List: ");  
        doubly_li3.printList(doubly_li3.head); 
		
	}
		
}
