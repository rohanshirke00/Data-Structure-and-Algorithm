
// https://www.geeksforgeeks.org/next-greater-element/
// https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1

import java.util.Arrays;
import java.util.*;
import java.util.Stack;

public class NGETR {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the Elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(ngetr(arr)));
        System.out.println(Arrays.toString(ngetr2(arr)));
    }

    public static int[] ngetr2(int[] arr) {
        
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        nge[arr.length-1] = -1;

        for (int i = arr.length-2; i >=0; i--) {
            while(st.size() > 0 && arr[i] >= st.peek()){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }

        return nge;

    }



    public static int[] ngetr(int[] arr) {
        
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < nge.length; i++) {
            while(st.size() > 0 && arr[i] >= arr[st.peek()]){
                int pos = st.peek();
                nge[pos] = arr[i];
                st.pop();
            }
        
            st.push(i);

        }

        while(st.size() > 0){
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }

        return nge;

    }

}
