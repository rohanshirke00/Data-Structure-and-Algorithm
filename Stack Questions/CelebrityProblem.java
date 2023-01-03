
// https://leetcode.com/problems/find-the-celebrity/
// https://www.geeksforgeeks.org/the-celebrity-problem/
// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        
        System.out.println("Enter only 0's and 1's");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of people in a party : ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter 0's or 1's in " + i + " row : ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        
        celebrity(arr);

    }

    public static void celebrity(int[][] arr) {

        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while(st.size() >= 2)
        {
            int i = st.pop();
            int j = st.pop();
            
            if(arr[i][j] == 1)
            {
                // i is not a celebrity
                st.push(j);
            }
            else
            {
                // j is not a celebrity
                st.push(i);
            }

        }

        int potAns = st.pop();
        for (int i = 0; i < arr.length; i++) {
            if(i != potAns)
            {
                if(arr[potAns][i] == 1 || arr[i][potAns] == 0)
                {
                    System.out.println("None of the people is a celebrity");
                    return;
                }
            }    
        }

        System.out.println(potAns + " is the celebrity");

    }
}
