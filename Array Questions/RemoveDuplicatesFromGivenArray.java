
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.Scanner;
public class RemoveDuplicatesFromGivenArray {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter Elements in array : ");
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Plus one Array is : " + removeDuplicates(arr));

    }

    public static int removeDuplicates(int[] nums) {

        if(nums.length==0) return 0;
        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
        
    }

}
