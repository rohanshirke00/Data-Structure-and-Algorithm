
// https://leetcode.com/problems/build-array-from-permutation/

import java.util.Arrays;
import java.util.Scanner;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter Elements in array : ");
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(buildArray(arr)));


    }


    // T = O(n)
    // S = O(n)
    public static int[] buildArray(int[] nums) {
        int ans = 0;
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans = nums[nums[i]];
            arr[i] = ans;
        }
        return arr;    
    }

    // T = O(n)
    // S = O(1)
    // public static int[] buildArray(int[] nums) {

    //     int n = nums.length;
    //     for(int i=0; i<n; i++){
    //         nums[i] = n * (nums[nums[i]] % n) + nums[i];
    //     }
        
    //     for(int i=0; i<n; i++){
    //         nums[i] = nums[i]/n;
    //     }
        
    //     return nums;   
    // }

}
