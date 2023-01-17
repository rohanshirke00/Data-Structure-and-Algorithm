import java.util.Scanner;

public class QueueUsingLL {

    // structure of the QueueNode
    public static class QueueNode{
        int data;
        QueueNode next;
        QueueNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    // head
    public static QueueNode front = null;

    // tail
    public static QueueNode rear = null;

    // size of the queue
    public static int size = 0;
    
    // Enqueue function
    public void enqueue(Scanner sc) {

        System.out.print("\nEnter data in the queue : ");
        int data = sc.nextInt();
        
        QueueNode node = new QueueNode(data);

        if(front == null && rear == null){
            front = node;
            rear = node;
        }
        else{
            rear.next = node;
            rear = node;
        }
        size++;
        System.out.println("Data (" + data + ") is enqueued successfully");

    }

    // Dequeue function
    public void dequeue() {

        if(underflow()){
            System.out.println("\nQueue is Empty");
        }
        else if(front == rear){
            int data = front.data;
            front = null;
            rear = null;
            size--;
            System.out.println("Data (" + data + ") is dequeued successfully");
        }
        else{
            int data = front.data;
            front = front.next;
            size--;
            System.out.println("Data (" + data + ") is dequeued successfully");
        }
        
    }

    // Display function
    public void display() {

        if(underflow()){
            System.out.println("\nQueue is Empty");
        }
        else{
            System.out.print("\nQUEUE : ");
            QueueNode temp = front;
            while (temp!=null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
            System.out.println("FRONT => " + front.data + "  and  REAR => " + rear.data);
        }
        
    }

    public void size(){
        System.out.println("\nNumber of Elements in the Queue is : " + size);
    }

    // underflow condtion
    public boolean underflow() {
        if(front == null){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWELCOME TO QUEUE DATA STRUCTURE USING LINKEDLIST\n");
        QueueUsingLL queLL = new QueueUsingLL();
		do {
            System.out.println();
			System.out.print("Which operation do you want to perform on Queue?\n"
					+ "Press 1 for Enqueue()\n"
					+ "Press 2 for Dequeue()\n"
					+ "Press 3 for Display()\n"
                    + "Press 4 for Size()\n"
                    + "Press 5 for EXIT()\n"
                    + "\nYour Choice :) ");
			int operation = sc.nextInt();
			switch(operation) {
			case 1 :
				queLL.enqueue(sc);
				break;
			
			case 2 :
                queLL.dequeue();
				break;
				
			case 3 :
                queLL.display();
				break;
            
            case 4 :
                queLL.size();
                break;

            case 5 :
                System.out.println("Exit Successfully (^__^)");
                System.exit(0);

			default :
				System.out.println("Invalid choice!");
			}
		}
        while(true);
    }
}
