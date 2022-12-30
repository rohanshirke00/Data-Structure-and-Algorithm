
// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/

import java.util.Scanner;

public class CellsWithOddvalues {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of 2D array m X n : ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int indices[][] = {
            {0,1},
            {1,1}
        };
        
        System.out.print("Number of odd values is : " + oddCells(m, n, indices));

    }

    //solution 1
    public static int oddCells(int m, int n, int[][] indices) {

        int mat[][] = new int[m][n];
        int row=indices.length;
        int col=indices[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=0;
            }
        }
        
        for(int i=0;i<row;i++){
            int row_inc=indices[i][0];
            int col_inc=indices[i][1];
            for(int c=0;c<n;c++){
                mat[row_inc][c]++;
            }
            for(int r=0;r<m;r++){
                mat[r][col_inc]++;
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]%2!=0)
                    count++;
            }
        }
        return count;
    }

    
    /*
    
    //solution 2
    public static int oddCells(int m, int n, int[][] indices) {
        int[] r=new int[m];
        int[] c=new int[n];

        int len=indices.length;
        for(int i=0;i<len;i++){
            r[indices[i][0]]++;
            c[indices[i][1]]++;
            
            
        }
        int[][] arr=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=r[i]+c[j];
                if(arr[i][j]%2!=0){
                    count++;
                }
            }
        }
        return count;
    }
        
    */
}