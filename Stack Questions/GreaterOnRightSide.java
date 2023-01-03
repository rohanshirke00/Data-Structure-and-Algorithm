
// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
// https://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
// https://practice.geeksforgeeks.org/problems/greater-on-right-side4305/1

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class GreaterOnRightSide {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of Array : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the Elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(Arrays.toString(greaterOnRight(arr, n)));
    }

    public static int[] greaterOnRight(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[n-1]);
        arr[n-1] = -1;
        for(int i=n-2; i>=0; i--)
        {
            if(st.size() == 0)
            {
                arr[i] = -1;
                st.push(arr[i]);
            }
            else if(arr[i] > st.peek())
            {
                int val = st.pop();
                st.push(arr[i]);
                arr[i] = val;
            }
            else
            {
                arr[i] = st.peek();
            }
        }
        return arr;
    }
}
