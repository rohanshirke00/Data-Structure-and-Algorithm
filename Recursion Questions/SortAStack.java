

// https://www.geeksforgeeks.org/sort-a-stack-using-recursion/


import java.util.Scanner;
import java.util.Stack;

public class SortAStack{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of stack : ");
        int size = sc.nextInt();
        
        if(size==0){
            System.out.println("Stack is Empty!");
            System.exit(0);
        }
        
        Stack<Integer> st = new Stack<>();
        System.out.print("Enter Elements in Stack : ");
        for (int i = 0; i < size; i++) {
            st.push(sc.nextInt());
        }

        sortStack(st);
        System.out.print("Sorted Stack is : ");
        while(!st.isEmpty()){
            int ele = st.pop();
            System.out.print(ele + " ");
        }

        sc.close();
    }

    public static void sortStack(Stack<Integer> st){

        if(!st.isEmpty() && st.size() == 1){
            return;
        }

        if(!st.empty()){
            int peek = st.peek();
            st.pop();
            sortStack(st);
            insertPeek(st, peek);
        }
    }

    public static void insertPeek(Stack<Integer> st, int peek){
        if(st.isEmpty() || (st.size() != 0 && st.peek() <= peek)){
            st.push(peek);
            return;
        }

        if(!st.empty()){
            int top = st.peek();
            st.pop();
            insertPeek(st, peek);
            st.push(top);
        }
        return;

    }

}
