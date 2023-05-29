

// https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/


import java.util.Scanner;
import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        Stack<Integer> st = new Stack<>();
        Stack<Integer> dupStack = new Stack<>();

        for (int i = 0; i < size; i++) {
            st.push(sc.nextInt());
            dupStack.push(st.peek());
        }

        System.out.print("Stack is : ");
        while(!dupStack.isEmpty()){
            System.out.print(dupStack.pop() + " ");
        }

        reverse(st);

        System.out.print("\nReverse Stack is : ");
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }

        sc.close();
    }



    public static void reverse(Stack<Integer> st){
        
        if(st.size()==0){
            return;
        }

        int element = st.peek();
        st.pop();
        reverse(st);
        insert(st, element);
    }



    public static void insert(Stack<Integer> st, int element){
            
        if(st.size()==0){
            st.push(element);
            return;
        }

        int val = st.peek();
        st.pop();
        insert(st, element);
        st.push(val);
        return;
    }

}
