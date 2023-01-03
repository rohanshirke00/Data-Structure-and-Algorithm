
// https://leetcode.com/problems/valid-parentheses/
// https://takeuforward.org/data-structure/check-for-balanced-parentheses/

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String str = sc.nextLine();
        
        if(balancedBraces(str))
        {
            System.out.println("Brackets are balanced");
        }
        else
        {
            System.out.println("Brackets are not balanced");
        }

    }


    /*
    
    public static boolean balancedBraces(String str){
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
            {
                st.push(ch);
            }
            else if(ch == ')')
            {
                if(st.size() == 0)
                {
                    return false;
                }
                else if(st.peek() == '(')
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }
            else if(ch == ']')
            {
                if(st.size() == 0)
                {
                    return false;
                }
                else if(st.peek() == '[')
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }
            else if(ch == '}')
            {
                if(st.size() == 0)
                {
                    return false;
                }
                else if(st.peek() == '{')
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        if(st.size() != 0){
            return false;
        }
        return true;
    } 

    */

    public static boolean balancedBraces(String str) {
        
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
            {
                st.push(ch);
            }
            else if(ch == ')')
            {
                boolean valid = handleClosing(st, '(');
                if(valid == false)
                {
                    return false;
                }
            }
            else if(ch == '}')
            {
                boolean valid = handleClosing(st, '{');
                if(valid == false)
                {
                    return false;
                }
            }
            else if(ch == ']')
            {
                boolean valid = handleClosing(st, '[');
                if(valid == false)
                {
                    return false;
                }
            }
        }

        if(st.size()==0)
        {
            return true;
        }
        return false;

    }

    public static boolean handleClosing(Stack<Character> st, char correspondingOpeningChar) {
        
        if(st.size() == 0)
        {
            return false;
        }
        else if(st.peek() != correspondingOpeningChar)
        {
            return false;
        }
        else
        {
            st.pop();
            return true;
        }

    }

}
