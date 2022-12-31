
// https://leetcode.com/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
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

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Spiral Matrix order :" + spiralOrder(arr));

    }


    public static List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();

        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length - 1;

        while((left<=right) && (top<=bottom))
        {
            for(int i=left; i<=right; i++)
                list.add(matrix[top][i]);
            
            top++;
            
            for(int i=top; i<=bottom; i++)
                list.add(matrix[i][right]);
            
            right--;
            
            if(top<=bottom)
            {
                for(int i=right; i>=left; i--)
                list.add(matrix[bottom][i]);
            
                bottom--;
            }
            
            if(left<=right)
            {
                for(int i=bottom; i>=top; i--)
                list.add(matrix[i][left]);
            
                left++;
            }
                
        }

        return list;
    }


}
