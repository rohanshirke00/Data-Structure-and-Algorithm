import java.util.Scanner;

public class StackUsingArray {

    public static class Stack{
    
        int top;
        int stack[];
        Scanner sc = new Scanner(System.in);

        // constructor
        public Stack(int capacity) {
            stack = new int[capacity];
            top = -1;
        }
    
        // checking overflow
        public boolean overflow() {
            if(top == stack.length -1){
                return true;
            }
            return false;
        }

        // checking underflow
        public boolean underflow() {
            if(top == -1){
                return true;
            }
            return false;
        }
    
        // push function
        public void push() {
            if(overflow()) {
                System.out.println("Stack is Full");
            }
            else {
                System.out.print("Enter data : ");
                int data = sc.nextInt();
                top++;
                stack[top] = data;
                System.out.println("Item (" + data + ") Pushed Successfully!");
            }
        }
    
        // pop function
        public void pop() {
            if(underflow()){
                System.out.println("Stack is Empty");
            }
            else {
                int popEle = stack[top];
                top--;
                System.out.println("Item (" + popEle + ") Popped Successfully!");
            }
        }
        
        // display stack
        public void display() {
            if(underflow()){
                System.out.println("Stack is Empty");
            }
            else {
                System.out.print("Stack is : ");
                for (int i = top; i >= 0; i--) {
                    System.out.print(stack[i] + " ");
                }
                System.out.println();
            }
        }
    
        // check elements present in stack
        public void size(){
            System.out.println("Number of Elements in stack : " + (top + 1));
        }
    
        public void top(){
            if(top == -1){
                System.out.println("Stack is Empty");
            }
            else{
                System.out.println("Stack top is : " + stack[top]);
            }
        }
    
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(("Enter the size of the stack : "));
		int n = sc.nextInt();
		Stack st = new Stack(n);
		int choice;
		do {
            System.out.println();
			System.out.print("Which operation do you want to perform on stack?\n"
					+ "Press 1 for Push()\n"
					+ "Press 2 for Pop()\n"
					+ "Press 3 for Display()\n"
                    + "Press 4 for Stack Top()\n"
                    + "Press 5 for Size()\n"
                    + "Press 6 for EXIT()\n"
                    + "Your Choice :) ");
			int operation = sc.nextInt();
			switch(operation) {
			case 1 :
				st.push();
				break;
			
			case 2 :
                st.pop();
				break;
				
			case 3 :
                st.display();
				break;
			
			case 4 :
                st.top();
				break;
            
            case 5 :
                st.size();
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