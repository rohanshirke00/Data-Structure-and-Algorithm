
// https://leetcode.com/problems/plus-one/

import java.util.Arrays;
import java.util.Scanner;

public class PlusOneToArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter Elements in array : ");
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Plus one Array is : " + Arrays.toString(plusOne(arr)));

    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for(int i=n-1; i>=0; i--){
            
            //checking if number is 9 or not
            if(digits[i]+1<=9){
                digits[i]++;
                return digits;
            }
            //adding zero when it is above 9
            digits[i]=0;
        }
        
        int[] arr = new int[n+1];
        arr[0] = 1;
        
        return arr;
    }


}
