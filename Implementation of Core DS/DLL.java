import java.util.Scanner;

public class DLL {

    // structure of a Node
    public static class Node{
        int data;
        Node prev;
        Node next;
        
        // constructor
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    Node head = null;
    Node tail = null;

    // creation of doubly LinkedList
    public void create(Scanner sc){
        int choice;
        do{
            System.out.print("\nEnter the data (element) to insert : ");
            int data = sc.nextInt();
            Node new_node = new Node(data);
            if(head == null){
                head = new_node;
                tail = new_node;
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
                        head.prev = new_node;
                        new_node.next = head;
                        head = new_node;
                        System.out.println("Element (" + data + ") inserted successfully");
                        break;
                
                    case 2:
                        System.out.print("\nEnter Poition to insert at [[1-based index]] : ");
                        int pos = sc.nextInt();

                        int size = 0;
                        while(temp != null){
                            temp = temp.next;
                            size++;
                        }

                        if(head.next == null && pos==1){
                            head.prev = new_node;
                            new_node.next = head;
                            head = new_node;
                            System.out.println("Element (" + data + ") inserted successfully");
                        }
                        else if(head.next == null && pos == 2){
                            head.next = new_node;
                            new_node.prev = head;
                            tail = new_node;
                            System.out.println("Element (" + data + ") inserted successfully");
                        }
                        else if(pos<= size+1){
                            if(pos == size+1){
                                new_node.prev = tail;
                                tail.next = new_node;
                                tail = new_node;
                            }
                            else{
                                if(pos==1){
                                    new_node.next = head;
                                    head.prev = new_node;
                                    head = new_node;
                                }
                                else{

                                    Node ptr1 = head;
                                    Node ptr2 = head.next;
                                    for (int i = 1; i < pos-1; i++) {
                                        ptr1 = ptr2;
                                        ptr2 = ptr2.next;
                                    }
                                    ptr1.next = new_node;
                                    new_node.prev = ptr1;
                                    ptr2.prev = new_node;
                                    new_node.next = ptr2;
                                    
                                }
                            }
                            System.out.println("Element (" + data + ") inserted successfully");
                        }
                        else{
                            System.out.println("\nPosition is out of range\n"
                            + "you have " + size + " elements in the linked list");
                        }
                        break;
                
                    case 3:
                        new_node.prev = tail;
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
        if(head == null){
            System.out.println("\nList is Empty");
        }
        else{
            Node temp = head;
            System.out.print("\nLinked List is : ");
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
            System.out.println("HEAD => " + head.data);
            System.out.println("TAIL => " + tail.data);
        }
    }
    
    // Delete Function
    public void delete(Scanner sc) {
        int choice;
        do{
            if(head == null){
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
                    head.prev = null;
                    System.out.println("\nElement (" + delEle + ") deleted Successfully");                    
                    break;
                    
                case 2:
                    System.out.print("\nEnter Poition to delete at [[1-based index]] : ");
                    int pos = sc.nextInt();

                    if(head.next == null && pos==1){
                        System.out.println("\nElement (" + head.data + ") deleted Successfully");
                        head = null;
                        tail = null;
                        break;
                    }
                    
                    int size = 0;
                    Node temp = head;
                    while(temp != null){
                        temp = temp.next;
                        size++;
                    }
                    
                    if(pos <= size){
                        Node ptr1 = head;
                        Node ptr2 = ptr1.next;
                        if(ptr2.next == null && pos == 1){
                            head = ptr2;
                            ptr2.prev = null;
                            tail = ptr2;
                            System.out.println("\nElement (" + ptr1.data + ") deleted Successfully");
                        }
                        else if(ptr2.next == null && pos == 2){
                            ptr1.next = null;
                            tail = ptr1;
                            System.out.println("\nElement (" + ptr2.data + ") deleted Successfully");
                        }
                        else{
                            for (int i = 1; i < pos-1; i++) {
                                ptr1 = ptr2;
                                ptr2 = ptr2.next;
                            }
                            if(pos == size){
                                ptr1.next = ptr2.next;
                                tail = ptr1;
                            }
                            else{
                                ptr1.next = ptr2.next;
                                ptr2.prev = ptr1;
                            }
                            System.out.println("\nElement (" + ptr2.data + ") deleted Successfully");
                        }
                        
                    }
                    else{
                        System.out.println("\nPosition is out of range\n"
                        + "you have " + size + " elements in the linked list");
                    }
                    break;
                    
                case 3:
                    if(head.next == null){
                        System.out.println("\nElement (" + head.data + ") deleted Successfully");
                        head = null;
                        tail = null;
                    }
                    else{
                        int deleEle = tail.data;
                        tail = tail.prev;
                        tail.next = null;
                        System.out.println("\nElement (" + deleEle + ") deleted Successfully");  
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

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("\nWELCOME TO DODUBLY LINKEDLIST");
        DLL dll = new DLL();
        do{
            System.out.print("\nWhich Operation do you want to perform on DLL ?\n"
            + "Press 1 => Insert()\n"
            + "Press 2 => Delete()\n"
            + "Press 3 => Display\n"
            + "Press 4 => Exit()\n"
            + "\nYour Choice :)  ");
            
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    dll.create(sc);
                    break;
                case 2:
                    dll.delete(sc);
                    break;
                case 3:
                    dll.display();
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
