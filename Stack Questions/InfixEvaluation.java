
// https://www.geeksforgeeks.org/expression-evaluation/
// https://youtu.be/IY0nZLEg6MA

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Expression : ");
        String exp = sc.nextLine();

        evaulateExp(exp);

    }

    public static void evaulateExp(String exp) {

        Stack<Integer> oprnds = new Stack<>();
        Stack<Character> optors = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            
            char ch = exp.charAt(i);
            if(ch == '(')
            {
                optors.push(ch);
            }
            else if(Character.isDigit(ch))
            {
                oprnds.push(ch - '0');
            }
            else if(ch == ')')
            {
                while(optors.size() > 0 && optors.peek() != '(')
                {
                    char optor = optors.pop();
                    int val2 = oprnds.pop();
                    int val1 = oprnds.pop();

                    int opVal = operation(val1, val2, optor);
                    oprnds.push(opVal);
                }
                optors.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while(optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek()))
                {
                    char optor = optors.pop();
                    int val2 = oprnds.pop();
                    int val1 = oprnds.pop();

                    int opVal = operation(val1, val2, optor);
                    oprnds.push(opVal);
                }
                optors.push(ch);
            }
            
        }

        while(optors.size() != 0)
        {
            char optor = optors.pop();
            int val2 = oprnds.pop();
            int val1 = oprnds.pop();

            int opVal = operation(val1, val2, optor);
            oprnds.push(opVal);
        }
        
        System.out.println("Answer is : " + oprnds.peek());
    }


    public static int operation(int val1, int val2, char optor) {

        if(optor == '+')
        {
            return val1 + val2;
        }
        else if(optor == '-')
        {
            return val1 - val2;
        }
        else if(optor == '*')
        {
            return val1 * val2;
        }
        else
        {
            return val1 / val2;
        }

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


}
