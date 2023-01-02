
// https://leetcode.com/problems/rotate-image/
// https://takeuforward.org/data-structure/rotate-image-by-90-degree/

import java.util.Arrays;

public class RotatedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
       
        //Brute force
        // matrix = rotatedMatrix(matrix);



        // Optimal
        matrix = rotatedMatrix2(matrix);

        for (int[] row : matrix) {
            System.out.print(Arrays.toString(row));
            System.out.println();
        }
    }

    //brute force
    // T-> O(N^2)    S -> O(N^2)
    static int[][] rotatedMatrix(int[][] matrix){
        int n= matrix.length;
        int[][] rotatedMatrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[j][n-i-1] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }


    /*
        Optimal  T-> O(N^2)    S -> O(1)
           
        By observation, we see that the first column of the original matrix is the reverse of the first
        row of the rotated matrix, so that’s why we transpose the matrix and then reverse each row,
        and since we are making changes in the matrix itself space complexity gets reduced to O(1).
     */
    static int[][] rotatedMatrix2(int[][] matrix){
        int n= matrix.length;

        // transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reversing the row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        return matrix;
    }
}
