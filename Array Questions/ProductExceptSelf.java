
// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter Elements in array : ");
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Prouct Array except self : " + Arrays.toString(productExceptSelf(arr)) );

    }

    /*
    
    
    public static int[] productExceptSelf(int[] nums) {
        //creating an array for storing the products
        int[] sol = new int[nums.length];
        int mul=1;
        for(int i=0; i<nums.length; i++){
            mul=1;
            for(int j=0; j<nums.length; j++){
                
                if(i==j){
                    continue;
                }
                else{
                    mul = mul * nums[j];
                }
            }
            sol[i] = mul;
            
        }
        return sol;
    }
    
    */
 
    
    // optimal
    public static int[] productExceptSelf(int[] nums) {
        //creating an array for storing the products
        int L[] = new int[nums.length];
        Arrays.fill(L, 1);
        
        int R[] = new int[nums.length];
        Arrays.fill(R, 1);
        
        for (int i = 1; i < L.length; i++) {
            L[i] = L[i-1] * nums[i-1];
        }

        for (int i = R.length-2; i >= 0; i--) {
            R[i] = R[i+1] * nums[i+1];
        }

        int res[] = new int[nums.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = L[i] * R[i];
        }

        return res;
        
    }
    
}
