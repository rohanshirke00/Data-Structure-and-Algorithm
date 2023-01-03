package stacks_av;

import java.util.Stack;

// Implementation of minstack using O(1) space
public class MinStack {

    Stack<Integer> s;
    int  minEle;
    MinStack(){
        s = new Stack<Integer>();
    }

    void getMin(){
        if(s.isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Minimum element in the stack is : " + minEle);
        }
    }

    void peek(){
        if(s.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        Integer top = s.peek();
        System.out.print("Top most element in the stack is : ");
        if(top < minEle) {
            System.out.println(minEle);
        }else{
            System.out.println(top);
        }
    }

    void push(Integer x){
        if(s.isEmpty()){
            s.push(x);
            minEle = x;
            System.out.println("Element inserted : " + x);
            return;
        }
        if(x >= minEle){
            s.push(x);
        }
        else{
            s.push(2*x - minEle);
            minEle = x;
        }
        System.out.println("Element inserted : " + x);
    }

    void pop(){
        if(s.isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        System.out.print("Top most element removed : ");
        Integer top = s.peek();
        Integer ans;
        if(top<minEle){
            ans = minEle;
            System.out.println(ans);
            minEle = 2*minEle - top;
            s.pop();
        }else{
            ans = top;
            s.pop();
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        
        MinStack s = new MinStack();
        s.getMin();
        s.push(5);
        s.push(6);
        s.push(3);
        s.push(8);
        s.getMin();
        s.pop();
        s.getMin();
        s.push(1);
        s.getMin();
        s.peek();
        s.pop();
        s.getMin();
        s.pop();
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();

    }
}
