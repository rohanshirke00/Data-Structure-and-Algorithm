
// https://leetcode.com/problems/spiral-matrix-ii/

import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrixII {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        
        int arr[][] = generateMatrix(n);
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

    }

    public static int[][] generateMatrix(int n) {
        
        int T,B,L,R,dir;
        T=0;
        B=n-1;
        L=0;
        R=n-1;
        dir=0;
        int val = 1;
        int i;
        int[][] A =new int[n][n];

        while(T<=B && L<=R)
        {
            if(dir==0)
            {
                for(i=L;i<=R;i++)
                    A[T][i] = val++;
                T++;
            }
            else if(dir==1)
            {
                for(i=T;i<=B;i++)
                    A[i][R] = val++;
                R--;
            }
            else if(dir==2)
            {
                for(i=R;i>=L;i--)
                    A[B][i] = val++;
                B--;
            }
            else if(dir==3)
            {
                for(i=B;i>=T;i--)
                    A[i][L] = val++;
                L++;
            }
            dir=(dir+1)%4;
        }
        return A;
    }
}
