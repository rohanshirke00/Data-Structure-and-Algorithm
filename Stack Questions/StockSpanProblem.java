
// https://www.geeksforgeeks.org/the-stock-span-problem/
// https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of Stocks : ");
        int n = scn.nextInt();
        int[] stock = new int[n];
        System.out.print("Enter the Elements (Stocks) : ");
        for (int i = 0; i < stock.length; i++) {
            stock[i] = scn.nextInt();
        }

        // Easy (Aditya verma)
        // System.out.println(Arrays.toString(calculateSpan(stock, n)));

        // Tricky (Rohan Shirke)
        System.out.println(Arrays.toString(calculateSpan1(stock, n)));


        // Tricky (Pepcoding)
        System.out.println(Arrays.toString(calculateSpan2(stock, n)));
    }




    // Easy
    public static int[] calculateSpan(int[] stock, int n){

        // nearest greatest to Left
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(st.size() == 0){
                span[i] = -1;
            }
            else if(st.size() > 0 && stock[i] < stock[st.peek()]){
                span[i] = st.peek();
            }
            else if(st.size() > 0 && stock[i] >= stock[st.peek()]){
                
                while ((st.size() > 0) && (stock[i] >= stock[st.peek()])) {
                    st.pop();
                }
                if(st.empty()){
                    span[i] = -1;
                }
                else{
                    span[i] = st.peek();
                }
                
            }
            st.push(i);
        }

        for (int i = 0; i < span.length; i++) {
            span[i] = i - span[i];
        }

        return span;

    }






    // Tricky
    public static int[] calculateSpan1(int[] stock, int n)
    {
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(st.size() == 0){
                ans[i] = i+1;
            }
            else if(st.size() > 0 && stock[i] < stock[st.peek()]){
                ans[i] = i - st.peek();
            }
            else if(st.size() > 0 && stock[i] >= stock[st.peek()]){
                while ((st.size() > 0) && (stock[i] >= stock[st.peek()])) {
                    st.pop();
                }
                if(st.empty()){
                    ans[i] = i+1;
                }
                else{
                    ans[i] = i - st.peek();
                }
            
            }
            st.push(i);
        }

        return ans;
    }





    
    // Tricky
    public static int[] calculateSpan2(int[] arr, int n) {

        int[] span = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                span[i] = i+1;
            }else{
                span[i] = i - st.peek();
            }
            st.push(i);
        }
        return span;
    }


}
