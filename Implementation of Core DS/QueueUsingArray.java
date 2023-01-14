import java.util.Scanner;

public class QueueUsingArray {

    public static class Queue{
    
        int queue[];
        int size;
        int front = -1;
        int rear = -1;
    
        // constructor
        public Queue(int capacity) {
            this.size = capacity;
            queue = new int[size];
        }
    
        // checking overflow
        public boolean overflow() {
            if(rear >= (size - 1)){
                return true;
            }
            return false;
        }
    
        // checking underflow
        public boolean underflow() {
            if((front == -1 && rear == -1) || front > rear){
                return true;
            }
            return false;
        }
        
        // Enqueue function
        public void enqueue(Scanner sc) {
            if(overflow()) {
                System.out.println("\nQueue is Full");
            }
            else {
                System.out.print("Enter data : ");
                int data = sc.nextInt();
                if(front == -1 && rear == -1){
                    front = 0;
                    rear = 0;
                    queue[rear] = data;
                }
                else if(front == 0 && rear == 0){
                    rear = rear + 1;
                    queue[rear] = data;
                }
                else{
                    rear = rear + 1;
                    queue[rear] = data;
                }
                System.out.println("Item (" + data + ") enqueued Successfully!");
            }
        }
        
        // Dequeue function
        public void dequeue() {
            if(underflow()){
                System.out.println("\nQueue is Empty");
            }
            else {
                int popEle = queue[front];
                front = front + 1;
                System.out.println("Item (" + popEle + ") dequeued Successfully!");
            }
        }
        
        // display queue
        public void display() {
            if(underflow()){
                System.out.println("\nQueue is Empty");
            }
            else if(front<=rear) {
                System.out.print("\nQueue : ");
                for (int i = front; i <= rear; i++) {
                    System.out.print(queue[i] + " ");
                }
                System.out.println();
                System.out.println("Front => " + queue[front] + "  &&  Rear => " + queue[rear]);
            }
        }
    
        // check elements present in queue
        public void size(){
            if(underflow()){
                System.out.println("\nNumber of Elements in Queue : " + (0));
            }
            else{
                System.out.println("\nNumber of Elements in Queue : " + (rear - front + 1));
            }
        }

        // Restoring the queue
        public void restartQueue() {
            front = -1;
            rear = -1;
            System.out.println("\nQueue Restarted Successfully");
        }

    
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        	System.out.println("\nWELCOME TO QUEUE DATA STRUCTURE USING ARRAY\n");
		System.out.print(("Enter the size of the Queue : "));
		int n = sc.nextInt();
		Queue que = new Queue(n);
		do {
            		System.out.println();
			System.out.print("Which operation do you want to perform on Queue?\n"
					+ "Press 1 for Enqueue()\n"
					+ "Press 2 for Dequeue()\n"
					+ "Press 3 for Display()\n"
                    + "Press 4 for Size()\n"
                    + "Press 5 for Restart Queue()\n"
                    + "Press 6 for EXIT()\n"
                    + "\nYour Choice :) ");
			int operation = sc.nextInt();
			switch(operation) {
			case 1 :
				que.enqueue(sc);
				break;
			
			case 2 :
                		que.dequeue();
				break;
				
			case 3 :
                		que.display();
				break;
            
            		case 4 :
                		que.size();
                		break;

            		case 5 :
                		que.restartQueue();
                		break;

            		case 6 :
                		System.out.println("Exit Successfully (^__^)");
                		System.exit(0);

			default :
				System.out.println("Invalid choice!");
			}
		}
        	while(true);
	}

}