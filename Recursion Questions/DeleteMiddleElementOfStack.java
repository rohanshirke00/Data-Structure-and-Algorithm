

// https://www.geeksforgeeks.org/delete-middle-element-stack/


import java.util.Scanner;
import java.util.Stack;

public class DeleteMiddleElementOfStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of stack : ");
        int size = sc.nextInt();
        
        if(size==0){
            System.out.println("Stack is Empty!");
            System.exit(0);;;;
        }
        
        Stack<Integer> st = new Stack<>();
        System.out.print("Enter Elements in Stack : ");
        for (int i = 0; i < size; i++) {
            st.push(sc.nextInt());
        }
        
        if(st.size()==1){
            st.pop();
            System.out.println("Stack is Empty!");
            System.exit(0);
        }

        if(st.size()==2){
            int ele = st.pop();
            st.pop();
            st.push(ele);
            System.out.print("Stack After deleteing middle element : " + st.peek());
            System.exit(0);
        }

        deleteMidElement(st,(size/2)+1);
        System.out.print("[Top] => : " + st.peek());
        System.out.print("\nStack After deleteing middle element : ");
        while(!st.isEmpty()){
            int ele = st.pop();
            System.out.print(ele + " ");
        }

        sc.close();
    }




    public static void deleteMidElement(Stack<Integer> st, int loc){
        if(loc == 1){
            st.pop();
            return;
        }
        int peek = st.pop();
        deleteMidElement(st, --loc);
        st.push(peek);
    }

}
