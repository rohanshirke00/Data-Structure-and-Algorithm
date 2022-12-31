
// https://leetcode.com/problems/maximum-subarray/

import java.util.*;

public class MaximumSubArray{

  public static int maxSubArray(int[] arr) {
      
    int currentBest = arr[0];
    int overAllBest = arr[0];
    
    for(int i=1; i< arr.length; i++){
        
        if(currentBest > 0){
            currentBest += arr[i];
        }
        else{
            currentBest = arr[i];
        }
        
        if(currentBest > overAllBest){
            overAllBest = currentBest;
        }
        
    }

    return overAllBest;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter the size of Array");
    int n = scn.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the Elements : ");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(maxSubArray(arr));
  }
}