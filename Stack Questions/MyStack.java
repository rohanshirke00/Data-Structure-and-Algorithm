package stacks_av;

import java.util.Stack;

// Implementation of minstack using extra space
public class MyStack extends Stack<Integer>{
    
    Stack<Integer> min = new Stack<>();

    void push(int x) {
        if (isEmpty() == true) {
            super.push(x);
            min.push(x);
        }
        else {
            super.push(x);
            int y = min.pop();
            min.push(y);
            if (x < y)
                min.push(x);
            else
                min.push(y);
        }
    }

    public Integer pop() {

        if (isEmpty() == true) {
            return -1;
        }

        int ans = super.pop();
        if(ans == min.peek()){
            min.pop();
        }
        return ans;
    }

    int getMin() {
        if(min.size()==0) return -1;
        return min.peek();
    }

    public static void main(String[] args) {
        
        MyStack s = new MyStack();
        
        System.out.println("minEle : " + s.getMin());
        System.out.println("20 is pushed : ");
        s.push(20);
        System.out.println("Stack : " + s);

        
        System.out.println("minEle : " + s.getMin());
        System.out.println("22 is pushed : ");
        s.push(22);
        System.out.println("Stack : " + s);
        
        
        System.out.println("minEle : " + s.getMin());
        System.out.println("25 is pushed : ");
        s.push(25);
        System.out.println("Stack : " + s);
        
        
        System.out.println("minEle : " + s.getMin());

        System.out.println("POP : " + s.pop());
        
        System.out.println("minEle : " + s.getMin());
        System.out.println("15 is pushed : ");
        s.push(15);
        System.out.println("Stack : " + s);

        
        System.out.println("minEle : " + s.getMin());
        System.out.println("15 is pushed : ");
        s.push(15);
        System.out.println("Stack : " + s);
        
        System.out.println("minEle : " + s.getMin());
        System.out.println("POP : " + s.pop());

        System.out.println("minEle : " + s.getMin());
        
    }

}

