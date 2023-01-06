import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluationNConversion {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Expression  (No alphabets): ");
        String exp = sc.nextLine();

        evaluateNConvertInfixExp(exp);
    
    }

    public static void evaluateNConvertInfixExp(String exp) {

        Stack<Character> infStackOptr = new Stack<>();
        Stack<Integer> infStackVal = new Stack<>();

        Stack<String> prefStack = new Stack<>();
        Stack<String> postStack = new Stack<>();
        
        for (int i = 0; i < exp.length(); i++) {
            
            char ch = exp.charAt(i);
            if(ch == '('){
                infStackOptr.push(ch);
            }
            else if(ch == ')'){
                while (infStackOptr.size()>0 && infStackOptr.peek()!='(') {
                    
                    char optr = infStackOptr.pop();
                    int val2 = infStackVal.pop();
                    int val1 = infStackVal.pop();
                    int infVal = operation(val1, val2, optr);
                    infStackVal.push(infVal);

                    String prefVal2 = prefStack.pop();
                    String prefVal1 = prefStack.pop();
                    String prefVal = optr + prefVal1 + prefVal2;
                    prefStack.push(prefVal);

                    String postVal2 = postStack.pop();
                    String postVal1 = postStack.pop();
                    String postVal = postVal1 + postVal2 + optr;
                    postStack.push(postVal);

                }
                infStackOptr.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){

                while(infStackOptr.size() > 0 && infStackOptr.peek() != '(' && precedence(ch) <= precedence(infStackOptr.peek())){
                    
                    char optr = infStackOptr.pop();
                    int val2 = infStackVal.pop();
                    int val1 = infStackVal.pop();
                    int infVal = operation(val1, val2, optr);
                    infStackVal.push(infVal);

                    String prefVal2 = prefStack.pop();
                    String prefVal1 = prefStack.pop();
                    String prefVal = optr + prefVal1 + prefVal2;
                    prefStack.push(prefVal);

                    String postVal2 = postStack.pop();
                    String postVal1 = postStack.pop();
                    String postVal = postVal1 + postVal2 + optr;
                    postStack.push(postVal);

                }

                infStackOptr.push(ch);

            }
            else{
                infStackVal.push(ch - '0');
                prefStack.push(ch + "");
                postStack.push(ch + "");
            }
            
        }

        while(infStackOptr.size() > 0){
                    
            char optr = infStackOptr.pop();
            int val2 = infStackVal.pop();
            int val1 = infStackVal.pop();
            int infVal = operation(val1, val2, optr);
            infStackVal.push(infVal);

            String prefVal2 = prefStack.pop();
            String prefVal1 = prefStack.pop();
            String prefVal = optr + prefVal1 + prefVal2;
            prefStack.push(prefVal);

            String postVal2 = postStack.pop();
            String postVal1 = postStack.pop();
            String postVal = postVal1 + postVal2 + optr;
            postStack.push(postVal);

        }

        System.out.println("Infix Evaluation : " + infStackVal.peek());
        System.out.println("Infix to Prefix : " + prefStack.peek());
        System.out.println("Infix to Postfix : " + postStack.peek());



    }


    public static int precedence(char optor) {

        if(optor == '+')
        {
            return 1;
        }
        else if(optor == '-')
        {
            return 1;
        }
        else if(optor == '*')
        {
            return 2;
        }
        else
        {
            return 2;
        }
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
