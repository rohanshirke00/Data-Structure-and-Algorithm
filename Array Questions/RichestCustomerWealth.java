
// https://leetcode.com/problems/richest-customer-wealth/

import java.util.Scanner;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of 2D array m(rows) x n(cols) : ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int arr[][] = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            System.out.println("Enter " + i + " row : ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Richest customer wealth is : " + maximumWealth(arr) );

    }


    public static int maximumWealth(int[][] accounts) {
        
        int ans = Integer.MIN_VALUE;
            
        //using enhanced forloop

        for(int[] peoples : accounts){
            int sum = 0;
            for(int num : peoples) sum += num;
            ans = sum>ans?sum:ans;
        }
        return ans;
        
        
        //method 2 using normal forloop

        // int ans = Integer.MIN_VALUE;
        // for(int i=0; i<accounts.length; i++){
        //     int sum = 0;
        //     for(int j=0; j<accounts[i].length; j++){ 
        //         sum += accounts[i][j];
        //     }
        //     ans = sum>ans?sum:ans;
        // }
        // return ans;
        
    }


}