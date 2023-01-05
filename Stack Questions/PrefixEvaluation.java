import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluation {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Prefix Expression : ");
        String exp = sc.nextLine();

        evaulatePrefixExp(exp);
    
    }

    public static void evaulatePrefixExp(String exp) {

        Stack<Integer> valStack = new Stack<>();
        Stack<String> infStack = new Stack<>();
        Stack<String> postStack = new Stack<>();

        for (int i = exp.length() -1; i >= 0; i--) {

            char ch = exp.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                
                int val1 = valStack.pop();
                int val2 = valStack.pop();
                int val = operation(val1, val2, ch);
                valStack.push(val);

                String infVal1 = infStack.pop();
                String infVal2 = infStack.pop();
                String infVal = "(" + infVal1 + ch + infVal2 + ")";
                infStack.push(infVal);

                String postVal1 = postStack.pop();
                String postVal2 = postStack.pop();
                String postVal = postVal1 + postVal2 + ch;
                postStack.push(postVal);

            }
            else{

                valStack.push(ch - '0');
                infStack.push(ch + "");
                postStack.push(ch + "");
                
            }

        }

        System.out.println("Prefix Evaluation : " + valStack.peek());
        System.out.println("Prefix to Infix : " + infStack.peek());
        System.out.println("Prefix to Postfix : " + postStack.peek());

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
