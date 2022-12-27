
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

import java.util.Arrays;
import java.util.Scanner;

public class NumberSmallerThanElement {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.print("Enter elements in array : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {


        // brute force solution
        // int n = nums.length;
        // int[] ans = new int[n];

        // for(int i=0; i<n; i++){
        //     int count=0;
        //     for(int j=0; j<n; j++){
        //         if(nums[i]>nums[j])
        //             count++;
        //     }
        //     ans[i] = count;
        // }

        // return ans;



        //optimal solution
        int n = nums.length;
        int[] ans = new int[n];
        int[] temp = new int[101];

        //store frequency
        for (int i = 0; i < n; i++) {
            temp[nums[i]]++;
        }

        //running sum
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i-1];
        }

        //storing ans
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) 
                ans[i] = 0;
            else 
                ans[i] = temp[nums[i] - 1];
        }

        return ans;
        
    }

}
