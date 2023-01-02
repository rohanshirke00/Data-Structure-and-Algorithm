
// https://leetcode.com/problems/set-matrix-zeroes/
// https://takeuforward.org/data-structure/set-matrix-zero/

import java.util.Arrays;
import java.util.Scanner;

public class SetMatrixZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows and columns m x n : ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];

        System.out.println("Enter elements : ");
        for (int i = 0; i < m; i++) {
            System.out.println("Enter row "+ i +" :");
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //approach 1
        setMatrixZero(arr);
        
        //approach 2
        // setMatrixZero2(arr);
        
        //approach 3
        // setMatrixZero3(arr);

        //approach 4
        // setMatrixZero4(arr);

        System.out.println("\noutput : \n");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        
    }



    //approach 1 : Assuming the matrix contain non-negative integers
    //firt traverse the metrix and find an element with 0, if it is then change all of its rows and col to -1
    //Again Traverse the matrix and replace all -1 and 0 to 0.
    //NOTE :  we are not changing to 0 directly because it might affect other rows and cols.

    static void setMatrixZero(int[][] arr){
        
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if(arr[i][j] == 0){

                    int idx = i-1;
                    while(idx >= 0){
                        if(arr[idx][j] != 0){
                            arr[idx][j] = -1;
                        }
                        idx--;
                    }

                    idx = i+1;
                    while(idx < rows){
                        if(arr[idx][j] != 0){
                            arr[idx][j] = -1;
                        }
                        idx++;
                    }

                    idx = j-1;
                    while(idx >= 0){
                        if(arr[i][idx] !=0){
                            arr[i][idx] = -1;
                        }
                        idx--;
                    }

                    idx = j+1;
                    while(idx < cols){
                        if(arr[i][idx] !=0){
                            arr[i][idx] = -1;
                        }
                        idx++;
                    }

                }

            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(arr[i][j] <= 0){
                    arr[i][j] = 0;
                }
            }
        }
    }




    //approach 2
    // instead of traversing the matrix we can create 2 dummy 1D arrays
    //one for row and 1 for col they will store 0 value for that row and col has an element with 0
    //After that we will check in dummy arrays if they contain value 0 for particular row or col,
    // then we simpliy make the row and col as 0

    static void setMatrixZero2(int[][] arr){

        int rows = arr.length;
        int cols = arr[0].length;
        int[] dummyRow = new int[rows];
        int[] dummyCol = new int[cols];
        
        Arrays.fill(dummyRow, -1);
        Arrays.fill(dummyCol, -1);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(arr[i][j] == 0){
                    dummyRow[i] = 0;
                    dummyCol[j] = 0;
                }
                
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(dummyRow[i] == 0 || dummyCol[j] == 0){
                    arr[i][j] = 0;
                }
            }
        }
        
    }



    

    //approach 3
    //Instead of taking two dummy arrays we can use the first row and column of the matrix for the same work. 
    static void setMatrixZero3(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        boolean row0 = false, col0 = false;

        for (int i = 0; i < rows; i++) {
            if(arr[i][0] == 0) col0 = true;
        }
        for (int j = 0; j < cols; j++) {
            if(arr[0][j] == 0) row0 = true;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if(arr[i][j] == 0)
                    arr[i][0] = arr[0][j] = 0;
            }
        }
        
        for (int i = 1; i < rows; i++) {
            if(arr[i][0] == 0){
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < cols; j++) {
            if(arr[0][j] == 0){
                for (int i = 0; i < rows; i++) {
                    arr[i][j] = 0;
                }
            }
        }

        if(row0){
            for (int j = 0; j < cols; j++) {
                arr[0][j] = 0;
            }
        }
        if(col0){
            for (int i = 0; i < rows; i++) {
                arr[i][0] = 0;
            }
        }

    }





    // approach 4
    /* 
    
    Instead of taking two separate dummy array,take first row and column of the matrix as the array for checking whether the particular column or row has the value 0 or not.Since matrix[0][0] are overlapping.Therefore take separate variable col0(say) to check if the 0th column has 0 or not and use matrix[0][0] to check if the 0th row has 0 or not.Now traverse from last element to the first element and check if matrix[i][0]==0 || matrix[0][j]==0 and if true set matrix[i][j]=0,else continue.

    */
    static void setMatrixZero4(int[][] matrix){

        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }

    }


}