
// https://www.geeksforgeeks.org/convert-infix-prefix-notation/
// https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/

import java.util.Scanner;
import java.util.Stack;

public class InfixConversion {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Expression : ");
        String infixExp = sc.nextLine();

        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> optors = new Stack<>();

        for (int i = 0; i < infixExp.length(); i++) 
        {
            char ch = infixExp.charAt(i);
            if(ch == '(')
            {
                optors.push(ch);
            }
            else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            {
                prefix.push(ch + "");
                postfix.push(ch + "");
            }
            else if(ch == ')')
            {
                while(optors.peek() != '(')
                {
                    char optor = optors.pop();
                    String prefv2 = prefix.pop();
                    String prefv1 = prefix.pop();
                    String prefv = optor + prefv1 + prefv2;
                    prefix.push(prefv);

                    String postfv2 = postfix.pop();
                    String postfv1 = postfix.pop();
                    String postfv = postfv1 + postfv2 + optor;
                    postfix.push(postfv);

                }
                optors.pop();
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while(optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek()))
                {
                    char optor = optors.pop();
                    String prefv2 = prefix.pop();
                    String prefv1 = prefix.pop();
                    String prefv = optor + prefv1 + prefv2;
                    prefix.push(prefv);
                    
                    String postfv2 = postfix.pop();
                    String postfv1 = postfix.pop();
                    String postfv = postfv1 + postfv2 + optor;
                    postfix.push(postfv);

                }
                optors.push(ch);
                
            }

        }
        
        while(optors.size() != 0)
        {
            char optor = optors.pop();
            String prefv2 = prefix.pop();
            String prefv1 = prefix.pop();
            String prefv = optor + prefv1 + prefv2;
            prefix.push(prefv);

            String postfv2 = postfix.pop();
            String postfv1 = postfix.pop();
            String postfv = postfv1 + postfv2 + optor;
            postfix.push(postfv);

        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());

    }

    public static int precedence(char optor) {
        if(optor == '+' || optor == '-')
        {
            return 1;
        }
        else if(optor == '*' || optor == '/')
        {
            return 2;
        }
        return 0;
    }
}