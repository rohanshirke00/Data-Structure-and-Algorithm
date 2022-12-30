import java.util.Scanner;

// https://leetcode.com/problems/matrix-diagonal-sum/

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Matrix n X n: ");
        int n = sc.nextInt();

        int matrix[][] = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + i + " row : ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        System.out.print("Sum of Diagonal is : " + diagonalSum(matrix));

    }

    public static int diagonalSum(int[][] mat){
        int sum = 0;
        for(int i=0; i<mat.length; i++){
            sum += mat[i][i] + mat[i][mat.length-1-i];
        }
        
        if(mat.length%2!=0){
            sum -= mat[mat.length/2][mat.length/2];
        }
        return sum;
    }

}