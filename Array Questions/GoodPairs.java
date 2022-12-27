
// https://leetcode.com/problems/number-of-good-pairs/

import java.util.Scanner;

public class GoodPairs {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter Elements in array : ");
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Pairs : " + numIdenticalPairs(arr));
    
    }


    public static int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[j]==nums[i]){
                    count++;
                }
                
            }   
        }
        return count;
    }

}
