import java.util.Scanner;

public class CLL {

    // structure of a Node
    public static class Node{
        int data;
        Node next;
        
        // constructor
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    Node head = null;
    Node tail = null;


    // creation of cirular LinkedList
    public void create(Scanner sc){
        int choice;
        do{
            System.out.print("\nEnter the data (element) to insert : ");
            int data = sc.nextInt();
            Node new_node = new Node(data);
            if(head == null){
                head = new_node;
                tail = new_node;
                tail.next = head;
            }
            else{
                System.out.print("\nwhere you want to insert (" + data + ")\n"
                + "Press 1 => to insert element at beginning\n"
                + "Press 2 => to insert element at specific position\n"
                + "Press 3 => to insert element at the end\n\n"
                + "your choice :)  ");
                
                int insertAt = sc.nextInt();
                Node temp =  head;
                switch(insertAt){
                    case 1:
                        new_node.next = head;
                        head = new_node;
                        tail.next = head;
                        System.out.println("Element (" + data + ") inserted successfully");
                        break;
                
                    case 2:
                        System.out.print("\nEnter Poition to insert at [[1-based index]] : ");
                        int pos = sc.nextInt();

                        int size = 1;
                       do{
                            temp = temp.next;
                            size++;
                        }
                        while(temp.next != head);
                        
                        if(head.next == head && pos==1){
                            new_node.next = head;
                            head = new_node;
                            tail.next = head;
                            System.out.println("Element (" + data + ") inserted successfully");
                        }
                        else if(head.next == head && pos == 2){
                            new_node.next = tail.next;
                            tail.next = new_node;
                            tail = new_node;
                            System.out.println("Element (" + data + ") inserted successfully");
                        }
                        else if(pos<= size+1){
                            if(pos == size+1){
                                new_node.next = tail.next;
                                tail.next = new_node;
                                tail = new_node;
                            }
                            else{
                                Node ptr = head;
                                for (int i = 1; i < pos-1; i++) {
                                    ptr = ptr.next;
                                }
                                new_node.next = ptr.next;
                                ptr.next= new_node;
                            }
                            System.out.println("Element (" + data + ") inserted successfully");
                        }
                        else{
                            System.out.println("\nPosition is out of range\n"
                            + "you have " + size + " elements in the linked list");
                        }
                        break;
                
                    case 3:
                        new_node.next = tail.next;
                        tail.next = new_node;
                        tail = new_node;
                        System.out.println("Element (" + data + ") inserted successfully");
                        break;
                    
                    default:
                        System.out.println("Invalid choice! Element (" + data + ") not inserted anywhere");
                }
            }
            System.out.print("\nPress 1 => To Add another element : ");
            choice = sc.nextInt();
        }while(choice == 1);
    }

    // Display function
    public void display(){
        if(head == null || tail == null){
            System.out.println("\nEmpty List!!!");
        }
        else{
            Node temp = head;
            System.out.print("\nCircular Linked List is : ");

            do{
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            while(temp != head);
            System.out.println();
            System.out.println("HEAD => " + head.data);
            System.out.println("TAIL => " + tail.data);
        }
    }
    
    // Delete Function
    public void delete(Scanner sc) {
        int choice;
        do{
            if(head == null || tail == null){
                System.out.println("\nList is Empty");
                break;
            }
            else{
                System.out.print("\nwhere you want to delete\n"
                + "Press 1 => to delete at beginning\n"
                + "Press 2 => to delete at specific position\n"
                + "Press 3 => to delete at the end\n\n"
                + "your choice :)  ");
                
                int deleteAt = sc.nextInt();
                
                switch (deleteAt) {
                case 1:
                    int delEle = head.data;
                    head = head.next;
                    tail.next = head;
                    System.out.println("\nElement (" + delEle + ") deleted Successfully");                    
                    break;
                    
                case 2:
                    System.out.print("\nEnter Poition to delete at [[1-based index]] : ");
                    int pos = sc.nextInt();

                    if(head.next == head && pos==1){
                        System.out.println("\nElement (" + head.data + ") deleted Successfully");
                        head = null;
                        tail = null;
                        break;
                    }
                    
                    int size = 1;
                    Node temp = head;
                    do{
                        temp = temp.next;
                        size++;
                    }
                    while(temp.next != head);
                    
                    if(pos <= size){
                        Node ptr1 = head;
                        Node ptr2 = ptr1.next;
                        if(ptr2.next == head && pos == 1){
                            head = ptr2;
                            ptr2.next = head;
                            System.out.println("\nElement (" + ptr1.data + ") deleted Successfully");
                        }
                        else if(ptr2.next == head && pos == 2){
                            tail = ptr1;
                            tail.next = head;
                            System.out.println("\nElement (" + ptr2.data + ") deleted Successfully");
                        }
                        else{
                            for (int i = 1; i < pos-1; i++) {
                                ptr1 = ptr2;
                                ptr2 = ptr2.next;
                            }
                            ptr1.next = ptr2.next;
                            System.out.println("\nElement (" + ptr2.data + ") deleted Successfully");
                        }
                        
                    }
                    else{
                        System.out.println("\nPosition is out of range\n"
                        + "you have " + size + " elements in the linked list");
                    }
                    break;
                    
                case 3:
                    if(head.next == head || tail == head){
                        System.out.println("\nElement (" + head.data + ") deleted Successfully");
                        head = null;
                        tail = null;
                    }
                    else{

                        Node ptr1 = head;
                        Node ptr2 = ptr1.next;
                        while(ptr2.next != head){
                            ptr1 = ptr2;
                            ptr2 = ptr2.next;
                        }
                        ptr1.next = head;
                        tail = ptr1;
                        System.out.println("\nElement (" + ptr2.data + ") deleted Successfully");  
                    }
                    break;

                default:
                    System.out.println("Invalid choice! No element was deleted");
                }

            }

            System.out.print("\nPress 1 => To delete another element : ");
            choice = sc.nextInt(); 

        }
        while(choice == 1);
    }



    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWELCOME TO CIRCULAR LINKEDLIST");
        CLL cll = new CLL();
        do{
            System.out.print("\nWhich Operation do you want to perform on CLL ?\n"
            + "Press 1 => Insert()\n"
            + "Press 2 => Delete()\n"
            + "Press 3 => Display\n"
            + "Press 4 => Exit()\n"
            + "\nYour Choice :)  ");
            
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    cll.create(sc);
                    break;
                case 2:
                    cll.delete(sc);
                    break;
                case 3:
                    cll.display();
                    break;
                case 4:
                    System.out.println("EXIT Successfully (^_^)");
                    System.exit(0);
                default:
                    System.out.println("Invalid operation!");
                    break;
            }
        }
        while(true);

    }
}
