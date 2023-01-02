
// 1351. Count Negative Numbers in a Sorted Matrix (leetcode)
// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

import java.util.Scanner;

public class CountNegNo {
    public static void main(String[] args) {
        
        System.out.println("Enter Size of array m x n : ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(countNegatives(arr));

    }

    public static int countNegatives(int[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length;
        
        int count=0, p=0;
        
        while(m>=0 && n>p){
            if(grid[m][p]<0){
                m--;
                count = count + n - p;
            }
            else{
                p++;
            }
        }
        return count;

    }

}
