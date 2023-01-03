
// https://leetcode.com/problems/trapping-rain-water/
// https://www.geeksforgeeks.org/trapping-rain-water/
// https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1/

import java.util.Scanner;

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.print("Enter Elements of Array : ");
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        int storedWater = trapRainWater(A,n);
        System.out.print("Rain water Stored is : " + storedWater);
    }

    public static int trapRainWater(int[] A, int n) {
        
        int maxL = A[0];
        int maxR = A[n-1];
        
        int[] left = new int[n];
        left[0] = maxL;

        for (int i = 1; i < n; i++) {

            if(A[i] <= left[i-1]){
                left[i] = left[i-1];
            } else{
                left[i] = A[i];
            }
        }

        
        int[] right = new int[n];
        right[n-1] = maxR;
        for (int i = n-2; i >= 0; i--) {
            if(A[i] < right[i+1]){
                right[i] = right[i+1];
            }else{
                right[i] = A[i];
            }
        }

        int[] water = new int[n];
        int sumOfWater = 0;
        for (int i = 0; i < water.length; i++) {
            water[i] = Math.min(left[i], right[i]) - A[i];
            sumOfWater += water[i];
        }

        return sumOfWater;
    }
}
