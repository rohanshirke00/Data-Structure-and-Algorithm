
// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

import java.util.Arrays;
import java.util.Scanner;

public class FindUniqueIntegersSumUpToZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        System.out.print("Array sum upto zero : " + Arrays.toString(sumZero(n)));
       
    }

    public static int[] sumZero(int n) {
        int num = 1;
        int[] arr = new int[n];
        for(int i=0; i<n/2; i++){
            arr[i] = num;
            arr[n-1-i] = -(num);
            num++;
        }
        if(n%2!=0){
            arr[n/2] = 0;
        }
        return arr;
    }
    
}
