
// https://leetcode.com/problems/running-sum-of-1d-array/

import java.util.Arrays;
import java.util.Scanner;

public class RunningSumOf1DArray {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter Elements in array : ");
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(runningSum(arr)));


    }

    // T = O(n)
    // S = O(1)
    public static int[] runningSum(int[] nums) {

        int n = nums.length;
        for(int i = 1; i<n; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;

    }

}
