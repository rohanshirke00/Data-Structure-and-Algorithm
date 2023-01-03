
// https://www.geeksforgeeks.org/next-greater-element/
// https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterElementToRight{
    public static void main(String[] args) {
        long[] arr = {1,4,6,3,5,2};
        int n = arr.length;
        
        //brute force
        System.out.println(Arrays.toString(nextLargerElement1(arr, n)));

        //optimal solution
        System.out.println(Arrays.toString(nextLargerElement2(arr, n)));
        
    }


    // approach 1 :  brute force solution
    public static long[] nextLargerElement1(long[] arr, int n){

        long[] ans =  new long[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[j] > arr[i]){
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }




    // approach 2 ;  optimal solution
     public static long[] nextLargerElement2(long[] arr, int n) {
         
        long[] ans = new long[n];

        Stack<Long> s = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            if(s.size() == 0){
                ans[i] = -1;
            }
            else if(s.size() > 0 && s.peek() > arr[i]){
                ans[i] = s.peek();
            }
            else if(s.size() > 0 && s.peek() <= arr[i]){

                while ((s.size() > 0) && (s.peek() <= arr[i])) {
                    s.pop();
                }
                if(s.empty()){
                    ans[i] = -1;
                }
                else{
                    ans[i] = s.peek();
                }
            
            }
            s.push(arr[i]);
        }

        return ans;

    }

}


