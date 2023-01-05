import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Postfix Expression : ");
        String exp = sc.nextLine();

        evaulatePostfixExp(exp);
    
    }

    public static void evaulatePostfixExp(String exp) {

        Stack<Integer> valStack = new Stack<>();
        Stack<String> infStack = new Stack<>();
        Stack<String> prefStack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {    
            char ch = exp.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){

                int val2 = valStack.pop();
                int val1 = valStack.pop();
                int val = operation(val1, val2, ch);
                valStack.push(val);

                String infVal2 = infStack.pop();
                String infVal1 = infStack.pop();
                String infVal = "(" + infVal1 + ch + infVal2 + ")";
                infStack.push(infVal);

                String prefVal2 = prefStack.pop();
                String prefVal1 = prefStack.pop();
                String prefVal = ch + prefVal1 + prefVal2;
                prefStack.push(prefVal);

            }
            else{
                valStack.push(ch - '0');
                infStack.push(ch + "");
                prefStack.push(ch + "");
            }

        }
    
        System.out.println("Postfix Evaluation : " + valStack.peek());
        System.out.println("Postfix to Infix : " + infStack.peek());
        System.out.println("Postfix to Prefix : " + prefStack.peek());

    }

    public static int operation(int val1, int val2, char op) {
        if(op == '+'){
            return val1 + val2;
        }else if(op == '-'){
            return val1 - val2;
        }else if(op == '*'){
            return val1 * val2;
        }else{
            return val1 / val2;
        }
    }
}
