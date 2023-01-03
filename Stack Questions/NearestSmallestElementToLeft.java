
// https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallestElementToLeft{
    public static void main(String[] args) {
        int[] arr = {1,4,6,3,5,2};
        int n = arr.length;
        
        //brute force
        // System.out.println(nextSmallerElement1(n, arr));

        //optimal solution
        System.out.println(nextSmallerElement2(n, arr));
    }


    // approach 1 :  brute force solution
    public static List<Integer> nextSmallerElement1(int n, int[] arr){

        List<Integer> list = new ArrayList<>();

        list.add(-1);

        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >=0; j--) {
                if(arr[j] < arr[i]){
                    list.add(arr[j]);
                    break;
                }
            }
        }

        return list;
    }




    // approach 2 ;  optimal solution
     public static List<Integer> nextSmallerElement2(int n, int[] arr) {
         
        List<Integer> list = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(st.size() == 0){
                list.add(-1);
            }
            else if(st.size() > 0 && st.peek() < arr[i]){
                list.add(st.peek());
            }
            else if(st.size() > 0 && st.peek() >= arr[i]){

                while ((st.size() > 0) && (st.peek() >= arr[i])) {
                    st.pop();
                }
                if(st.empty()){
                    list.add(-1);
                }
                else{
                    list.add(st.peek());
                }
            
            }
            st.push(arr[i]);
        }

        return list;

    }

}


