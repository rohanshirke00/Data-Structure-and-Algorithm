
import java.util.Scanner;

public class CircularQueueUsingArray {

    public static class CircularQueue{
    
        int queue[];
        int size;
        int front = -1;
        int rear = -1;
        int numberOfEle = 0;
    
        // constructor
        public CircularQueue(int capacity) {
            this.size = capacity;
            queue = new int[size];
        }
    
        // checking overflow
        public boolean overflow() {
            if((front==0 && rear == size-1) || (rear+1) == front){
                return true;
            }
            return false;
        }
    
        // checking underflow
        public boolean underflow() {
            if((front == -1 && rear == -1)){
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
                }
                else if(rear == size-1){
                    rear = 0;
                }
                else{
                    rear = rear + 1;
                }
                queue[rear] = data;
                numberOfEle++;
                System.out.println("Item (" + data + ") enqueued Successfully!");
            }
        }
        
        // Dequeue function
        public void dequeue() {
            int popEle;
            if(underflow()){
                System.out.println("\nQueue is Empty");
            }
            else{
                popEle = queue[front];
                
                if(front == rear){
                    front = rear = -1;
                    numberOfEle = 0;
                }
                else if(front == size -1){
                    front = 0;
                    numberOfEle--;
                }
                else{
                    front = front + 1;
                    numberOfEle--;
                }
                System.out.println("Item (" + popEle + ") dequeued Successfully!");
            }
        }
        
        // display queue
        public void display() {
            if(underflow()){
                System.out.println("\nQueue is Empty");
            }
            else{

                System.out.print("\nQueue : ");
                if (front>rear) {
                    
                    for (int i = front; i < size; i++) {
                        System.out.print(queue[i] + " ");
                    }

                    for (int i = 0; i <= rear; i++) {
                        System.out.print(queue[i] + " ");
                    }

                    System.out.println("\nFront is at index "+ front + "->" + queue[front] + " and Rear is at index "+ rear + "->" + queue[rear]);
                    
                }
                else{
                    
                    for (int i = front; i <= rear; i++) {
                        System.out.print(queue[i] + " ");
                    }
                    System.out.println("\nFront is at index "+ front + "->" + queue[front] + " and Rear is at index "+ rear + "->" + queue[rear]);

                }
            
            }
        }
    
        // check elements present in queue
        public void size(){
            System.out.println("\nNumber of Elements in Queue : " + numberOfEle);
        }

        // Restoring the queue
        public void restartQueue() {
            front = -1;
            rear = -1;
            numberOfEle = 0;
            System.out.println("\nQueue Restarted Successfully");
        }

    
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("\nWELCOME TO CIRCULAR-QUEUE DATA STRUCTURE USING ARRAY\n");
		System.out.print(("Enter the size of the Queue : "));
		int n = sc.nextInt();
		CircularQueue que = new CircularQueue(n);
		do {
            System.out.println();
			System.out.print("Which operation do you want to perform on Cicrular Queue?\n"
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
