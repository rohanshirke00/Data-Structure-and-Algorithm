
// https://www.geeksforgeeks.org/find-expression-duplicate-parenthesis-not/

import java.util.*;

public class DuplicatesBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String str = sc.nextLine();
        
        if(str.charAt(0) == ')')
        {
            System.out.println("Invalid Expression!");
            return;
        }

        if(str.length() == 1 && str.charAt(0) == '(')
        {
            System.out.println("Invalid Expression!");
            return;
        }
        
        if(checkRedundancy(str) == 1)
        {
            System.out.println("Duplicate Brackets : YES");
            return;
        }

        System.out.println("Duplicate Brackets : NO");

    }


    public static int checkRedundancy(String s) {
        
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == ')'){
                if(st.size() > 0 && st.peek() == '('){
                    return 1;
                }
                else if(st.size() > 0){
                    int popCount = 0;
                    while(st.size() > 0 && st.peek() != '('){
                        st.pop();
                        popCount++;
                    }
                    if(popCount == 1){
                        return 1;
                    }
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }
        
        return 0;
        
    }


}
