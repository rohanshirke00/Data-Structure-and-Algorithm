import java.util.Scanner;

public class StackUsingLL {

    public static class StackLL{
        
        Node top = null;
        int size = 0;

        // node structure
        static class Node{
            int data;
            Node next;
            Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        // push function
        public void push(Scanner sc){

            System.out.print("Enter data : ");
            int data = sc.nextInt();

            Node new_node = new Node(data);

            if(top == null){
                top = new_node;
            }
            else{
                new_node.next = top;
                top = new_node;
            }
            size++;
            System.out.println("Item (" + data + ") Pushed Successfully!");

        }

        // pop function
        public void pop(){
            if(underflow()){
                System.out.println("Stack is Empty");
            }
            else{
                int popEle = top.data;
                top = top.next;
                size--;
                System.out.println("Item (" + popEle + ") Popped Successfully!");
            }
        }
        
        // diplaying elements in stack
        public void display(){
            if(underflow()){
                System.out.println("Stack is Empty");
            }
            else{
                Node temp = top;
                System.out.print("Stack is : ");
                while(temp != null){
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.println();
                System.out.println("Stack top is : " + top.data);
            }
        }

        // checking size of stack
        public void size(){
            System.out.println("Number of Elements in stack is : " + size);
        }

        // checking underflow
        public boolean underflow(){
            if(top == null){
                return true;
            }
            return false;
        }

    }


    public static void main(String[] args) {
        StackLL st = new StackLL();
        Scanner sc = new Scanner(System.in);
		do {
            System.out.println();
			System.out.print("Which operation do you want to perform on stack?\n"
					+ "Press 1 for Push()\n"
					+ "Press 2 for Pop()\n"
					+ "Press 3 for Display()\n"
                    + "Press 4 for Size()\n"
                    + "Press 5 for EXIT()\n"
                    + "Your Choice :) ");
			int operation = sc.nextInt();
			switch(operation) {
			case 1 :
				st.push(sc);
				break;
			
			case 2 :
                st.pop();
				break;
				
			case 3 :
                st.display();
				break;
            
            case 4 :
                st.size();
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
