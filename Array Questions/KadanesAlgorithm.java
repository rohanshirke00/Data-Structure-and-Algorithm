
// https://leetcode.com/problems/maximum-subarray/description/
// https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/

import java.util.Scanner;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of Array : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements : ");
        for (int i = 0; i < arr.length; i++) {
          arr[i] = scn.nextInt();
        }
        System.out.println(kadane(arr));
    }


    public static int kadane(int[] arr) {
      
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
    
}
